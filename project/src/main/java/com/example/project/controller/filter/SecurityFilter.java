package com.example.project.controller.filter;

import com.example.project.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
@WebFilter( urlPatterns = "*" )
public class SecurityFilter extends HttpServlet implements Filter {
    private static final Map<String, Set<String>> permission = new HashMap<>();

    static {
        Set<String> all = new HashSet<>();
        all.add("admin");
        all.add("user");
        Set<String> admin = new HashSet<>();
        admin.add("admin");

        Set<String> user = new HashSet<>();
        user.add("user");

        permission.put("/logout", all);

        permission.put("/carList", all);
        permission.put("/carEdit", all);
        permission.put("/carSave", all);
        permission.put("/carDelete", admin);

        permission.put("/refundList", admin);
        permission.put("/refundEdit", admin);
        permission.put("/refundSave", admin);
        permission.put("/refundDelete", admin);

        permission.put("/userList", admin);
        permission.put("/userSave", all);
        permission.put("/userEdit", all);
        permission.put("/userDelete", admin);

        permission.put("/orderList", all);
        permission.put("/orderSave", all);
        permission.put("/orderEdit", all);
        permission.put("/orderDelete", all);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String url = req.getRequestURI();
        String context = req.getContextPath();
        url=url.substring(context.length());
        Set<String> roles = permission.get(url);
        if (roles != null) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                User user = (User) session.getAttribute("session_user");
                if (user != null && roles.contains(user.getRole())) {
                    filterChain.doFilter(req, resp);
                    return;
                }else{
                    req.getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                            .forward(req, resp);
                }
            }
        } else {
            filterChain.doFilter(req, resp);
            return;
        }
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                .forward(req, resp);
    }
}