package cn.huaruan.ud24.application.config.weixin;

import com.foxinmy.weixin4j.http.weixin.WeixinRequestExecutor;
import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.model.WeixinPayAccount;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.mp.token.WeixinTokenCreator;
import com.foxinmy.weixin4j.payment.WeixinPayProxy;
import com.foxinmy.weixin4j.sign.WeixinPaymentSignature;
import com.foxinmy.weixin4j.sign.WeixinSignature;
import com.foxinmy.weixin4j.wxa.WeixinAppFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeixinConfig {

    private final static String APP_ID = "wx6e653727bd358fe0";

    private final static String SECRET = "2f5da05922c06832c9c22eae5a47d99b";

    private final static String TO_APP_ID = "wx07cb1516397009c4";

    private final static String TO_SECRET = "bdcdc395f98c6ccd7182d7ee706f246f";

    private final static String TI_APP_ID = "wxe81d5017bd4fd74b";

    private final static String TI_SECRET = "754992d3ba982f2f79388a6be1ded636";

    private final static String MCH_ID = "1533602361";

    private final static String PAY_SIGN_KEY = "24Ud88888824Ud88888824Ud88888824";

    @Bean
    public WeixinAccount weixinAccount() {
        return new WeixinAccount(APP_ID, SECRET);
    }

    @Bean
    public WeixinPayAccount weixinPayAccount() {
        return new WeixinPayAccount(APP_ID, PAY_SIGN_KEY, MCH_ID);
    }

    @Bean
    public WeixinSignature weixinSignature() {
        return new WeixinPaymentSignature(PAY_SIGN_KEY);
    }

    @Bean
    public WeixinProxy weixinProxy() {
        return new WeixinProxy();
    }

    @Bean
    public WeixinPayProxy weixinPayProxy() {
        return new WeixinPayProxy();
    }

    @Bean
    public WeixinRequestExecutor weixinRequestExecutor() {
        return new WeixinRequestExecutor();
    }

    @Bean
    public WeixinTokenCreator weixinTokenCreator() {
        return new WeixinTokenCreator(APP_ID, SECRET);
    }

    @Bean
    public WeixinAppFacade weixinAppFacade() {
        return new WeixinAppFacade(weixinAccount());
    }

    private WeixinAccount todaysWxAccount() {
        return new WeixinAccount(TO_APP_ID, TO_SECRET);
    }

    @Bean
    public TodaysWxAppFacade todaysAppFacade() {
        return new TodaysWxAppFacade(todaysWxAccount());
    }

    private WeixinAccount timelyWxAccount() {
        return new WeixinAccount(TI_APP_ID, TI_SECRET);
    }

    @Bean
    public TimelyWxAppFacade timelyAppFacade() {
        return new TimelyWxAppFacade(timelyWxAccount());
    }

    @Bean
    public TimelyWxPayProxy timelyWxPayProxy() {
        return new TimelyWxPayProxy(new WeixinPayAccount(TI_APP_ID, PAY_SIGN_KEY, MCH_ID));
    }
}
