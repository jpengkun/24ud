package cn.huaruan.ud24.application.query;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页参数。
 *
 * @author outas
 **/
public class PageParam {

    @ApiModelProperty(value = "要查询的页数，第一页为0，可不传", example = "0")
    private Integer page = 0;

    @ApiModelProperty(value = "每页要查询的数量，不写默认10", example = "10")
    private Integer limit = 10;

    @ApiModelProperty(hidden = true)
    private Integer offset = 0;

    public PageParam() {
    }

    public PageParam(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
        this.offset = page * limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return this.page * this.limit;
    }

    public void upPaged() {
        this.limit = null;
        this.page = null;
        this.offset = null;
    }
}
