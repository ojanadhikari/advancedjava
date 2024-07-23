package UNIT3JAVABEANS;

import java.io.Serializable;

// A simple JavaBean representing a Person
public class Person implements Serializable {
    private String name; // A private property
    private int age;     // Another private property

    // No-argument constructor
    public Person() {
    }

    // Getter method for 'name' property
    public String getName() {
        return name;
    }

    // Setter method for 'name' property
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for 'age' property
    public int getAge() {
        return age;
    }

    // Setter method for 'age' property
    public void setAge(int age) {
        this.age = age;
    }
}
