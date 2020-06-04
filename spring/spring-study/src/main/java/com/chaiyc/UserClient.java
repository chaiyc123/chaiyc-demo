package com.chaiyc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class UserClient {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:bean.xml");

//        for (String beanName : Arrays.asList("user1", "user2", "user3", "user4", "user5")) {
//            String[] aliases = context.getAliases(beanName);
//            System.out.println(String.format("beanName:%s,别名:[%s]", beanName, String.join(",", aliases)));
//        }

        for ( String beanName : context.getBeanDefinitionNames()){
            //System.out.println(String.format("beanName:%s,别名:[%s]", beanName, String.join(",", aliases)));
            System.out.println(beanName + "" + context.getBean(beanName));
        }
    }

}
