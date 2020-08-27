package cn.huaruan.ud24.application.common;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Date;


public class JsonUtils {

    /**
     * 拼通用报文(json)
     *
     * @return
     * @throws Exception
     */

    public static String getSendToTaxJson(String interfaceCode, String fpqqlsh, String nsrsbh, String fpdm, String fphm, String appid, String contentPassword)
            throws Exception {
        String content = "";
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"interface\": {");
        sb.append("\"globalInfo\": {");
        sb.append("\"appId\": \"").append(appid).append("\",");
        sb.append("\"interfaceId\": \"\",");
        sb.append("\"interfaceCode\": \"").append(interfaceCode).append("\",");
        sb.append("\"requestCode\": \"DZFPQZ\",");
        sb.append("\"requestTime\": \"").append(new Date()).append("\",");
        sb.append("\"responseCode\": \"Ds\",");
        sb.append("\"dataExchangeId\": \"").append("DZFPQZ").append(interfaceCode).append(Utils.formatToDay()).append(Utils.randNineData()).append("\"");
        sb.append("},");
        sb.append("\"returnStateInfo\": {");
        sb.append("\"returnCode\": \"\",");
        sb.append("\"returnMessage\": \"\"");
        sb.append("},");
        sb.append("\"Data\": {");
        sb.append("\"dataDescription\": {");
        sb.append("\"zipCode\": \"0\"");
        sb.append("},");
        sb.append("\"content\": \"");
        if (interfaceCode.equals(Utils.dfxj1001)) {
            content = getUploadContent();
        } else if (interfaceCode.equals(Utils.dfxj1003)) {
            content = getRemainContent(nsrsbh);
        } else if (interfaceCode.equals(Utils.dfxj1004)) {
            content = getSearchContent(nsrsbh, fpqqlsh);
        } else if (interfaceCode.equals(Utils.dfxj1005)) {
            content = getDownloadAddrContent(nsrsbh, fpqqlsh, fpdm, fphm);
        } else if (interfaceCode.equals(Utils.dfxj1009)) {
            content = getZPKJContent(nsrsbh);
        } else if (interfaceCode.equals(Utils.dfxj1010)) {
            content = getCXDQWKPHContent(nsrsbh);
        } else if (interfaceCode.equals(Utils.dfxj1011)) {
            content = getHZSQDContent(nsrsbh);
        } else if (interfaceCode.equals(Utils.dfxj1012)) {
            content = getFPZFContent();
        }
        content = content.replace("\r\n", "").replace("\n", "").replace("\r", "");//json的报文不允许有换行，base64会产生。因此此处做去换行处理。
        sb.append(content).append("\",");
        sb.append("\"contentKey\":\"");
        String contentMD5 = MyAES.MD5(content.getBytes("UTF-8"));
        String contentKey = MyAES.encryptBASE64(MyAES.encrypt(contentMD5.getBytes("UTF-8"), contentPassword)).replaceAll("\r\n", "").replaceAll("\n", "").replace("\r", "");
        sb.append(contentKey).append("\"");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }

    /**
     * 根据加密上传发票内容报文（发票开具）
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getUploadContent() throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_FPKJ\": {");
        content.append("\"FPQQLSH\": \"ESYD" + Utils.formatToTime() + "01" + "\",");
        content.append("\"ZSFS\": \"0\",");
        content.append("\"KPLX\": \"0\",");
        content.append("\"XSF_NSRSBH\": \"9132050931410577X8\",");
        content.append("\"XSF_MC\": \"江苏二四优递生活服务有限公司\",");
        content.append("\"XSF_DZDH\": \"江苏省苏州市吴江区松陵镇人民路450号2幢401\",");
        content.append("\"XSF_YHZH\": \"招商银行股份有限公司吴江支行512908099010606\",");
        content.append("\"GMF_NSRSBH\": \"\",");
        content.append("\"GMF_MC\": \"李子豪\",");
        content.append("\"GMF_DZDH\": \"购买方地址、电话\",");
        content.append("\"GMF_YHZH\": \"购买方银行账号\",");
        content.append("\"GMF_SJH\": \"\",");
        content.append("\"GMF_DZYX\": \"\",");
        content.append("\"FPT_ZH\": \"\",");
        content.append("\"WX_OPENID\": \"\",");
        content.append("\"KPR\": \"管理员\",");
        content.append("\"SKR\": \"\",");
        content.append("\"FHR\": \"\",");
        content.append("\"YFP_DM\": \"\",");
        content.append("\"YFP_HM\": \"\",");
        content.append("\"JSHJ\": \"10.3\",");
        content.append("\"HJJE\": \"10\",");
        content.append("\"HJSE\": \"0.3\",");
        content.append("\"KCE\": \"\",");
        content.append("\"BZ\": \"json测试开票备注\",");
        content.append("\"HYLX\": \"\",");
        content.append("\"BY1\": \"\",");
        content.append("\"BY2\": \"\",");
        content.append("\"BY3\": \"\",");
        content.append("\"BY4\": \"\",");
        content.append("\"BY5\": \"\",");
        content.append("\"BY6\": \"\",");
        content.append("\"BY7\": \"\",");
        content.append("\"BY8\": \"\",");
        content.append("\"BY9\": \"\",");
        content.append("\"BY10\": \"\",");
        content.append("\"WX_ORDER_ID\": \"\",");
        content.append("\"WX_APP_ID\": \"\",");
        content.append("\"ZFB_UID\": \"\",");
        content.append("\"COMMON_FPKJ_XMXXS\": {");
        content.append("\"COMMON_FPKJ_XMXX\": [{");
        content.append("\"FPHXZ\": \"0\",");
        content.append("\"SPBM\": \"3079900000000000000\",");
        content.append("\"ZXBM\": \"\",");
        content.append("\"YHZCBS\": \"\",");
        content.append("\"LSLBS\": \"\",");
        content.append("\"ZZSTSGL\": \"\",");
        content.append("\"XMMC\": \"同城配送服务费\",");
        content.append("\"GGXH\": \"无\",");
        content.append("\"DW\": \"次\",");
        content.append("\"XMSL\": \"\",");
        content.append("\"XMDJ\": \"\",");
        content.append("\"XMJE\": \"10\",");
        content.append("\"SL\": \"0.03\",");
        content.append("\"SE\": \"0.3\",");
        content.append("\"BY1\": \"\",");
        content.append("\"BY2\": \"\",");
        content.append("\"BY3\": \"\",");
        content.append("\"BY4\": \"\",");
        content.append("\"BY5\": \"\"}]");
        content.append("}");
        content.append("}");
        content.append("}");
        content.append("}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }

    /**
     * 获取加密查询报文内容(发票查询报文)
     *
     * @param fpqqlsh
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getSearchContent(String nsrsbh, String fpqqlsh)
            throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_FPCX\":{");
        content.append("\"FPQQLSH\":\"").append(fpqqlsh).append("\",");
        content.append("\"XSF_NSRSBH\":\"").append(nsrsbh).append("\"}}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }

    /**
     * 获取加密查询报文内容(发票结余报文)
     *
     * @param nsrsbh
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getRemainContent(String nsrsbh)
            throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_FPKCCX\":{");
        content.append("\"NSRSBH\":\"").append(nsrsbh).append("\"}}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }

    /**
     * 获取加密查询报文内容(发票下载地址查询)
     *
     * @param nsrsbh
     * @param fpqqlsh
     * @param fpdm
     * @param fphm
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getDownloadAddrContent(String nsrsbh, String fpqqlsh, String fpdm, String fphm)
            throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_FPXZDZCX\":{");
        content.append("\"FPQQLSH\":\"").append(fpqqlsh).append("\",");
        content.append("\"NSRSBH\":\"").append(nsrsbh).append("\",");
        content.append("\"FP_DM\":\"").append(nsrsbh).append("\",");
        content.append("\"FP_HM\":\"").append(nsrsbh).append("\"}}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }


    /**
     * 根据加密上传发票内容报文（纸质发票开具）
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getZPKJContent(String nsrsbh) throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_ZZFPKJ\": {");
        content.append("\"KPZDBS\": \"1655kpzd1\",");
        content.append("\"FPLXDM\": \"007\",");
        content.append("\"FPQQLSH\":  \"TEST" + Utils.formatToTime() + "01" + "\",");
        content.append("\"KPLX\": \"0\",");
        content.append("\"TSPZ\": \"00\",");
        content.append("\"XSF_NSRSBH\": \"" + nsrsbh + "\",");
        content.append("\"XSF_MC\": \"百旺电子测试2\",");
        content.append("\"XSF_DZDH\": \"销售方地址电话\",");
        content.append("\"XSF_YHZH\": \"销售方银行帐号\",");
        content.append("\"GMF_NSRSBH\": \"\",");
        content.append("\"GMF_MC\": \"购买方名称\",");
        content.append("\"GMF_DZDH\": \"购买方地址电话\",");
        content.append("\"GMF_YHZH\": \"购买方银行帐号\",");
        content.append("\"QDBZ\": \"0\",");
        content.append("\"ZSFS\": \"0\",");
        content.append("\"COMMON_FPKJ_XMXXS\": {");
        content.append("\"COMMON_FPKJ_XMXX\": [{");
        content.append("\"FPHXZ\": \"0\",");
        content.append("\"XMMC\": \"商品名称\",");
        content.append("\"SPSM\": \"\",");
        content.append("\"GGXH\": \"规格型号\",");
        content.append("\"DW\": \"单位\",");
        content.append("\"XMSL\": \"1\",");
        content.append("\"XMDJ\": \"1\",");
        content.append("\"XMJE\": \"1\",");
        content.append("\"SL\": \"0.13\",");
        content.append("\"SE\": \"0.13\",");
        content.append("\"HSBZ\": \"0\",");
        content.append("\"SPBM\": \"1020101000000000000\",");
        content.append("\"ZXBM\": \"\",");
        content.append("\"YHZCBS\": \"\",");
        content.append("\"LSLBS\": \"\",");
        content.append("\"ZZSTSGL\": \"\"");
        content.append("},{");
        content.append("\"FPHXZ\": \"0\",");
        content.append("\"XMMC\": \"小麦\",");
        content.append("\"SPSM\": \"\",");
        content.append("\"GGXH\": \"规格型号\",");
        content.append("\"DW\": \"单位\",");
        content.append("\"XMSL\": \"1\",");
        content.append("\"XMDJ\": \"1\",");
        content.append("\"XMJE\": \"1\",");
        content.append("\"SL\": \"0.09\",");
        content.append("\"SE\": \"0.09\",");
        content.append("\"HSBZ\": \"0\",");
        content.append("\"SPBM\": \"1010101020000000000\",");
        content.append("\"ZXBM\": \"\",");
        content.append("\"YHZCBS\": \"\",");
        content.append("\"LSLBS\": \"\",");
        content.append("\"ZZSTSGL\": \"\"");
        content.append("}]");
        content.append("},");
        content.append("\"HJJE\": \"2\",");
        content.append("\"HJSE\": \"0.22\",");
        content.append("\"JSHJ\": \"2.22\",");
        content.append("\"KCE\": \"\",");
        content.append("\"BZ\": \"json备注\",");
        content.append("\"SKR\": \"收款人\",");
        content.append("\"FHR\": \"复核人\",");
        content.append("\"KPR\": \"开票人\",");
        content.append("\"TZDBH\": \"\",");
        content.append("\"YFP_DM\": \"\",");
        content.append("\"YFP_HM\": \"\"");
        content.append("}");
        content.append("}");

        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }

    /**
     * 查询当前未开票号
     *
     * @param nsrsbh
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getCXDQWKPHContent(String nsrsbh)
            throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_CXDQWKPH\":{");
        content.append("\"KPZDBS\":\"1655kpzd1\",");
        content.append("\"NSRSBH\":\"").append(nsrsbh).append("\",");
        content.append("\"FPLXDM\":\"007\"}}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }

    /**
     * 红字发票申请与查询(专票接口)
     *
     * @param nsrsbh
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getHZSQDContent(String nsrsbh)
            throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_HZFPSQ\": {");
        content.append("\"NSRSBH\": \"" + nsrsbh + "\",");
        content.append("\"FPLXDM\": \"004\",");
        content.append("\"YFP_DM\": \"1100098083\",");
        content.append("\"YFP_HM\": \"31430038\",");
        content.append("\"KPZDDM\": \"1655kpzd1\",");
        content.append("\"SQYY\": \"2\",");
        content.append("\"YWLX\": \"1\",");
        content.append("\"SQRMC\": \"申请人名称\",");
        content.append("\"SQJGMC\": \"申请机构名称\",");
        content.append("\"LXFS\": \"联系方式\",");
        content.append("\"XSF_NSRSBH\": \"" + nsrsbh + "\",");
        content.append("\"XSF_MC\": \"百旺电子测试2\",");
        content.append("\"GMF_NSRSBH\": \"110109500321654\",");
        content.append("\"GMF_MC\": \"购货单位名称\",");
        content.append("\"ZDBZ\": \"2\"}}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }

    /**
     * 发票作废接口
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getFPZFContent()
            throws UnsupportedEncodingException {
        StringBuffer content = new StringBuffer("{");
        content.append("\"REQUEST_COMMON_FPZF\": {");
        content.append("\"FPQQLSH\": \"TEST2019070410555803\",");
        content.append("\"NSRSBH\": \"9132050931410577X8\",");
        content.append("\"KPZDBS\": \"esyd\",");
        content.append("\"FPLXDM\": \"026\",");
        content.append("\"ZFLX\": \"1\",");
        content.append("\"FP_DM\": \"032001700511\",");
        content.append("\"FP_HM\": \"73619189\",");
        content.append("\"HJJE\": \"9.00\",");
        content.append("\"ZFR\": \"作废人\",");
        content.append("\"ZFYY\": \"作废原因\"}}");
        return new BASE64Encoder().encodeBuffer(content.toString().getBytes("UTF-8"));
    }
}
