package com.example.usingdatabinding;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by ian on 2017. 9. 14..
 */

public class Customer extends BaseObservable{
    public ObservableField<String> name = new ObservableField<>();
    public int age;
    public boolean earlyBird;

    @Override
    public String toString() {
        return name.get() + " / " + age + "세 / " + (earlyBird ? "얼리버드" : "X");
    }
}
