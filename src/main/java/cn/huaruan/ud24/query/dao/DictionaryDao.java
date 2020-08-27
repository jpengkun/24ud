package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.mapper.DictionaryMapper;
import cn.huaruan.ud24.vo.DictionaryNode;
import cn.huaruan.ud24.vo.FindDictionaryParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryDao extends DictionaryMapper {

    long countDictionary(FindDictionaryParam findDictionaryParam);

    List<DictionaryNode> findWithSubDictionary(FindDictionaryParam findDictionaryParam);

    long countSames(@Param("dictionaryId") String dictionaryId, @Param("parentId") String parentId,
                    @Param("name") String name, @Param("value") String value);

    List<DictionaryNode> findRootSubDictionaries(String[] rootValues);
}