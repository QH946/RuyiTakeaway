package com.qh.ruyitakeaway.controller;


import com.qh.ruyitakeaway.common.BaseContext;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.entity.AddressBook;
import com.qh.ruyitakeaway.service.AddressBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 地址管理 前端控制器
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Api(tags ="地址铺管理")
@Slf4j
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * 新增地址
     */
    @ApiOperation("添加地址信息")
    @PostMapping
    public R<AddressBook> save(@RequestBody AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        log.info("addressBook:{}", addressBook);
        addressBookService.save(addressBook);
        return R.success(addressBook);
    }

    /**
     * 设置默认地址
     */
    @ApiOperation("设置默认地址")
    @PutMapping("default")
    public R<AddressBook> setDefault(@RequestBody AddressBook addressBook) {
        log.info("addressBook:{}", addressBook);
        addressBookService.setDefault(addressBook);
        return R.success(addressBook);
    }

    /**
     * 根据id查询地址
     */
    @ApiOperation("获取地址列表")
    @GetMapping("/{id}")
    public R<?> get(@PathVariable Long id) {
        AddressBook addressBook = addressBookService.get(id);
        return R.success(addressBook);
    }

    /**
     * 查询默认地址
     */
    @ApiOperation("获取默认地址")
    @GetMapping("default")
    public R<AddressBook> getDefault() {
        AddressBook aDefault = addressBookService.getDefault();
        return R.success(aDefault);
    }

    /**
     * 查询指定用户的全部地址
     */
    @ApiOperation("获取指定地址")
    @GetMapping("/list")
    public R<List<AddressBook>> list(AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        log.info("addressBook:{}", addressBook);
        List<AddressBook> list = addressBookService.list(addressBook);
        return R.success(list);
    }

    /**
     * 修改地址
     *
     * @param addressBook
     * @return
     */
    @ApiOperation("修改地址信息")
    @PutMapping
    public R<String> update(@RequestBody AddressBook addressBook) {
        addressBookService.updateById(addressBook);
        return R.success("修改成功");
    }

    /**
     * 删除地址
     *
     * @param ids
     * @return
     */
    @ApiOperation("删除地址")
    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> ids) {
        addressBookService.removeBatchByIds(ids);
        return R.success("删除成功");
    }
}


