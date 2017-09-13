package com.example.usingdatabinding;

/**
 * Created by ian on 2017. 9. 14..
 */

public class Customer {
    public String name;
    public int age;
    public boolean earlyBird;

    @Override
    public String toString() {
        return name + " / " + age + "세 / " + (earlyBird ? "얼리버드" : "X");
    }
}
