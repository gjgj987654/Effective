package com.manage.springboot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @param
 * @auther gaojian
 * @date 2018/10/12 12:40
 */
@WebServlet(urlPatterns = "/my/servlet")
public class MyServletTest extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("输出成功");
        
    }
}
