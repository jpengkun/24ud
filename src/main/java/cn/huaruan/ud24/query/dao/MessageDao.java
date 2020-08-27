package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.Message;
import cn.huaruan.ud24.query.mapper.MessageMapper;
import cn.huaruan.ud24.vo.FindMessageParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao extends MessageMapper {

    List<Message> findMessage(FindMessageParam findMessageParam);

    long countMessage(FindMessageParam findMessageParam);

    Message getMessage(String messageId);

    long insertMessageUser(@Param("messageId") String messageId,
                           @Param("userIds") List<String> userIds);
}
