package Unit2JDBC;

import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;

public class CachedRowSetExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/AADIM";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (CachedRowSet cachedRowSet = new CachedRowSetImpl()) {
            cachedRowSet.setUrl(DB_URL);
            cachedRowSet.setUsername(USER);
            cachedRowSet.setPassword(PASSWORD);
            cachedRowSet.setCommand("SELECT id, name FROM student");
            cachedRowSet.execute();

            // Navigate and update data
            while (cachedRowSet.next()) {
                System.out.println("ID: " + cachedRowSet.getInt("id") + ", Name: " + cachedRowSet.getString("name"));
                if (cachedRowSet.getInt("id") == 3) {
                    cachedRowSet.updateString("name", "Updated Name via CachedRowSet");
                    cachedRowSet.updateRow();
                }
            }

            // Write changes back to the database
            cachedRowSet.acceptChanges();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
