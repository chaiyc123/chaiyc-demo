package com.chaiyc.springboot.dbTest;

import com.chaiyc.springboot.config.MyDBConfig;
import com.chaiyc.springboot.entities.test.DBConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyDBConfig.class);
        context.refresh();

        DBConfig bean = context.getBean(DBConfig.class);
        System.out.println(bean);
    }

//    @Test
//    public void testValue(){
//
//    }
}
