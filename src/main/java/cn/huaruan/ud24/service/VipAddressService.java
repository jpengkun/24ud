package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.VipAddressDao;
import cn.huaruan.ud24.query.entity.VipAddress;
import cn.huaruan.ud24.query.entity.VipAddressExample;
import cn.huaruan.ud24.vo.FindVipAddressParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
@AllArgsConstructor
public class VipAddressService {
    private final VipAddressDao addressDao;


    /**
     * 添加一个地址簿
     * @param vipAddress
     */
    public void addAddressBook(VipAddress vipAddress) {
        AppAsserts.notNull(vipAddress,"地址信息不能为空");
        AppAsserts.notNull(vipAddress.getUserId(),"用户id不能为空");
        addressDao.insertSelective(vipAddress);
    }

    /**
     * 根据Id删除
     * @param addressBookId
     * @return
     */
    public long deleteAddressBook(List<Integer> addressBookId) {
        AppAsserts.notNull(addressBookId,"地址Id不能为空");
        VipAddressExample vipAddressExample =new VipAddressExample();
        vipAddressExample.createCriteria().andIdIn(addressBookId);
        return addressDao.deleteByExample(vipAddressExample);
    }
    /**
     * 修改一条地址
     * @param vipAddress
     */
    public long updateAddressBook(VipAddress vipAddress) {
        AppAsserts.notNull(vipAddress,"地址信息不能为空");
        AppAsserts.notNull(vipAddress.getId(), "地址ID不能为空！");
        if (EntityUtils.needToUpdate(vipAddress, VipAddress.class)){
            return addressDao.updateByPrimaryKeySelective(vipAddress);
        }
        return 0;
    }

    /**
     * 根据openid和state分页查找
     * @param addressParam
     * @return
     */
    public Page<VipAddress> findByOpenIdAndState(FindVipAddressParam addressParam) {
        AppAsserts.notNull(addressParam,"参数不能为空");
        AppAsserts.hasText(addressParam.getUserId(),"openId不能为空");
        AppAsserts.notNull(addressParam.getType(),"状态不能为空");
        long total = addressDao.countAddress(addressParam);
        List<VipAddress> address = addressDao.findVipAddressWithParam(addressParam);
        return new Page<>(total,address);
    }


    /**
     * 根据Id查找
     * @param id
     * @return
     */
    public VipAddress getAddressBookById(int id) {
        AppAsserts.notNull(id,"id不能为空");
        return addressDao.selectByPrimaryKey(id);
    }

    public List<VipAddress> getall(){
        return addressDao.selectByExample(null);
    }
}
