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

    /**
     * Default constructor.
     */
    public SystemListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
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
