package com.quan.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyBatisConfig
 * @Description: mybatis配置类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/30 15:08
 */

/**
 * 添加Java配置，用于扫码Mapper接口路径，这里还有个约定，MBG生成的放在mapper包下，自定义的放在dao包下。
 **/

@Configuration
@MapperScan({"com.quan.mall.mbg.mapper", "com.quan.mall.dao"})
public class MyBatisConfig {
}
