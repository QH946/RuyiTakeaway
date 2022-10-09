package com.qh.ruyitakeaway.common.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;


/**
 * 拷贝对象和集合属性
 *
 * @author qh
 * @date 2022/10/09 12:37:30
 */
public class ObjectConverter<T> {

    /**
     * 对象拷贝
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T BeanConverter(Object source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }


    /**
     * 集合拷贝
     *
     * @param sourceList 源数据列表
     * @param tClass 目标类
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> collectionBeanConverter(List<?> sourceList, Class<T> tClass) throws Exception {
        ArrayList<T> ts = new ArrayList<>();
        Constructor<T> constructor = tClass.getConstructor();
        for (Object o : sourceList) {
            T t = constructor.newInstance();
            BeanUtils.copyProperties(o, t);
            ts.add(t);
        }
        return ts;
    }


}
