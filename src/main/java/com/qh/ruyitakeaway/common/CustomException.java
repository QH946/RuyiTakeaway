package com.qh.ruyitakeaway.common;

/**
 * @Author QH
 * @Date 2022/9/11 19:39
 * @Package: com.qh.ruyitakeaway.common
 * @Version 1.0
 */

/**
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}
