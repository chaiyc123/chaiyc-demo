package com.chaiyc.jpa.helloworld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        Map<String,Object> properties = new HashMap<String, Object>();
        // 可以设置配置属性，跟配置文件中一样
        properties.put("hibernate.show_sql","true"); //设置是否在控制台打印 SQL 语句

        //properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect"); //设置数据库指定得方言

//        1.创建 EntityManagerFactory   类似于 hibernate 得 SessionFactory
        String persistenceUnitName = "jpa-1";
        EntityManagerFactory entityManagerFactory =
                //Persistence.createEntityManagerFactory(persistenceUnitName);
                Persistence.createEntityManagerFactory(persistenceUnitName,properties);

//        2.创建 EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        4.进行持久化操作
        Customer customer = new Customer();
        customer.setAge(13);
        customer.setEmail("jellily@qq.com");
        customer.setLastName("jellily");
        customer.setCreateDate(new Date());
        customer.setBirthday(new Date());

        entityManager.persist(customer);

//        5.提交事务
        transaction.commit();

//        6. 关闭 EntityManager
        entityManager.close();

//        7. 关闭 EntityManagerFactory
        entityManagerFactory.close();
    }
}
