package cn.huaruan.ud24.application.query;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

/**
 * 分页数据。
 *
 * @author outas
 **/
public class Page<T> {
    private long total;

    @ApiModelProperty("月总运费")
    private BigDecimal totalAmount;

    private List<T> rows;

    public Page() {
    }



    public Page(List<T> rows) {
        if (rows == null) {
            return;
        }
        this.rows = rows;
        this.total = rows.size();
    }

    public Page(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Page(long total, List<T> rows,BigDecimal totalAmount) {
        this.total = total;
        this.rows = rows;
        this.totalAmount = totalAmount;
    }

    public Page(com.github.pagehelper.Page page) {
        this.total = page.isCount() ? page.getTotal() : page.size();
        this.rows = page;
    }

    public long getTotal() {
        return total;
    }

    public Page<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public List<T> getRows() {
        return rows;
    }

    public Page<T> setRows(List<T> rows) {
        this.rows = rows;
        return this;
    }

    public Page<T> forEach(Consumer<T> consumer) {
        if (rows != null && rows.size() > 0) {
            this.rows.forEach(consumer);
        }
        return this;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
