package demo.filter;

import com.googlecode.objectify.ObjectifyService;
import demo.entity.Account;
import demo.entity.ClassRoom;

import javax.servlet.*;
import java.io.IOException;

public class ObjectifyRegisterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Đăng ký tất cả class làm việc với database tại đây.
        ObjectifyService.register(Account.class);
        ObjectifyService.register(ClassRoom.class);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
