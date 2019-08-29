package com.lin.controller;

import com.lin.servlet.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianglinzou
 * @date 2019/8/29 下午2:21
 */
@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    public IndexController() {
        System.out.println("init");
        System.out.println(this);
        System.out.println(this.getClass().getClassLoader());
    }

    @RequestMapping("/index")
    public String index() {
        return "index+springMVC+tomcat";
    }

    public IndexService getIndexService() {
        return this.indexService;
    }

}
