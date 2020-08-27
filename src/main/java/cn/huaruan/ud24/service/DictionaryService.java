package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.DictionaryDao;
import cn.huaruan.ud24.query.entity.Dictionary;
import cn.huaruan.ud24.query.entity.DictionaryExample;
import cn.huaruan.ud24.vo.DictionaryNode;
import cn.huaruan.ud24.application.common.TreeUtils;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.vo.FindDictionaryParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据字典服务
 *
 * @author outas
 **/
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class DictionaryService {

    private final DictionaryDao dictionaryDao;

    /**
     * 根据条件分页查询所有字典
     *
     * @param findDictionaryParam 查询参数
     * @return
     */
    public Page<DictionaryNode> findWithSubDictionary(FindDictionaryParam findDictionaryParam) {
        AppAsserts.notNull(findDictionaryParam, "查询参数不能为空！");

        // 将查询参数升级为模糊匹配
        EntityUtils.upToContainsParam(findDictionaryParam, FindDictionaryParam.class);

        long total = dictionaryDao.countDictionary(findDictionaryParam);
        List<DictionaryNode> dictionaries = dictionaryDao.findWithSubDictionary(findDictionaryParam);

        List<DictionaryNode> dictionariesTree = TreeUtils.toTree(dictionaries,
                ArrayList::new,
                DictionaryNode::getDictionaryId,
                DictionaryNode::getParentId,
                DictionaryNode::getChildren,
                DictionaryNode::setChildren);
        return new Page<>(total, dictionariesTree);
    }

    /**
     * 新增一条字典项
     *
     * @param dictionary 字典对象
     */
    public void insert(Dictionary dictionary) {
        AppAsserts.notNull(dictionary, "字典项不能为空！");
        AppAsserts.hasText(dictionary.getName(), "字典名不能为空！");
        AppAsserts.hasText(dictionary.getValue(), "字典值不能为空！");

        dictionary.setDictionaryId(UUIDUtil.get());

        // 处理父字典和根字典的关系
        if (dictionary.getParentId() != null) {
            DictionaryExample example = new DictionaryExample();
            example.createCriteria().andDictionaryIdEqualTo(dictionary.getParentId());
            Dictionary parent = QueryUtils.getMaxOne(dictionaryDao.selectByExample(example));
            AppAsserts.notNull(parent, "父字典项不存在！");

            // 父字典存在则根字典继承自父字典
            dictionary.setRootId(parent.getRootId());
        }

        // 相同位置下的字典名称或值不能重复
        AppAsserts.yes(dictionaryDao.countSames(null,
                dictionary.getParentId(), dictionary.getName(), dictionary.getValue()) < 1,
                "相同位置下的字典名或值不能重复！");

        // 详情不允许为空串
        if (!StringUtils.hasText(dictionary.getDetail())) {
            dictionary.setDetail(null);
        }

        dictionary.setDictionaryId(UUIDUtil.get());
        dictionary.setCreateTime(new Date());
        dictionaryDao.insertSelective(dictionary);

        // 更新字典值的根字典ID
        if (dictionary.getParentId() == null) {
            dictionary.setRootId(dictionary.getDictionaryId());
            dictionaryDao.updateByPrimaryKeySelective(dictionary);
        }
    }

    /**
     * 根据id更新字典
     *
     * @param dictionary 字典对象
     */
    public void update(Dictionary dictionary) {
        AppAsserts.notNull(dictionary, "字典项不能为空！");
        AppAsserts.notNull(dictionary.getDictionaryId(), "字典id不能为空！");
        AppAsserts.hasText(dictionary.getName(), "字典名不能为空！");
        AppAsserts.hasText(dictionary.getValue(), "字典值不能为空！");
        AppAsserts.yes(dictionaryDao.countSames(dictionary.getDictionaryId(),
                dictionary.getParentId(), dictionary.getName(), dictionary.getValue()) < 1,
                "相同位置下的字典名或值不能重复！");

        // 不能修改父字典和根字典
        dictionary.setRootId(null);
        dictionary.setParentId(null);

        // 判断传入的参数是否需要进行更新操作
        if (EntityUtils.needToUpdate(dictionary, Dictionary.class)) {
            dictionaryDao.updateByPrimaryKeySelective(dictionary);
        }
    }

    /**
     * 根据id删除一条字典项
     *
     * @param dictionaryId 要删除的字典id
     */
    public void delete(String dictionaryId) {
        AppAsserts.notNull(dictionaryId, "字典id不能为空！");
        AppAsserts.notNull(dictionaryDao.selectByPrimaryKey(dictionaryId),
                "该字典不存在或已删除！");

        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andParentIdEqualTo(dictionaryId);

        // 如果该字典项下存在子项
        AppAsserts.yes(dictionaryDao.countByExample(example) < 1,
                "请先删除该字典的所有子项！");

        dictionaryDao.deleteByPrimaryKey(dictionaryId);
    }

    /**
     * 查询所有的字典项，并按照树状结构返回
     *
     * @param rootValues 根字典的id
     * @return
     */
    public List<DictionaryNode> finAsTrees(String[] rootValues) {
        AppAsserts.notNull(rootValues, "查询参数不能为空！");

        List<DictionaryNode> dictionaries = dictionaryDao.findRootSubDictionaries(rootValues);

        // 将结果转换为树状结构
        return TreeUtils.toTree(dictionaries,
                ArrayList::new,
                DictionaryNode::getDictionaryId,
                DictionaryNode::getParentId,
                DictionaryNode::getChildren,
                DictionaryNode::setChildren);
    }

}
