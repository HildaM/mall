package com.quan.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyBatisConfig
 * @Description: mybatis配置类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/30 15:08
 */

@Configuration
@MapperScan("com.quan.mall.mbg.mapper")
public class MyBatisConfig {
}
