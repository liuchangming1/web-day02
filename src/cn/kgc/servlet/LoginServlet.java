package cn.kgc.servlet;

import cn.kgc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理登录业务
        /*
        实现登录思路：
        1.获取用户输入的用户名+密码
        *** 学习新知识：如何从请求协议取表单数据*****
        2.传递给JDBC处理user表是否存在用户名+密码
        ---- 已经jdbc学会了
        3.如果查询到了，登录成功    查询不到登录失败
        --- 也会
        4.将登录结果回送给浏览器，看到登录处理结果
        *** java程序如何封装响应体 ***
         */
        //取  调  存  转
        //request.getParameter("login.html中表单项的name属性");
        String username=request.getParameter("username");
        String password = request.getParameter("userpwd");

        //找service处理登录sql语句
        boolean result = new UserServiceImpl().login(username, password);

        String msg=result?"登录成功":"用户名或密码输入有误";

        //不能使用SOUT
//        System.out.println(msg);
        PrintWriter writer = response.getWriter();
        writer.write(msg);
        writer.flush();//将数据实际发送给文件
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
