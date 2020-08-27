package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.PageParam;
import cn.huaruan.ud24.query.dao.MessageDao;
import cn.huaruan.ud24.query.entity.Message;
import cn.huaruan.ud24.query.entity.MessageExample;
import cn.huaruan.ud24.vo.FindMessageParam;
import cn.huaruan.ud24.vo.MessageWithUserIds;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class MessageService {

    private final MessageDao messageDao;

    private final BCryptPasswordEncoder passwordEncoder;


    public Page<Message> findMessage(FindMessageParam findMessageParam) {
        return new Page<>(messageDao.countMessage(findMessageParam),
                messageDao.findMessage(findMessageParam));
    }

    public Page<Message> findNotReadByUserId(String userId, PageParam pageParam) {
        FindMessageParam findMessageParam = new FindMessageParam();
        findMessageParam.setState(0);
        findMessageParam.setUserId(userId);
        findMessageParam.setPage(pageParam.getPage());
        findMessageParam.setLimit(pageParam.getLimit());
        return new Page<>(messageDao.countMessage(findMessageParam),
                messageDao.findMessage(findMessageParam));
    }

    public void addMessage(MessageWithUserIds message) {
        message.setState(0);
        message.setId(UUIDUtil.get());
        message.setCreateTime(new Date());
        messageDao.insert(message);

        messageDao.insertMessageUser(message.getId(),message.getUserIds());
    }

    public void updateMessage(Message message) {
        messageDao.updateByPrimaryKeySelective(message);
    }

    public void deleteMessage(List<String> messageId) {
        AppAsserts.notNull(messageId,"id不能为空");
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andIdIn(messageId);
        messageDao.deleteByExample(messageExample);
    }

    public Message getMessage(String messageId) {
        AppAsserts.notNull(messageId,"id不能为空");
        return messageDao.selectByPrimaryKey(messageId);
    }

    public void read(String messageId){
        AppAsserts.notNull(messageId,"id不能为空");
        Message message = messageDao.selectByPrimaryKey(messageId);
        message.setState(1);
        messageDao.updateByPrimaryKeySelective(message);
    }

}
