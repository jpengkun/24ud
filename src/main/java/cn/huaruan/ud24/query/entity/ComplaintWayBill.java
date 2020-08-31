package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ComplaintWayBill
 * @Description TODO
 * @Author zdf82
 * @Date 2020/8/31 21:24
 **/
@Data
@ApiModel("申诉及订单信息")
public class ComplaintWayBill {

    private Complaint complaint;

    private TimelyWaybill timelyWaybill;
}
