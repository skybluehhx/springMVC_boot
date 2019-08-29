package com.lin.config;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 加载springmvc-dispatcherServlet
 *
 * @author jianglinzou
 * @date 2019/8/29 下午2:10
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    public static WebApplicationContext servletAppContext;

    public static WebApplicationContext rootAppContext;

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
////        registerDispatcherServlet(servletContext);
//    }

    /**
     * springmvc加载根配置信息
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * springmvc加载配置信息
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //springmvc拦截的url映射 配置"/"拦截所有的请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }



}
