package com.example.fragments_recyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Talia", "70877898"));
        people.add(new Person("Rob", "207878898"));
        people.add(new Person("Home", "4078309348"));
        people.add(new Person("Peter", "9772417390"));
    }
}
