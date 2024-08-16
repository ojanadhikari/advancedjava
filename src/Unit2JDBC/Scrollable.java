package Unit2JDBC;

import java.sql.*;

/**
 * @author Ozads
 * @version v1.0
 * @project advanced java
 * @since 2024-08-15
 **/
public class Scrollable {

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
                 ResultSet.CONCUR_READ_ONLY)) {

            String sql = "SELECT id, name FROM student";
            ResultSet rs = stmt.executeQuery(sql);

            // Move to the last row and display the data
            rs.last();
            System.out.println("Last Row: ID=" + rs.getInt("id") + ", Name=" + rs.getString("name"));

            // Move to the first row and display the data
            rs.first();
            System.out.println("First Row: ID=" + rs.getInt("id") + ", Name=" + rs.getString("name"));

            // Move to a specific row (e.g., third row)
            rs.absolute(3);
            System.out.println("Third Row: ID=" + rs.getInt("id") + ", Name=" + rs.getString("name"));

            // Move to the previous row
            rs.previous();
            System.out.println("Previous Row: ID=" + rs.getInt("id") + ", Name=" + rs.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
