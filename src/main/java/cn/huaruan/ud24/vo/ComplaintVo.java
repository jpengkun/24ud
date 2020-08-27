package cn.huaruan.ud24.vo;


import cn.huaruan.ud24.query.entity.Complaint;
import cn.huaruan.ud24.query.entity.ComplaintLogs;
import lombok.Data;

@Data
public class ComplaintVo {

    private Complaint complaint;

    private ComplaintLogs complaintLogs;
}
