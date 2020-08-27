package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.Notice;
import cn.huaruan.ud24.query.mapper.NoticeMapper;
import cn.huaruan.ud24.vo.FindNoticeParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao extends NoticeMapper {

    List<Notice> findNotice(FindNoticeParam findNoticeParam);

    long countNotice(FindNoticeParam findNoticeParam);


}
