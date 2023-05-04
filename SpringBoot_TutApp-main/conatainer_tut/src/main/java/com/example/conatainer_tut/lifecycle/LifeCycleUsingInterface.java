package com.example.conatainer_tut.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// Same lifecycle method using interfaces
public class LifeCycleSec implements InitializingBean , DisposableBean{
    private double price;
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LifeCycleSec() {
        super();
    }

    @Override   public String toString() {
        return "LifeCycleSec{" +
                "price=" + price +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //init
        System.out.println("Taking Init");
    }

    @Override
    public void destroy() throws Exception {
        //destroy
        System.out.println("Taking Destroy");
    }


}

