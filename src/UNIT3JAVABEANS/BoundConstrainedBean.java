package UNIT3JAVABEANS;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class BoundConstrainedBean {
    private String property;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    // Method to add a property change listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }


    // Method to add a vetoable change listener
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(listener);
    }


    // Getter method for 'property'
    public String getProperty() {
        return property;
    }

    // Setter method for 'property' with both bound and constrained property support
    public void setProperty(String property) throws PropertyVetoException {
        String oldValue = this.property;
        vcs.fireVetoableChange("property", oldValue, property); // Check if any listener vetoes the change
        this.property = property;
        pcs.firePropertyChange("property", oldValue, property); // Notify listeners about the change
    }

    public static void main(String[] args) {
        BoundConstrainedBean bean = new BoundConstrainedBean();
        try {

            bean.addPropertyChangeListener(evt -> {
                System.out.println("Property changed: " + evt.getPropertyName() +
                                   " [old -> " + evt.getOldValue() + ", new -> " + evt.getNewValue() + "]");
            });
            bean.addVetoableChangeListener(evt -> {
                if ("Invalid Value".equals(evt.getNewValue())) {
                    throw new PropertyVetoException("Invalid value", evt);
                }
            });

            bean.setProperty("Valid Value"); // This should work
            bean.setProperty("Invalid Value"); // This should be vetoed

        } catch (PropertyVetoException e) {
            System.out.println("Exception occured");
        }finally {
            System.out.println(bean.getProperty());
        }
    }
}
