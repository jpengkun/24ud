package cn.huaruan.ud24.vo;

import lombok.Data;

import java.util.List;

@Data
public class ImportResult {

    Integer successCount;

    List<ImportFailedWbMsg> failedWbMsgList;
}
