package com.quan.mall.service;

/**
 * @ClassName: RedisService
 * @Description: 常用的Redis操作
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/14 14:28
 */
public interface RedisService {
    // 存储数据
    void set(String key, String value);

    // 获取数据
    String get(String key);

    // 设置超时时间
    boolean expire(String key, long expire);

    // 删除数据
    void remove(String key);

    // 自增操作
    Long increment(String key, long delta);
}
