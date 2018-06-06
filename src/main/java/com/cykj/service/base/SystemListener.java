package com.cykj.service.base;

import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author yangsq
 * @date 2018/6/6 16:14.
 */
public class SystemListener implements ServletContextListener {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SystemListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.err.println("系统初始化开始！");
        try {

            System.out.println("single dog,single dog,single all the day!");
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("System load faild!" + e.getMessage());
            try {
                throw new Exception("系统初始化失败！");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
