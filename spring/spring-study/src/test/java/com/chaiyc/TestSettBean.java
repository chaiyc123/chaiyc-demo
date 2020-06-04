package com.chaiyc;

import com.chaiyc.factory.Service1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestSettBean {

    ClassPathXmlApplicationContext context = null;

    @Before
    public void init(){
        System.out.println("容器开始启动。");
        context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        System.out.println("容器启动完成。");
    }

    @Test
    public void testSettBean(){
        context.getBean("setterBean");
    }


    @Test
    public void testCGlib(){
        //使用Enhancer来给某个类创建代理类，步骤
        //1.创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2.通过setSuperclass来设置父类型，即需要给哪个类创建代理类
        enhancer.setSuperclass(Service1.class);
        /*3.设置回调，需实现org.springframework.cglib.proxy.Callback接口，
        此处我们使用的是org.springframework.cglib.proxy.MethodInterceptor，也是一个接口，实现了Callback接口，
        当调用代理对象的任何方法的时候，都会被MethodInterceptor接口的invoke方法处理*/
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("调用方法:" + method);
                Object result = methodProxy.invokeSuper(o, objects);
                return result;
            }
        });
        //4.获取代理对象,调用enhancer.create方法获取代理对象，这个方法返回的是Object类型的，所以需要强转一下
        Service1 proxy = (Service1)enhancer.create();
        proxy.m1();
        proxy.m2();
    }


    @Test
    public void testHash(){
        char[] value =new char[]{ 'a', 'b','c'};
        int hash = 0;
        int h = hash;
        if (h == 0 && value.length > 0) {
            //value : char storage
            char val[] = value;
            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            //hash = h;
        }
        System.out.println(h);
    }

    @Test
    public void testStream(){
        new TestString();
    }

    class TestString{

        public TestString(){
            test();
            test(new String[]{"aaa","bbb"});
            test("ccc");
        }

        public void test(){
            System.out.println("test");
        }

        public void test(String... strings){
            for (String s : strings) {
                System.out.print(s + ",");
            }
            System.out.println();
        }

    }

}
