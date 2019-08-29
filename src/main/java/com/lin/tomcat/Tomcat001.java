package com.lin.tomcat;

import com.lin.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * 使用java语言创建tomcat服务器
 * tomcat底层执行的时servlet
 * <p>
 * <p>
 * SpringMVC无配置文件，采用注解方式启动
 * 加载spring容器，DispatcherServlet
 *
 * @author jianglinzou
 * @date 2019/8/29 下午1:46
 */
public class Tomcat001 {


    private static final Integer port = 8080;
    private static final String CONTEXT_PATH = "/lin";
    private static final String SERVLET_NAME = "indexServlet";

    public static void main(String[] args) throws LifecycleException {

        //创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        //指定tomcat端口号
        tomcatServer.setPort(port);
        //是否自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext context = new StandardContext();
        context.setPath(CONTEXT_PATH);
        //监听上下文
        context.addLifecycleListener(new Tomcat.FixContextListener());
        //tomcat容器添加上下文
        tomcatServer.getHost().addChild(context);


        //创建servlet
        tomcatServer.addServlet(CONTEXT_PATH, SERVLET_NAME, new IndexServlet());
        //servelt 映射
        context.addServletMappingDecoded("/index", SERVLET_NAME);


        tomcatServer.start();
        //异步进行接收请求
        tomcatServer.getServer().await();

    }

}
