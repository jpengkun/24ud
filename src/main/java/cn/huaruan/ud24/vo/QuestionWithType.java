package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.QuestionWaybill;
import lombok.Data;

@Data
public class QuestionWithType extends QuestionWaybill {
    private String typeContent;
}
