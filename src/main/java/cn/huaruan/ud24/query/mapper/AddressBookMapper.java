package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.AddressBook;
import cn.huaruan.ud24.query.entity.AddressBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-18 18:54:05
*/
@Mapper
public interface AddressBookMapper {
    long countByExample(AddressBookExample example);

    int deleteByExample(AddressBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressBook record);

    int insertSelective(AddressBook record);

    List<AddressBook> selectByExample(AddressBookExample example);

    AddressBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByExample(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByPrimaryKeySelective(AddressBook record);

    int updateByPrimaryKey(AddressBook record);
}