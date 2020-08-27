package cn.huaruan.ud24.controller;


import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.JwtUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.config.weixin.TimelyWxAppFacade;
import cn.huaruan.ud24.application.config.weixin.TimelyWxPayProxy;
import cn.huaruan.ud24.application.exception.AppRunException;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.constant.LoginUserType;
import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.service.TimelyCourierService;
import cn.huaruan.ud24.service.TimelyWaybillService;
import cn.huaruan.ud24.service.TodaysWaybillService;
import cn.huaruan.ud24.vo.TimelyWbWithLogs;
import cn.huaruan.ud24.vo.TodaysWbWithLogs;
import cn.huaruan.ud24.vo.WaybillVo;
import cn.huaruan.ud24.vo.WxPayNotifyResult;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.payment.PayRequest;
import com.foxinmy.weixin4j.payment.WeixinPayProxy;
import com.foxinmy.weixin4j.payment.mch.*;
import com.foxinmy.weixin4j.sign.WeixinSignature;
import com.foxinmy.weixin4j.type.SignType;
import com.foxinmy.weixin4j.wxa.WeixinAppFacade;
import com.foxinmy.weixin4j.wxa.model.Session;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author outas
 */
@RestController
@AllArgsConstructor
@RequestMapping("/wx")
@Api(tags = "微信")
@Log4j2
public class WxController {

    private final String BASE_URL = "https://api.24ud.cn/wx";

    private final String BODY = "二四优递同城配送-服务费";

    private final String DEPOSIT_BODY = "二四优递同城配送-骑手认证押金";

    private final String TODAYS_WB_PAY_CALLBACK_URL = BASE_URL + "/todays/pay/notify/";

    private final String TIMELY_WB_PAY_CALLBACK_URL = BASE_URL + "/timely/pay/notify/";

    private final String TIMELY_DEPOSIT_PAY_CALLBACK_URL = BASE_URL + "/timely/pay/deposit/notify/";

    private final WeixinAppFacade weixinAppFacade;

    private final TimelyWxAppFacade timelyWxAppFacade;

    private final WeixinPayProxy weixinPayProxy;

    private final TimelyWxPayProxy timelyWxPayProxy;

    private final WeixinSignature weixinSignature;

    private final TodaysWaybillService todaysWaybillService;

    private final TimelyWaybillService timelyWaybillService;

