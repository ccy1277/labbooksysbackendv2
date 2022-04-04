package org.labbooksys.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class CharacterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        // 获取请求方式
        String method = request.getMethod();
        // 解决post中文乱码
        if(method.equalsIgnoreCase("post")){
            request.setCharacterEncoding("utf-8");
        }
        // 解决响应中文乱码
        response.setContentType("application/json;charset=utf-8");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
