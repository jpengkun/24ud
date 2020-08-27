package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class MessageWithUserIds extends Message {
    @JsonIgnore
    List<String> userIds;
}
