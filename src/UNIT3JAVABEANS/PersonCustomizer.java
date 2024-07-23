package UNIT3JAVABEANS;

import java.beans.Customizer;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;


// A simple customizer for the Person bean
public class PersonCustomizer extends JPanel implements Customizer {
    private Person person;
    private JTextField nameField;
    private JTextField ageField;

    public PersonCustomizer() {
        nameField = new JTextField(20);
        ageField = new JTextField(5);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
    }

    @Override
    public void setObject(Object bean) {
        this.person = (Person) bean;
        nameField.setText(person.getName());
        ageField.setText(Integer.toString(person.getAge()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Person person = new Person();
        person.setName("Alice");
        person.setAge(25);

        PersonCustomizer customizer = new PersonCustomizer();
        customizer.setObject(person);

        frame.add(customizer);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
