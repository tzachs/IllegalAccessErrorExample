# IllegalAccessErrorExamplee
An example demonstrating IllegalAccessError caused by 'runtime packages'

The example holds 3 modules, each module has 1 class.
IllegalAccessErrorA and IllegalAccessErrorB has compile time dependency on IllegalAccessErrorC.
The example starts the IllegalAccessErrorA which will than load in a separate class loader IllegalAccessErrorB

Since IllegalAccessErrorB is calling a method that has a package private modifier, and it that method was loaded in
a different class loader, the JVM will throw IllegalAccessError due to violating 'runtime package'

## How to use this example:
* Run ```./build.sh``` or do the following manaully
* You must have maven
* Clone project or Download as zip
* You should have a directory with the following modules
  * IllegalAccessErrorA
  * IllegalAccessErrorB
  * IllegalAccessErrorC
 
* Install IllegalAccessErrorC by running 
```bash
mvn clean install
```

* Package IllegalAccessErrorA and IllegalAccessErrorB by running
```bash
mvn clean package
```

* Run the example by going to the target directory of IllegalAccessErrorA and running the following

```bash
cd IllegalAccessErrorA
java -jar target/IllegalAccessErrorA-1.0-SNAPSHOT-jar-with-dependencies.jar ../IllegalAccessErrorB/target/ usePackagePrivate
```

* You can also check what happen when module IllegalAccessErrorB will call a method from IllegalAccessErrorC by changing 'usePackagePrivate' to 'usePublic'. This time, there should not be an error, since the method called has the public access modifier.

## See more at 

* http://stackoverflow.com/questions/14070215/java-lang-illegalaccesserror-tried-to-access-field-concreteentity-instance-from
* https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-5.html#jvms-5.4.4
