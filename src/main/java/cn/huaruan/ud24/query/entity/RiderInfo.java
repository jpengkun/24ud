package cn.huaruan.ud24.query.entity;


import lombok.Data;

import java.util.Date;

@Data
public class RiderInfo {
    private String id;

    private String name;

    private String smallShopName;

    private Date closedTime;
}
