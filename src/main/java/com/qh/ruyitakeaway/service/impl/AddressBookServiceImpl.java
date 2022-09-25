package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qh.ruyitakeaway.common.BaseContext;
import com.qh.ruyitakeaway.common.CustomException;
import com.qh.ruyitakeaway.entity.AddressBook;
import com.qh.ruyitakeaway.mapper.AddressBookMapper;
import com.qh.ruyitakeaway.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地址管理 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * 设置默认地址
     *
     * @param addressBook 地址本
     * @return {@link AddressBook}
     */
    @Override
    public AddressBook setDefault(AddressBook addressBook) {
        LambdaUpdateWrapper<AddressBook> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        wrapper.set(AddressBook::getIsDefault, 0);
        //SQL:update address_book set is_default = 0 where user_id = ?
        addressBookService.update(wrapper);

        addressBook.setIsDefault(1);
        //SQL:update address_book set is_default = 1 where id = ?
        addressBookService.updateById(addressBook);
        return addressBook;
    }

    /**
     * 查询默认地址
     *
     * @return {@link AddressBook}
     */
    @Override
    public AddressBook getDefault() {
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        queryWrapper.eq(AddressBook::getIsDefault, 1);

        //SQL:select * from address_book where user_id = ? and is_default = 1
        AddressBook addressBook = addressBookService.getOne(queryWrapper);

        if (null == addressBook) {
            throw new CustomException("没有找到该对象");
        } else {
            return addressBook;
        }
    }

    /**
     * 查询指定用户的全部地址
     *
     * @param addressBook 地址本
     * @return {@link List}<{@link AddressBook}>
     */
    @Override
    public List<AddressBook> list(AddressBook addressBook) {
        //条件构造器
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(null != addressBook.getUserId(), AddressBook::getUserId, addressBook.getUserId());
        queryWrapper.orderByDesc(AddressBook::getUpdateTime);

        //SQL:select * from address_book where user_id = ? order by update_time desc
        return addressBookService.list(queryWrapper);
    }

    /**
     * 根据id查询地址
     *
     * @param id id
     * @return {@link AddressBook}
     */
    @Override
    public AddressBook get(Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        if (addressBook != null) {
            return addressBook;
        } else {
            throw new CustomException("没有找到该对象");
        }
    }
}
