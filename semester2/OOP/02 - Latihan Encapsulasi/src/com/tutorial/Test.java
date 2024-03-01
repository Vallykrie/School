package com.tutorial;

class One{
    static int two = 3;

    void setTwo(int two){
        this.two = two;
    }

    // One(){

    // }

}
public class Test {
    public static void main(String[] args) {
        One one = new One();
        one.setTwo(5);
        System.out.println(one.two);
    }
}
