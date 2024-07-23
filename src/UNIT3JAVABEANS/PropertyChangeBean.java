package UNIT3JAVABEANS;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertyChangeBean {
    private String property;
    private final PropertyChangeSupport support;

    // Constructor initializing the PropertyChangeSupport object
    public PropertyChangeBean() {
        support = new PropertyChangeSupport(this);
    }

    // Method to add a property change listener
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    // Getter method for 'property'
    public String getProperty() {
        return property;
    }

    // Setter method for 'property' with property change support
    public void setProperty(String property) {
        String oldValue = this.property;
        this.property = property;
        support.firePropertyChange(
            "property", oldValue, property); // Notify listeners about the change
    }

    public static void main(String[] args) {
        PropertyChangeBean bean = new PropertyChangeBean();
        bean.addPropertyChangeListener(evt -> {
            System.out.println("Property changed: " + evt.getPropertyName() +
                               " [old -> " + evt.getOldValue() + ", new -> "
                + evt.getNewValue() + "]");
        });

        bean.setProperty("New Value"); // Triggers the property change event
        bean.setProperty("Hello");
    }
}
