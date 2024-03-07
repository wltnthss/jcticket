package com.jcticket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * packageName :  com.jcticket.filter
 * fileName : adminCheckFilter
 * author :  jisoo Son
 * date : 2024-03-06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-03-06             jisoo Son             최초 생성
 */
@WebFilter(urlPatterns = {"/admin/*"})

public class AdminCheckFilter implements Filter {

    private String excludedPages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 로직
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 필터링 로직 구현
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("text/html; charset=UTF-8");

        String requestURI = httpRequest.getRequestURI();

        // 로그인하는 경우는 필터 제외
        if(requestURI.equals(httpRequest.getContextPath() + "/admin")){
            System.out.println("로그인 필터만 제외");
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getSession().getAttribute("adminId") == null) {
            PrintWriter out = httpResponse.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("window.location.href='" + httpRequest.getContextPath() + "/admin';");
            out.println("</script>");
            out.close();
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // 종료 로직
    }
}

