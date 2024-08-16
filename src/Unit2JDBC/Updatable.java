package Unit2JDBC;

import java.sql.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-08-15
 **/
public class Updatable {

//    alter table student add  PRIMARY_KEY(id);


    public static void main(String[] args) {
        String user = "root";
        String password = "root";
        String host = "localhost";
        String port = "3306";
        String databaseName = "AADIM";
        String databaseType = "mysql";
        String jdbcUrl = "jdbc:" + databaseType + "://" + host + ":" + port + "/" + databaseName;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

            String sql = "SELECT id, name FROM student";
            ResultSet rs = stmt.executeQuery(sql);

            rs.absolute(3);

            rs.updateString("name","Shyam");
            rs.updateRow();
            System.out.println("Updated data in third row");


            rs.moveToInsertRow();
            rs.updateInt("id",6);
            rs.updateString("name","Shivalal");
            rs.insertRow();
            System.out.println("Inserted new data");

            rs.last();
            rs.deleteRow();
            System.out.println("deleted data");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
