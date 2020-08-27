package cn.huaruan.ud24.application.config.weixin;

import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.wxa.WeixinAppFacade;

public class TodaysWxAppFacade extends WeixinAppFacade {

    public TodaysWxAppFacade(WeixinAccount weixinAccount) {
        super(weixinAccount);
    }
}
