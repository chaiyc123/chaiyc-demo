package com.chaiyc.factory;

import java.util.List;

public class SettBean {

    public interface IService{};

    public static class ServiceA implements IService{};
    public static class ServiceB implements IService{
        public ServiceB(){
            System.out.println("ServiceB start..");
        }
    };

    private IService iService;

    public void setiService(List<IService> iService) {
        System.out.println(iService);
    }
}
