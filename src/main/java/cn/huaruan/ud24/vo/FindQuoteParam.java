package cn.huaruan.ud24.vo;

import lombok.Data;
import org.springframework.data.geo.Point;


@Data
public class FindQuoteParam {

    private String orgId;
    private Point point;
}

