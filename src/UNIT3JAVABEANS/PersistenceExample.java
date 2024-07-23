package UNIT3JAVABEANS;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// Example showing how to persist a JavaBean to an XML file and read it back
public class PersistenceExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);

        // Save to file using XMLEncoder
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream("person.xml"))) {
            encoder.writeObject(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load from file using XMLDecoder
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream("person.xml"))) {
            Person loadedPerson = (Person) decoder.readObject();
            System.out.println("Name: " + loadedPerson.getName());
            System.out.println("Age: " + loadedPerson.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
