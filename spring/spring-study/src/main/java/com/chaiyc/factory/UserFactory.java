package com.chaiyc.factory;

import com.chaiyc.UserModel;

public class UserFactory {

    public UserModel buildUser1() {
        System.out.println("----------------------1");
        UserModel userModel = new UserModel();
        userModel.setName("bean实例方法创建的对象!");
        return userModel;
    }
    public UserModel buildUser2(String name,int age){
        System.out.println("----------------------2");
        UserModel userModel = new UserModel(name,age);
        return userModel;
    }
}
