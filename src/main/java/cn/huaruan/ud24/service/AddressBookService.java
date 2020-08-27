package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.AddressBookDao;
import cn.huaruan.ud24.query.entity.AddressBook;
import cn.huaruan.ud24.vo.FindAddressBookParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
@AllArgsConstructor
public class AddressBookService {
    private final AddressBookDao bookDao;


    /**
     * 添加一个地址簿
     * @param addressBook
     */
    public void addAddressBook(AddressBook addressBook) {
        AppAsserts.notNull(addressBook,"地址信息不能为空");
        bookDao.insertSelective(addressBook);
    }

    /**
     * 根据Id删除
     * @param addressBookId
     * @return
     */
    public long deleteAddressBook(Integer addressBookId) {
        AppAsserts.notNull(addressBookId,"地址Id不能为空");
        return bookDao.deleteByPrimaryKey(addressBookId);
    }
    /**
     * 修改一条地址
     * @param addressBook
     */
    public long updateAddressBook(AddressBook addressBook) {
        AppAsserts.notNull(addressBook,"地址信息不能为空");
        AppAsserts.notNull(addressBook.getId(), "地址ID不能为空！");
        if (EntityUtils.needToUpdate(addressBook, AddressBook.class)){
            return bookDao.updateByPrimaryKeySelective(addressBook);
        }
        return 0;
    }

    /**
     * 根据openid和state分页查找
     * @param findAddressBook
     * @return
     */
    public Page<AddressBook> findByOpenIdAndState(FindAddressBookParam findAddressBook) {
        AppAsserts.notNull(findAddressBook,"参数不能为空");
        AppAsserts.hasText(findAddressBook.getOpenId(),"openId不能为空");
        AppAsserts.notNull(findAddressBook.getState(),"状态不能为空");
        long total = bookDao.countAddressBook(findAddressBook);
        List<AddressBook> addressBooks = bookDao.findWithSubAddressBook(findAddressBook);
        return new Page<>(total,addressBooks);
    }


    /**
     * 根据Id查找
     * @param id
     * @return
     */
    public AddressBook getAddressBookById(int id) {
        AppAsserts.notNull(id,"id不能为空");
        return bookDao.selectByPrimaryKey(id);
    }

    public List<AddressBook> getall(){
        return bookDao.selectByExample(null);
    }
}
