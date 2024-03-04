package com.jcticket.filter;

/**
 * packageName    : com.jcticket.filter
 * fileName       : loginCheckFilter
 * author         : jinwook Song
 * date           : 2024-03-04
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-04        jinwook Song       최초 생성
 */
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/mypageIndex/*", "/mypageticket/*", "/mypagecupon/*","/mypageview/*","/mypageclient/*","/ticketing/*"})
public class loginCheckFilter implements Filter {

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

        if (httpRequest.getSession().getAttribute("sessionId") == null) {
            PrintWriter out = httpResponse.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("window.location.href='" + httpRequest.getContextPath() + "/login';");
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