    private final TimelyCourierService timelyCourierService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @GetMapping("/code2session")
    public ResultMessage code2session(String jsCode, HttpServletResponse response) {
        Session session;
        try {
            session = weixinAppFacade.getLoginApi().jscode2session(jsCode);
        } catch (WeixinException e) {
            throw new AppRunException("获取openId失败，请检查参数！");
        }
        String username = LoginUserType.GUEST.name() + session.getOpenId();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, "123456"));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.createJWT(true, "-1", username);
        response.setHeader("Authorization", "Bearer " + jwt);
        return new ResultMessage<>().data(session.getOpenId());
    }

    @GetMapping("/timely/openId")
    public ResultMessage code2openId(String jsCode) {
        Session session;
        try {
            session = timelyWxAppFacade.getLoginApi().jscode2session(jsCode);
        } catch (WeixinException e) {
            throw new AppRunException("获取openId失败，请检查参数！");
        }
        return new ResultMessage<>().data(session.getOpenId());
    }

    @GetMapping("/pay")
    public ResultMessage jsPay(Integer payType, String wbId, Integer category, HttpServletRequest request) {
        AppAsserts.notNull(category, "请选择运单类型1当日达 2即时达");
        WaybillVo waybill = getWaybill(wbId, category);
        PayRequest payRequest = null;
        try {
            if (payType == 1) {
                // 小程序支付
                MchPayRequest jsPayRequest = weixinPayProxy.createJSPayRequest(waybill.getOpenId(),
                        BODY, wbId, waybill.getAmount().doubleValue(),
                        category == 1 ? TODAYS_WB_PAY_CALLBACK_URL : TIMELY_WB_PAY_CALLBACK_URL,
                        request.getRemoteAddr(), category == 1 ? "当日达" : "即时达");
                payRequest = jsPayRequest.toRequestObject();
            } else if (payType == 2) {
                // 扫码支付
                MchPayRequest nativePayRequest = weixinPayProxy.createNativePayRequest(waybill.getNo(),
                        BODY, wbId, waybill.getAmount().doubleValue(),
                        category == 1 ? TODAYS_WB_PAY_CALLBACK_URL : TIMELY_WB_PAY_CALLBACK_URL,
                        request.getRemoteAddr(), category == 1 ? "当日达" : "即时达");
                payRequest = nativePayRequest.toRequestObject();
                payRequest.setSignType(SignType.MD5);
                payRequest.setPaySign(weixinSignature.sign(payRequest));
            }
            return new ResultMessage<>(payRequest);
        } catch (WeixinException e) {
            throw new AppRunException("创建与支付订单失败，请检查参数！");
        }
    }

    private WaybillVo getWaybill(String wbId, Integer category) {
        WaybillVo waybillVo = new WaybillVo();
        if (category == 1) {
            TodaysWbWithLogs byId = todaysWaybillService.findById(wbId);
            if (byId != null) {
                QueryUtils.copyProperties(byId, waybillVo);
                waybillVo.setNo(byId.getTdNo());
            }
        } else {
            TimelyWbWithLogs byId = timelyWaybillService.findById(wbId);
            if (byId != null) {
                QueryUtils.copyProperties(byId, waybillVo);
                waybillVo.setNo(byId.getTmNo());
            }
        }
        AppAsserts.hasText(waybillVo.getId(), "请确认订单号是否正确");
        AppAsserts.hasText(waybillVo.getOpenId(), "此订单不是小程序下单，无法支付");
        AppAsserts.notNull(waybillVo.getAmount(), "金额错误");
        AppAsserts.yes(waybillVo.getConfirm(), "请先确认重量");
        return waybillVo;
    }

    @PostMapping("/todays/pay/notify")
    public void todaysPayNotify(@RequestBody WxPayNotifyResult wxPayNotifyResult) {
        log.info("==========微信支付回调（当日达）============：" + wxPayNotifyResult);
        if (WxPayNotifyResult.PAY_SUCCESS.equals(wxPayNotifyResult.getResultCode())) {
            todaysWaybillService.pay(wxPayNotifyResult.getOutTradeNo());
        }
    }

    @PostMapping("/timely/pay/notify")
    public void timelyPayNotify(@RequestBody WxPayNotifyResult wxPayNotifyResult) {
        log.info("==========微信支付回调（即时达）============：" + wxPayNotifyResult);
        if (WxPayNotifyResult.PAY_SUCCESS.equals(wxPayNotifyResult.getResultCode())) {
            timelyWaybillService.pay(wxPayNotifyResult.getOutTradeNo());
        }
    }

    @GetMapping("/timely/deposit")
    public ResultMessage deposit(String courierId, String openId, HttpServletRequest request) {
        AppAsserts.hasText(openId, "openId不能为空！");
        TimelyCourier courier = timelyCourierService.findById(courierId);
        AppAsserts.notNull(courier, "快递员不存在！请确认id后重试！");
        try {
            MchPayRequest jsPayRequest = timelyWxPayProxy.createJSPayRequest(openId,
                    DEPOSIT_BODY, courierId, 0.01, TIMELY_DEPOSIT_PAY_CALLBACK_URL,
                    request.getRemoteAddr(), "即时达");
            return new ResultMessage<>(jsPayRequest.toRequestObject());
        } catch (WeixinException e) {
            e.printStackTrace();
            throw new AppRunException("创建与支付订单失败，请检查参数！");
        }
    }

    @PostMapping("/timely/pay/deposit/notify")
    public void timelyPayDepositNotify(@RequestBody WxPayNotifyResult wxPayNotifyResult) {
        log.info("==========微信支付回调（即时达骑手押金）============：" + wxPayNotifyResult);
        if (WxPayNotifyResult.PAY_SUCCESS.equals(wxPayNotifyResult.getResultCode())) {
            timelyCourierService.deposit(wxPayNotifyResult.getOutTradeNo());
        }
    }

}
