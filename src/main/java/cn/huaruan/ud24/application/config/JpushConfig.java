package cn.huaruan.ud24.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huanghm
 */
@Component("jpushConfig")
public class JpushConfig {

    /**
     * 极光推送的用户名
     */
    @Value("${jpush.appKey}")
    private String appkey;
    /**
     * 极光推送的密码
     */
    @Value("${jpush.masterSecret}")
    private String masterSecret;
    /**
     * 极光推送设置过期时间
     */
    @Value("${jpush.liveTime}")
    private String liveTime;


    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getMasterSecret() {
        return masterSecret;
    }

    public void setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
    }

    public String getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime;
    }
}
