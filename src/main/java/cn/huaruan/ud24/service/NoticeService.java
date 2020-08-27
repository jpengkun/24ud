package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.NoticeDao;
import cn.huaruan.ud24.query.entity.Notice;
import cn.huaruan.ud24.query.entity.NoticeExample;
import cn.huaruan.ud24.vo.FindNoticeParam;
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
public class NoticeService {

    private final NoticeDao noticeDao;

    private final BCryptPasswordEncoder passwordEncoder;

    public Page<Notice> findNotice(FindNoticeParam findNoticeParam){
        return new Page<>(noticeDao.countNotice(findNoticeParam),
                noticeDao.findNotice(findNoticeParam));
    }

    public void addNotice(Notice notice){
        AppAsserts.notNull(notice.getTitle(),"标题不能为空");
        AppAsserts.notNull(notice.getContent(),"内容不能为空");
        AppAsserts.notNull(notice.getType(),"分类不能为空");
        notice.setId(UUIDUtil.get());
        notice.setCreateTime(new Date());
        noticeDao.insert(notice);
    }

    public void updateNotice(Notice notice){
        noticeDao.updateByPrimaryKeySelective(notice);
    }

    public void deleteNoticeList(List<String> noticeIds){
        AppAsserts.notNull(noticeIds,"id不能为空");
        NoticeExample noticeExample = new NoticeExample();
        noticeExample.createCriteria().andIdIn(noticeIds);
        noticeDao.deleteByExample(noticeExample);
    }



}
