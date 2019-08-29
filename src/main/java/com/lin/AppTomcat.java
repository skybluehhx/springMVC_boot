package com.lin;

import com.lin.config.SpittrWebAppInitializer;
import com.lin.controller.IndexController;
import com.lin.servlet.IndexService;
import com.lin.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.loader.ParallelWebappClassLoader;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.view.ViewResolverComposite;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;

/**
 * 先从本地后去，随后长其他地方获取
 *
 * @author jianglinzou
 * @date 2019/8/29 下午2:23
 */
public class AppTomcat {


    private static final Integer port = 9090;
    private static final String CONTEXT_PATH = "/lin";
    private static final String SERVLET_NAME = "indexServlet";


    public static void main(String[] args) throws ServletException, LifecycleException {
        HttpServletBean httpServletBean;
        ParallelWebappClassLoader classLoader;
        start();
    }


    //使用java内置tomcat运行springMVC,tomcat加载到springmvc注解启动方式，springMVC容器将会初始化
    public static void start() throws LifecycleException, ServletException {

        //创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        //指定tomcat端口号
        tomcatServer.setPort(port);

        //读取项目路径入口，（包含静态资源路径等）
        StandardContext context = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());
        //禁止重新载入
        context.setReloadable(false);
        //class文件读取地址
        File additionWebInfClasses = new File("target/classes");
        //创建WebRoot
        WebResourceRoot resources = new StandardRoot(context);
        //tomcat内嵌读取class执行
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        //启动tomcat服务
        tomcatServer.start();
        context.getServletContext();
//        HttpServlet httpServlet;
//        httpServlet.getServletContext();

        //异步进行接收请求
        tomcatServer.getServer().await();

    }
}
