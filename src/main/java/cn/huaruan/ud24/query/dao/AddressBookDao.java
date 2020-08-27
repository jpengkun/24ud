package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.AddressBook;
import cn.huaruan.ud24.query.mapper.AddressBookMapper;
import cn.huaruan.ud24.vo.FindAddressBookParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookDao extends AddressBookMapper {

    long countAddressBook(FindAddressBookParam findAddressBook);

    /**
     * 根据openid和状态查找
     * @param findAddressBook
     * @return
     */
    List<AddressBook> findWithSubAddressBook(FindAddressBookParam findAddressBook);
}
