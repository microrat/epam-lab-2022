package com.example.project.controller.user;

import com.example.project.controller.BaseController;
import com.example.project.entity.User;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.service.ServiceFactory;
import com.example.project.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "UserSaveServlet", value = "/userSave")
public class UserSaveServlet extends BaseController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory = getServiceFactory();
        UserService service = factory.userServiceInstance();

        User user = new User();
        user.setId(Long.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setRole(request.getParameter("role"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));


        HttpSession session = request.getSession(false);
        User session_user = (User) session.getAttribute("session_user");

        if(session_user.getId()==user.getId()){
            session.removeAttribute("session_user");
            session.setAttribute("session_user", user);
        }

        try {
            service.save(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user.getRole().equals("admin")){
            response.sendRedirect(request.getContextPath() + "/userList");
        }else{
            response.sendRedirect(request.getContextPath() + "/carList");
        }

    }
}
