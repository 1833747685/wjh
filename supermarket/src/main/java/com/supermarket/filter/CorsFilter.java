package com.supermarket.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*", filterName = "CorsFilter")
public class CorsFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String origin = request.getHeader("Origin");

        // 允许的跨域
        response.setHeader("Access-Control-Allow-Origin",origin);
        // 允许携带Cookie
        response.setHeader("Access-Control-Allow-Credentials","true");

        response.setHeader("Access-Control-Allow-Headers", "Content-Type,content-type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,Access-Token,token");
        response.setHeader("Access-Control-Expose-Headers", "*");//响应客户端的头部 允许携带Token 等等
        response.setHeader("Access-Control-Max-Age", "3600");   // 预检请求的结果缓存时间
        //
        if (!request.getMethod().equals("OPTIONS")){
            //非 预检请求 放行 ，预检请求  不放行  预检请求 直接响应允许跨域的信息即可 无需访问到后台接口
            chain.doFilter(request, response);
        }
    }

}
