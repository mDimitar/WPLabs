package mk.finki.ukim.mk.lab.web.servlet.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter
public class CheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String path = req.getServletPath();

        String color = (String) req.getSession().getAttribute("value");


        if (color != null || path.equals("/listBalloons") || path.contains("/balloons")) {
            //System.out.println(color);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
