package com.tzach.example;

/**
 * Created by tzach on 30-Sep-16.
 *
 * Second module. Has dependency on IllegalAccessErrorC module also.
 * This module will be loaded using reflection in runtime using a child class loader by module IllegalAccessErrorA
 *
 * Since the module IllegalAccessErrorB is calling a package private method from IllegalAccessErrorC but they are not
 * loaded using the same class loader, the JVM will throw IllegalAccessError
 */
public class IllegalAccessErrorB {

    public static void main(String[] args){
        new IllegalAccessErrorC().usePrivatePackage();
    }

    public static void usePackagePrivate() {
        new IllegalAccessErrorC().usePrivatePackage();
    }

    public static void usePublic() {
        new IllegalAccessErrorC().usePublic();
    }



}
