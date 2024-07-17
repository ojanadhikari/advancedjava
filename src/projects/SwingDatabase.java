package projects;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;

public class SwingDatabase {
    Connection conn;
    Statement st;

    //creating connection
    void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/bca", "root", "root");
            st = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    SwingDatabase() {
        getConnection();
        JFrame jframe = new JFrame("This is a simple JFrame App");
        jframe.setSize(600, 250);
        jframe.setLocationRelativeTo(null);
        jframe.getContentPane().setLayout(null);
        jframe.setVisible(true);

        JLabel lbl1 = new JLabel("Id:");
        lbl1.setBounds(20, 12, 100, 10);
        jframe.add(lbl1);
        JTextField txt1 = new JTextField();
        txt1.setBounds(120, 10, 150, 20);
        jframe.add(txt1);

        JLabel lbl2 = new JLabel("Name:");
        lbl2.setBounds(20, 55, 100, 10);
        jframe.add(lbl2);
        JTextField txt2 = new JTextField();
        txt2.setBounds(120, 50, 150, 20);
        jframe.add(txt2);

        JLabel lbl3 = new JLabel("Address: ");
        lbl3.setBounds(20, 85, 120, 30);
        jframe.add(lbl3);
        JTextField txt3 = new JTextField();
        txt3.setBounds(120, 90, 150, 20);
        jframe.add(txt3);

        JButton insert = new JButton("Insert");
        insert.setBounds(10, 140, 80, 20);
        jframe.add(insert);

        JButton update = new JButton("Update");
        update.setBounds(100, 140, 100, 20);
        jframe.add(update);

        JButton delete = new JButton("Delete");
        delete.setBounds(210, 140, 100, 20);
        jframe.add(delete);

        JButton view = new JButton("View");
        view.setBounds(320, 140, 80, 20);
        jframe.add(view);
        //insert
        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = txt1.getText().toString();
                String name = txt2.getText().toString();
                String address = txt3.getText().toString();
                try {
                    String sql = "INSERT INTO student (sid,name,address)" +
                        " VALUES('" + id + "','" + name + "','" + address + "')";
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        //update
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = txt1.getText().toString();
                String name = txt2.getText().toString();
                String address = txt3.getText().toString();
                if(id==null || id.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter ID");
                }else {
                    try {
                        String sql = "UPDATE student SET name='" + name + "',address='" + address + "' WHERE sid='" + id + "'";
                        st.execute(sql);
                        JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        });
//delete
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = txt1.getText().toString();
                try {
                    String sql = "DELETE FROM student WHERE sid='" + id + "'";
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        //view
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String[] columns = {"Sid", "Name", "Address"};
                JTable jt = new JTable();
                DefaultTableModel model = new DefaultTableModel();
                jt.setModel(model);
                model.setColumnIdentifiers(columns);
                try {
                    String sql = "SELECT * FROM student";
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        String id = rs.getString(1);
                        String name = rs.getString(2);
                        String address = rs.getString(3);
                        model.addRow(new
                            String[]{id, name, address});
                    }
                    JScrollPane sp = new JScrollPane(jt);
                    sp.setBounds(300, 10, 250, 100);
                    jframe.add(sp);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDatabase();
            }
        });
    }
}
