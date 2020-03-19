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

public class TestJPAMerge {

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
    /**
     * 总的来说: 类似于 hibernate Session 的 saveOrUpdate 方法.
     */
    //1. 若传入的是一个临时对象
    //会创建一个新的对象, 把临时对象的属性复制到新的对象中, 然后对新的对象执行持久化操作. 所以
    //新的对象中有 id, 但以前的临时对象中没有 id.
    @Test
    public void testMerge1(){
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setBirthday(new Date());
        customer.setCreateDate(new Date());
        customer.setEmail("cc@163.com");
        customer.setLastName("CC");

        Customer customer2 = entityManager.merge(customer);

        System.out.println("customer#id:" + customer.getId());
        System.out.println("customer2#id:" + customer2.getId());
    }

    //若传入的是一个游离对象, 即传入的对象有 OID.
    //1. 若在 EntityManager 缓存中没有该对象
    //2. 若在数据库中也没有对应的记录
    //3. JPA 会创建一个新的对象, 然后把当前游离对象的属性复制到新创建的对象中
    //4. 对新创建的对象执行 insert 操作.
    @Test
    public void testMerge2(){
        Customer customer = new Customer();
        customer.setAge(13);
        customer.setEmail("jellily@qq.com");
        customer.setLastName("jellily");
        customer.setCreateDate(new Date());
        customer.setBirthday(new Date());

        customer.setId(100);

        Customer customer1 = entityManager.merge(customer);

        System.out.println(customer.getId());
        System.out.println(customer1.getId());
    }

    //若传入的是一个游离对象, 即传入的对象有 OID.
    //1. 若在 EntityManager 缓存中没有该对象
    //2. 若在数据库中也有对应的记录
    //3. JPA 会查询对应的记录, 然后返回该记录对一个的对象, 再然后会把游离对象的属性复制到查询到的对象中.
    //4. 对查询到的对象执行 update 操作.
    @Test
    public void testMerge3(){
        Customer customer = new Customer();
        customer.setAge(13);
        customer.setEmail("jellily@qq.com");
        customer.setLastName("chaiyc");
        customer.setCreateDate(new Date());
        customer.setBirthday(new Date());

        customer.setId(4);

        Customer customer1 = entityManager.merge(customer);

        System.out.println(customer == customer1);
    }


    //若传入的是一个游离对象, 即传入的对象有 OID.
    //1. 若在 EntityManager 缓存中有对应的对象
    //2. JPA 会把游离对象的属性复制到查询到EntityManager 缓存中的对象中.
    //3. EntityManager 缓存中的对象执行 UPDATE.
    @Test
    public void testMerge4(){
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setCreateDate(new Date());
        customer.setBirthday(new Date());
        customer.setEmail("dd@163.com");
        customer.setLastName("EE");

        customer.setId(4);   //注意。这里如果设置 100 ，即数据库中没有该对象，则重新创建，执行insert方法
        Customer customer1 = entityManager.find(Customer.class, 4);

        Customer customer2 = entityManager.merge(customer);

        System.out.println(customer == customer1); //false
    }


    /**
     * 同 hibernate 中 Session 的 flush 方法.
     */
    @Test
    public void testFlush(){
        Customer customer = entityManager.find(Customer.class, 4);
        System.out.println(customer);

        customer.setLastName("chaiyc");

        //因为 是持久化状态的 对象，所以在set 属性后 执行commit 会进行update操作

        entityManager.flush();
    }


    /**
     * 同 hibernate 中 Session 的 refresh 方法.
     */
    @Test
    public void testRefresh(){
        Customer customer = entityManager.find(Customer.class, 4);

        entityManager.refresh(customer);
    }

}
