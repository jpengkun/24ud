package cn.huaruan.ud24.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data

public class WxPayNotifyResult {
    @XmlElement(name = "appid")
    private String appid;

    @XmlElement(name = "attach")
    private String attach;

    @XmlElement(name = "bank_type")
    private String bankType;

    @XmlElement(name = "cash_fee")
    private String cashFee;

    @XmlElement(name = "fee_type")
    private String feeType;

    @XmlElement(name = "is_subscribe")
    private String isSubscribe;

    @XmlElement(name = "mch_id")
    private String mchId;

    @XmlElement(name = "nonce_str")
    private String nonceStr;

    @XmlElement(name = "openid")
    private String openid;

    @XmlElement(name = "out_trade_no")
    private String outTradeNo;

    @XmlElement(name = "result_code")
    private String resultCode;

    @XmlElement(name = "return_code")
    private String returnCode;

    @XmlElement(name = "sign")
    private String sign;

    @XmlElement(name = "time_end")
    private String timeEnd;

    @XmlElement(name = "total_fee")
    private String totalFee;

    @XmlElement(name = "trade_type")
    private String tradeType;

    @XmlElement(name = "transaction_id")
    private String transactionId;

    public static String PAY_SUCCESS = "SUCCESS";
}
