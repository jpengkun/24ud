package cn.huaruan.ud24.application.config.weixin;

import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.wxa.WeixinAppFacade;

public class TimelyWxAppFacade extends WeixinAppFacade {

    public TimelyWxAppFacade(WeixinAccount weixinAccount) {
        super(weixinAccount);
    }
}
