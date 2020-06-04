package com.chaiyc.springboot.service.user.impl;

import com.chaiyc.springboot.entities.user.User;
import com.chaiyc.springboot.mapper.user.UserMapper;
import com.chaiyc.springboot.service.user.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     */
    @Override
    public User getUserById (String dataId) throws Exception {
        String key = "user_" + dataId;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();

        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            User user = operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            System.out.println(user.getUserName());
            System.out.println("==============================");
            return user;
        }else{
            User user = userMapper.getUserById(dataId);
            System.out.println("==========从数据表中获得数据=========");
            System.out.println(user.getUserName());
            System.out.println("==============================");

            // 写入到缓存中
            operations.set(key,user,5, TimeUnit.HOURS);
            return user;
        }
    }

    @Override
    public List<User> getAllUser() throws Exception {
        return userMapper.getAllUser();
    }

    @Override
    public void saveUser(User user) throws Exception {
        userMapper.saveUser(user);
    }

    /**
     * 删除用户策略：删除数据表中数据，然后删除缓存
     */
    @Override
    public void deleteUserById(String dataId) throws Exception {
        int result = userMapper.deleteUserById(dataId);
        String key = "user_" + dataId;
        if(result != 0){
            Boolean hasKey = redisTemplate.hasKey(key);
            if(hasKey){
                //存在，则删除缓存中
                redisTemplate.delete(key);
                System.out.println("删除了缓存中的key：" + key);
            }
        }
    }

    @Override
    public User login(String username, String password) throws Exception {
        return userMapper.login(username,password);
    }

    @Override
    public PageInfo<User> getPageUser(int pageNo, int pageSize)  throws Exception{
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.getPageUser();
        return new PageInfo<User>(list);
    }

    /**
     * 更新用户策略：先更新数据表，成功之后，删除原来的缓存，再更新缓存
     */
    @Override
    public void updateUser(User user) {
        ValueOperations<String,User> operations = redisTemplate.opsForValue();

        int result = userMapper.updateUser(user);
        if(result != 0){
            String key = "user_" + user.getUserAcctId();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                //可以不用删除原来的key，因为再次更新缓存的时候，相同的key会把原来的值覆盖掉，养成好的编程习惯（删除一下之前的key键值对）
                redisTemplate.delete(key);
                System.out.println("删除缓存中的key=========>" + key);
            }

            // 再将更新后的数据加入缓存 ，
            User userNew = userMapper.getUserById(user.getUserAcctId());
            operations.set(key,userNew,5, TimeUnit.HOURS);
        }
    }

    @Override
    public List<String> CountMainInfo(String currentDate) {
        return userMapper.CountMainInfo(currentDate);
    }

}
