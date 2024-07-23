package UNIT3JAVABEANS;

import java.beans.BeanDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class PersonBeanInfo extends SimpleBeanInfo {
    // Method to return property descriptors
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor name = new PropertyDescriptor("name", Person.class);
            PropertyDescriptor age = new PropertyDescriptor("age", Person.class);
            return new PropertyDescriptor[]{name, age};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to return the bean descriptor
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return new BeanDescriptor(Person.class);
    }

    public static void main(String[] args) {
        PersonBeanInfo beanInfo = new PersonBeanInfo();
        for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
            System.out.println(pd.getName());
        }
    }
}
