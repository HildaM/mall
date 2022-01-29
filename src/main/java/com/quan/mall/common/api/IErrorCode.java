package com.quan.mall.common.api;

/**
 * @ClassName: IErrorCode
 * @Description: 规定错误信息输出的接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/30 15:29
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
