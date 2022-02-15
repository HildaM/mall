package com.quan.mall.component;

import cn.hutool.json.JSONUtil;
import com.quan.mall.common.api.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: RestfulAccessDeniedHandler
 * @Description: 拒绝访问的自定义返回结果
 *              当访问接口没有权限时，自定义的返回结果
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/15 15:54
 */

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}
