package com.tzach.example;



import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by tzach on 30-Sep-16.
 *
 * Main module.
 * This module has compile time dependency on module IllegalAccessErrorC.
 * During package, the module IllegalAccessErrorA will package also IllegalAccessErrorC module, thus, when loading,
 * they will be loaded with the same class loader.
 */
public class IllegalAccessErrorA {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        if ( args.length < 2){
            printUsage();
			return;
        }

        String jarFileName = args[0] + File.separator + "IllegalAccessErrorB-1.0-SNAPSHOT.jar";
        File jarFile = new File(jarFileName);
        if ( jarFile.exists()){
            JarFile jarFile1 = new JarFile(jarFile);
            Enumeration<JarEntry> e = jarFile1.entries();
            URL[] urls = new URL[] { new URL("jar:file:" + jarFile.getAbsolutePath() + "!/")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);

            while (e.hasMoreElements()){
                JarEntry jarEntry = e.nextElement();
                if(jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")){
                    continue;
                }
                // -6 because of .class
                String className = jarEntry.getName().substring(0,jarEntry.getName().length()-6);
                className = className.replace('/', '.');
                Class c = urlClassLoader.loadClass(className);
                Object object = c.newInstance();
                Method method = c.getMethod(args[1]);
                method.invoke(object);
            }
        } else {
            System.out.println("Error: Could not find file " + jarFile.getAbsolutePath());
        }
    }

    private static void printUsage() {
        System.out.println("1st arg - Path to directory holding the jar IllegalAccessErrorB-1.0-SNAPSHOT.jar");
        System.out.println("2nd arg - Could be 'usePublic' or 'usePackagePrivate'");

    }
}
