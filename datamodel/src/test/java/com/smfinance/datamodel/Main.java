package com.smfinance.datamodel;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smfinance.datamodel.config.ApplicationConfig;
import com.smfinance.datamodel.service.UserService;

public class Main
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        test(context);
    }
    
    private static void test(AnnotationConfigApplicationContext context)
    {
        UserService userService = (UserService)context.getBean("userService");
        System.out.println(userService.getAllUsers());
    }
}
