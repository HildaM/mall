package com.quan.mall.service.impl;

import com.quan.mall.common.api.CommonResult;
import com.quan.mall.service.RedisService;
import com.quan.mall.service.UmsMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName: UmsMemberServiceImpl
 * @Description: 会员登录注册服务实现类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/14 14:48
 */

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;

    // 获取配置文件中的数据！！！
    // 配置文件可以动态调整！！！
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        // 生成6个随机数
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }

        // 验证码绑定手机号，并存储到redis中
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);

        // 返回生成的验证码给前端
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        // 数据验证
        if (StringUtils.isEmpty(authCode))
            return CommonResult.failed("请输入验证码");

        // 验证码检验
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (authCode.equals(realAuthCode))
            return CommonResult.success(null, "验证码检验成功");
        else
            return CommonResult.failed("验证码错误");
    }
}
