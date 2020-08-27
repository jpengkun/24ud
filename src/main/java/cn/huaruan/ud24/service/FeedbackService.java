package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.PageParam;
import cn.huaruan.ud24.query.dao.FeedbackDao;
import cn.huaruan.ud24.query.entity.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class FeedbackService {

    private final FeedbackDao feedbackDao;


    /**
     * 添加一条反馈
     * @param feedback
     * @return
     */
    public void addFeedBack(Feedback feedback) {
        AppAsserts.notNull(feedback,"添加信息不能为空");
        feedbackDao.insertSelective(feedback);
    }

    /**
     * 查找所有反馈
     * @return
     */

    public List<Feedback> getAllFeedBack() {
        return feedbackDao.selectByExample(null);
    }

    /**
     * 分页查找所有反馈
     * @return
     */
    public Page<Feedback> getAllFeedBackByPage(PageParam pageParam) {
        List<Feedback> feedBacks = feedbackDao.getAllFeedBackByPage(pageParam);
        long total = feedbackDao.countFeedback();
        return new Page<>(total,feedBacks);
    }

}
