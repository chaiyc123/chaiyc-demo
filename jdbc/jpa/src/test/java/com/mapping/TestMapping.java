package com.mapping;

import com.chaiyc.jpa.helloworld.Customer;
import com.chaiyc.jpa.helloworld.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class TestMapping {

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
     * 保存多对一时, 建议先保存 1 的一端, 后保存 n 的一端, 这样不会多出额外的 UPDATE 语句.
     */
	@Test
	public void testManyToOnePersist(){
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setBirthday(new Date());
		customer.setCreateDate(new Date());
		customer.setEmail("gg@163.com");
		customer.setLastName("chaiyc1");

		Order order1 = new Order();
		order1.setOrderName("G-GG-1");

		Order order2 = new Order();
		order2.setOrderName("G-GG-2");

		//设置关联关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);

		//执行保存操作
        entityManager.persist(customer);

		entityManager.persist(order1);
		entityManager.persist(order2);

	}


    //默认情况下, 使用左外连接的方式来获取 n 的一端的对象和其关联的 1 的一端的对象.
    //可使用 @ManyToOne 的 fetch 属性来修改默认的关联属性的加载策略
    @Test
    public void testManyToOneFind(){
        Order order = entityManager.find(Order.class, 11);

        System.out.println(order.getOrderName());

        System.out.println(order.getCustomer().getLastName());
    }

    //不能直接删除 1 的一端, 因为有外键约束.
    @Test
    public void testManyToOneRemove(){
//		Order order = entityManager.find(Order.class, 11);
//		entityManager.remove(order);

        Customer customer = entityManager.find(Customer.class, 9);
        entityManager.remove(customer);
    }

    @Test
    public void testManyToOneUpdate(){
        Order order = entityManager.find(Order.class, 11);
        order.getCustomer().setLastName("FFF");
    }
}
