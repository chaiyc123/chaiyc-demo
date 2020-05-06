package com.chaiyc.springboot.redis;

import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args) {
        /*Jedis jedis = new Jedis("192.168.1.150");
        jedis.auth("chaiyc");  //设置了安全验证，必须设置密码才能登陆

        System.out.println(jedis.ping());
        System.out.println(jedis.get("foo"));
        System.out.println(jedis.keys("*"));*/

        System.out.println(Math.round(-11.2));
        System.out.println(Math.round(-11.8));
        System.out.println(2 << 3);

        // ‘ok: ’ ：标号   使用break ok 可以跳出多重循环
        ok:
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                System.out.println("i="+i+",j="+j);
                if(j==5)break ok;
            }
        }

        String aa;
        Character character = new Character('你');


        int a = 0 ;
        a(a);

        System.out.println(a);
    }

    public static void a(int a){
        a = 10;
    }
}
