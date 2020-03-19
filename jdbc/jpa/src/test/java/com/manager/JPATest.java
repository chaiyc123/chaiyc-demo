package com.manager;

import com.chaiyc.jpa.helloworld.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JPATest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Before
    public void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-1");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @After
    public void destroy(){
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    // 类似于  Hibernate 中 Session 得 get方法
    @Test
    public void testFind(){

        Customer customer = entityManager.find(Customer.class, 1);
        System.out.println("####################");

        System.out.println(customer.toString());
    }


    // 类似于  Hibernate 中 Session 得 load
    @Test
    public void testGetReference(){
        Customer customer = entityManager.getReference(Customer.class, 1);
        System.out.println(customer.getClass().getName()); // 表明这里返回的是一个对象的代理  。有可能发生 懒加载异常

        System.out.println("####################");

        System.out.println(customer);  //当使用对象时，再去查询数据库 返回数据
    }
    // 类似于Hibernate 中 Session 的 save 方法。 使对象由临时状态变为持久化状态
    // 和hibernate 的save 方法的不同之处，若对象有id ，则不能执行insert 操作，抛出异常，而hibernate 可以执行
    @Test
    public void testPersistence(){
        Customer customer = new Customer();
        customer.setAge(13);
        customer.setEmail("jellily@qq.com");
        customer.setLastName("jellily");
        customer.setCreateDate(new Date());
        customer.setBirthday(new Date());

        //customer.setId(100); //抛出异常

        entityManager.persist(customer);
        System.out.println(customer.getId());  //可以打印出Id的值，说明 对象变为持久化状态
    }


    //类似于 hibernate 中 Session 的 delete 方法，把对应的记录从数据库中删除
    // 但注意：该方法只能移除持久化的对象，而hibernate 的delete 方法实际上还可以移除游离状态的对象
    @Test
    public void testRemove(){

//        Customer customer = new Customer();
//        customer.setId(3);  //这种hibernate 可以移除，jpa 不行

        Customer customer = entityManager.find(Customer.class, 3);

        entityManager.remove(customer);
    }
}
