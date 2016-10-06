package com.tzach.example;

/**
 * Created by tzach on 30-Sep-16.
 *
 * Module used to host the public method and package private method
 */
public class IllegalAccessErrorC {

    void usePrivatePackage(){
        System.out.println("You are calling package private method!");
    }

    public void usePublic(){
        System.out.println("Ignore the next line since we called it from a public method");
        usePrivatePackage();
    }
}
