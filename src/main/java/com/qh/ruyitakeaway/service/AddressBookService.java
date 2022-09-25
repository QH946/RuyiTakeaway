package com.qh.ruyitakeaway.service;

import com.qh.ruyitakeaway.entity.AddressBook;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 地址管理 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface AddressBookService extends IService<AddressBook> {

    /**
     * 设置默认地址
     *
     * @param addressBook 地址本
     * @return {@link AddressBook}
     */
    AddressBook setDefault(AddressBook addressBook);

    /**
     * 查询默认地址
     *
     * @return {@link AddressBook}
     */
    AddressBook getDefault();

    /**
     * 查询指定用户的全部地址
     *
     * @param addressBook 地址本
     * @return {@link List}<{@link AddressBook}>
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 根据id查询地址
     *
     * @param id id
     * @return {@link AddressBook}
     */
    AddressBook get(Long id);
}
