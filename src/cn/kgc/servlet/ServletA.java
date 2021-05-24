package cn.kgc.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 是一个具有特殊功能的类：
 * 可以处理浏览器发送给服务器的请求
 * 特别：
 * 不用程序员new对象，对象创建以及其方法调用依赖web.xml配置。
 *
 * 如何测试：
 * 1.配置一个提供给浏览器发出请求的url地址
 *  1-1 web.xml
 *  1-2 配置格式是固定的。能读懂
 * 2.启动服务器
 * 3.打开客户端输入ServletA对应的url地址回车即可
 */
public class ServletA implements Servlet {//子类 can do 接口

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /*
        init()执行时机：第一次请求ServletA的执行，其他的请求再产生，就没有执行init()
         */
        System.out.println("init ...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*
        service执行时机：只要有请求，就会执行service。
        作用：处理用户请求
         */
        System.out.println("service ....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        /*
        destroy执行时机：服务器关闭前执行一次
         */
        System.out.println("destroy ....");
    }
}
