package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.application.query.PageParam;
import cn.huaruan.ud24.query.entity.Feedback;
import cn.huaruan.ud24.query.mapper.FeedbackMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao extends FeedbackMapper {

    long countFeedback();

    List<Feedback> getAllFeedBackByPage(PageParam pageParam);
}
