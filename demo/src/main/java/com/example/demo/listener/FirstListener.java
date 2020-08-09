package com.example.demo.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * SpringBoot 整合 Listener 方式一
 * 我们这里创建了一个Servlet上下文的监听器，实现ServletContextListener接口即可
 * @author 清水三千尺
 *
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("FirstListener...contextDestroyed....");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FirstListener...init....");
    }
}