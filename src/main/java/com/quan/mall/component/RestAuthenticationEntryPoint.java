package com.quan.mall.component;

import cn.hutool.json.JSONUtil;
import com.quan.mall.common.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: RestAuthenticationEntryPoint
 * @Description: 当未登录或者toke失效访问接口时，自定义的返回结果
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/15 16:02
 */

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(e.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}
