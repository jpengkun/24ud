package cn.huaruan.ud24.application.common;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.vo.SendMsgParam;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author user
 */
public class SmsUtils {

    /**
     * KEY为自定义秘钥
     */
    private static final String KEY = "UD24";

    private static final String HTTP_URL = "http://api.smsbao.com/sms";

    private static final String USERNAME = "esud";

    private static final String PASSWORD = "24ud666666";

    private static final String COMPANY = "二四优递";

    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = reader.readLine();
            if (strRead != null) {
                sbf.append(strRead);
                while ((strRead = reader.readLine()) != null) {
                    sbf.append("\n");
                    sbf.append(strRead);
                }
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null)
            return str;
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }

    public static SendMsgParam sendCode(String phone) {
        SendMsgParam sendMsgParam = new SendMsgParam();
        // 生成随机数
        String randomNum = (int) ((Math.random() * 9 + 1) * 100000) + "";
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 60);
        // 生成15分钟后时间，用户校验是否过期
        String currentTime = sf.format(c.getTime());
        // 注意测试时，也请带上公司简称或网站签名，发送正规内容短信。千万不要发送无意义的内容：例如 测一下、您好。否则可能会收不到
        String content = "【二四优递】您的验证码是" + randomNum + "。请于15分钟内完成验证，若非本人操作，请忽略本短信。" + COMPANY;
        AppAsserts.yes(sendMsg(phone, content).equals("0"), "短信发送失败");
        //生成MD5值
        String hash = MD5Util.GetMD5Code(KEY + "@" + currentTime + "@" + randomNum);
        sendMsgParam.setPhone(phone);
        sendMsgParam.setHash(hash);
        sendMsgParam.setTamp(currentTime);
        return sendMsgParam;
    }

    public static String sendMsg(String phone, String content) {
        StringBuffer httpArg = new StringBuffer();
        httpArg.append("u=").append(USERNAME).append("&");
        httpArg.append("p=").append(SmsUtils.md5(PASSWORD)).append("&");
        httpArg.append("m=").append(phone).append("&");
        httpArg.append("c=").append(SmsUtils.encodeUrlString(content, "UTF-8"));
        return SmsUtils.request(HTTP_URL, httpArg.toString());
    }

    public static void validate(SendMsgParam sendMsgParam) {
        String requestHash = sendMsgParam.getHash();
        String tamp = sendMsgParam.getTamp();
        String msgNum = sendMsgParam.getMsgNum();
        String hash = MD5Util.GetMD5Code(KEY + "@" + tamp + "@" + msgNum);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        String currentTime = sf.format(c.getTime());
        ResultMessage<Object> resultMessage = new ResultMessage<>();
        if (tamp.compareTo(currentTime) > 0) {
            if (hash.equalsIgnoreCase(requestHash)) {
                //校验成功
                return;
            } else {
                //验证码不正确，校验失败
                AppAsserts.no(true,"验证码不正确");
            }
        } else {
            // 超时
            AppAsserts.no(true,"超时");
        }
    }
}
