package com.quan.mall.service;

import com.quan.mall.common.api.CommonResult;

/**
 * @ClassName: UmsMemberService
 * @Description: 会员登陆注册服务
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/14 14:45
 */
public interface UmsMemberService {
    // 生成验证码
    CommonResult generateAuthCode(String telephone);

    // 判断验证码和手机号是否匹配
    CommonResult verifyAuthCode(String telephone, String authCode);
}
