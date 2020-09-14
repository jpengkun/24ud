package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CourierEvaluation
 * @Description TODO
 * @Author zdf82
 * @Date 2020/9/9 13:59
 **/
@Data
public class CourierEvaluation implements Serializable {

    @ApiModelProperty(value ="快递员名字")
    private String courierName;

    public CourierEvaluation(String courierName) {
        this.courierName = courierName;
    }

    public CourierEvaluation() {
    }
}
