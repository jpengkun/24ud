package cn.huaruan.ud24.constant;

import cn.huaruan.ud24.application.config.JpushConfig;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author huanghm
 */
@Service
public class JpushUtils {

    @Resource
    JpushConfig jpushConfig;

    public void jpushAll(Map<String,String> parm){
        //创建JPush客户端
        JPushClient jPushClient = new JPushClient(jpushConfig.getMasterSecret(), jpushConfig.getAppkey());
        //创建option

        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId(parm.get("RegId")))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(parm.get("msg"))
                                .incrBadge(1)
                                .addExtras(parm)
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtras(parm)
                                .setAlert(parm.get("msg"))
                                .build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(false).build())
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())
                .build();

            try {
                PushResult pu = jPushClient.sendPush(payload);
            } catch (APIConnectionException e) {
                e.printStackTrace();
            } catch (APIRequestException e) {
                e.printStackTrace();
            }

    }

    /**
     * 发送自定义消息，由APP端拦截信息后再决定是否创建通知(目前APP用此种方式)
     *
     * @param title     App通知栏标题
     * @param content   App通知栏内容（为了单行显示全，尽量保持在22个汉字以下）
     * @param extrasMap 额外推送信息（不会显示在通知栏，传递数据用）
     * @param alias     别名数组，设定哪些用户手机能接收信息（为空则所有用户都推送）
     * @return PushResult
     */
    public PushResult sendPush(String title, String content,Integer type, Map<String, String> extrasMap,String[] registrationId, String... alias) throws APIConnectionException, APIRequestException {
        ClientConfig clientConfig = ClientConfig.getInstance();
        clientConfig.setTimeToLive(Long.parseLong(jpushConfig.getLiveTime()));
        // 使用NativeHttpClient网络客户端，连接网络的方式，不提供回调函数
        JPushClient jpushClient = new JPushClient(jpushConfig.getMasterSecret(), jpushConfig.getAppkey(), null,
                clientConfig);
        // 设置为消息推送方式为仅推送消息，不创建通知栏提醒
        PushPayload payload = null;
        PushResult result = null;
        if (null != type){
            switch (type){
                case 0:
                    payload = jPushAndroid(title, content, extrasMap,registrationId, alias);
                    break;
                case 1:
                    payload =jPushIos(title, content, extrasMap,registrationId, alias);
                    break;
                default:
                    payload = jPushAll(title, content, extrasMap,registrationId, alias);
                    break;
            }
           result = jpushClient.sendPush(payload);
        }
        return result;
    }


    /**
     * 构建Android的自定义消息的推送消息对象
     *
     * @return PushPayload
     */
    public PushPayload jPushAndroid(String title, String content, Map<String, String> extrasMap,String[]registrationId, String... alias) {
        // 批量删除数组中空元素
        String[] newAlias = removeArrayEmptyElement(alias);
        return PushPayload.newBuilder().setPlatform(Platform.android())
                //registrationId指定用户
                .setAudience(Audience.registrationId(registrationId))
                /*.setAudience((null == newAlias || newAlias.length == 0) ? Audience.all() : Audience.alias(alias))*/
                .setNotification(Notification.newBuilder().setAlert(content)
                        .addPlatformNotification(AndroidNotification.newBuilder().setTitle(title).addExtras(extrasMap).build()).build())
                /*.setMessage(Message.newBuilder().setTitle(title).setMsgContent(content).addExtras(extrasMap).build())*/
                .build();
    }

    /**
     * 构建IOS的自定义消息的推送消息对象
     *
     * @return PushPayload
     */
    public PushPayload jPushIos(String title, String content, Map<String, String> extrasMap,String[]registrationId, String... alias) {
        // 批量删除数组中空元素
        String[] newAlias = removeArrayEmptyElement(alias);
        return PushPayload.newBuilder().setPlatform(Platform.ios())
                //registrationId指定用户
                .setAudience(Audience.registrationId(registrationId))
                /*.setAudience((null == newAlias || newAlias.length == 0) ? Audience.all() : Audience.alias(alias))*/
                .setNotification(Notification.newBuilder().setAlert(content)
                        .addPlatformNotification(IosNotification.newBuilder().addExtras(extrasMap).build()).build())
                .setMessage(Message.newBuilder().setTitle(title).setMsgContent(content).addExtras(extrasMap).build())
                .build();
    }

    /**
     * 构建Android和IOS的自定义消息的推送消息对象
     *
     * @return PushPayload
     */
    public PushPayload jPushAll(String title, String content, Map<String, String> extrasMap,String[]registrationId, String... alias) {
        // 批量删除数组中空元素
        String[] newAlias = removeArrayEmptyElement(alias);
        return PushPayload.newBuilder().setPlatform(Platform.android_ios())
                .setAudience(Audience.registrationId(registrationId))
                /*.setAudience((null == newAlias || newAlias.length == 0) ? Audience.all() : Audience.alias(alias))*/
                .setNotification(Notification.newBuilder().setAlert(content)
                        .addPlatformNotification(IosNotification.newBuilder().setSound("default").addExtras(extrasMap).build())
                        .addPlatformNotification(AndroidNotification.newBuilder().setTitle(title).addExtras(extrasMap).build())
                        .build())
                .setMessage(Message.newBuilder().setTitle(title).setMsgContent(content).addExtras(extrasMap).build())
                .build();

    }

    /**
     * 构建Android和IOS的推送通知对象
     *
     * @return PushPayload
     */
    public PushPayload buildPushPayload(String title, String content, Map<String, String> extrasMap, String... alias) {
        if (extrasMap == null || extrasMap.isEmpty()) {
            extrasMap = new HashMap<String, String>();
        }
        // 批量删除数组中空元素
        String[] newAlias = removeArrayEmptyElement(alias);
        return PushPayload.newBuilder().setPlatform(Platform.android_ios())
                // 别名为空，全员推送；别名不为空，按别名推送
                .setAudience((null == newAlias || newAlias.length == 0) ? Audience.all() : Audience.alias(alias))
                .setNotification(Notification.newBuilder().setAlert(content)
                        .addPlatformNotification(
                                AndroidNotification.newBuilder().setTitle(title).addExtras(extrasMap).build())
                        .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).addExtras(extrasMap).build())
                        .build())
                .build();
    }

    /**
     * 删除别名中的空元素（需删除如：null,""," "）
     *
     * @param strArray
     * @return String[]
     */
    private String[] removeArrayEmptyElement(String... strArray) {
        if (null == strArray || strArray.length == 0) {
            return null;
        }
        List<String> tempList = Arrays.asList(strArray);
        List<String> strList = new ArrayList<String>();
        Iterator<String> iterator = tempList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            // 消除空格后再做比较
            if (null != str && !"".equals(str.trim())) {
                strList.add(str);
            }
        }
        // 若仅输入"",则会将数组长度置为0
        String[] newStrArray = strList.toArray(new String[strList.size()]);
        return newStrArray;
    }
}
