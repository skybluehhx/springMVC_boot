package com.lin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * springMVC的配置信息
 * <p>
 * 用于配置springMVC的相关注解
 * <p>
 * 扫描controller
 *
 * @author jianglinzou
 * @EnableWebMvc 开启springMVC功能
 * @date 2019/8/29 下午2:13
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.lin.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {




}
