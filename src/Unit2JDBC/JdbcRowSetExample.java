package Unit2JDBC;

import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;

public class JdbcRowSetExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/AADIM";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (JdbcRowSet jdbcRowSet = new JdbcRowSetImpl()) {
            jdbcRowSet.setUrl(DB_URL);
            jdbcRowSet.setUsername(USER);
            jdbcRowSet.setPassword(PASSWORD);
            jdbcRowSet.setCommand("SELECT id, name FROM student");
            jdbcRowSet.execute();

            // Navigate and update data
            while (jdbcRowSet.next()) {
                System.out.println("ID: " + jdbcRowSet.getInt("id") + ", Name: " + jdbcRowSet.getString("name"));
                if (jdbcRowSet.getInt("id") == 2) {
                    jdbcRowSet.updateString("name", "Updated Name via JdbcRowSet");
                    jdbcRowSet.updateRow();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
