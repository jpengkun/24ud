package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: address_book
* @author outas
* @date 2019-12-18 18:54:05
*/
@Data
@ApiModel("地址簿")
public class AddressBook {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("区/镇")
    private String area;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("纬度")
    private Double latitude;

    @ApiModelProperty("经度")
    private Double longitude;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("OpenId")
    private String openId;

    @ApiModelProperty("0代表发件人，1代表寄件人")
    private Integer state;

    @ApiModelProperty("电话")
    private String phone;
}