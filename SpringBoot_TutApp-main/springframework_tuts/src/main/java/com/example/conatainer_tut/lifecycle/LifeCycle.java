package com.example.conatainer_tut.lifecycle;

public class LifeCycle {
    private int price;

    public int getPrice() {
        System.out.println("Getting the price");
        return price;
    }

    public void setPrice(int price) {
        System.out.println("Setting the price");
        this.price = price;
    }

    public LifeCycle(){
        super();
    }

    @Override
    public String toString() {
        return "LifeCycle{" +
                "price=" + price +
                '}';
    }

    //We can change the name of these method , But signature must be same in init and destroy method.

    //Initialization code Loading config, Connecting Db, Webserver etc
    public void init(){
        System.out.println("Inside the init method");
    }

    //Clean up code
    public void destroy(){
        System.out.println("Inside the destroy method");
    }
}
