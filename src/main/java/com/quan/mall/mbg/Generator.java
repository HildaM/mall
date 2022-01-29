package com.quan.mall.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Generator
 * @Description: mbg代码生成器，运行即可生成代码
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/30 14:15
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // mbg执行过程中的警告信息
        List<String> warnings = new ArrayList<>();

        // 当生成的代码重复时，覆盖源代码
        boolean overwrite = true;

        // 读取我们的mbg配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        // 控制台输出？
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        // 创建mgb
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 执行生成代码
        myBatisGenerator.generate(null);
        // 输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
