package cn.huaruan.ud24.application.config.weixin;

import com.foxinmy.weixin4j.model.WeixinPayAccount;
import com.foxinmy.weixin4j.payment.WeixinPayProxy;

public class TimelyWxPayProxy extends WeixinPayProxy {
    public TimelyWxPayProxy(WeixinPayAccount weixinPayAccount) {
        super(weixinPayAccount);
    }
}
