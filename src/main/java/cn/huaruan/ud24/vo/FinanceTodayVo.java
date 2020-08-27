package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.FinanceTimely;
import cn.huaruan.ud24.query.entity.FinanceToday;
import lombok.Data;


/**
 * @author csr
 */
@Data
public class FinanceTodayVo {

    private FinanceToday financeToday;
    private FinanceTimely financeTimely;

}
