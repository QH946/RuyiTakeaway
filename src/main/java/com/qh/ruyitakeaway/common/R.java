package com.qh.ruyitakeaway.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author QH
 * @Date 2022/9/8 19:22
 * @Package: com.qh.ruyitakeaway.common
 * @Version 1.0
 */
@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}