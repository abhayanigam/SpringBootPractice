package com.example.conatainer_tut.ambiguitytut;

public class AddVar {
    private int a;
    private int b;

    public AddVar(int a, int b) {
        this.a = a;
        this.b = b;

        System.out.println("Constructor : int , int");
    }

    public AddVar(double a, double b){
        this.a = (int) a;
        this.b = (int) b;

        System.out.println("Constructor : double , double");
    }

    public AddVar(String a, String b){
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);

        System.out.println("Constructor : String , String");
    }


    public void doSum(){
        System.out.println("Sum is : " + (this.a + this.b));
    }
}
