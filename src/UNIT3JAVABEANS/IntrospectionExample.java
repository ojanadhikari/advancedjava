package UNIT3JAVABEANS;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;

// Example of using introspection to analyze the Person bean
public class IntrospectionExample {
    public static void main(String[] args) {
        try {
            // Introspecting the Person class to get property descriptors
            for (PropertyDescriptor pd : Introspector.
                getBeanInfo(Person.class).getPropertyDescriptors()) {
                System.out.println(pd.getName()); // Print the property name
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
