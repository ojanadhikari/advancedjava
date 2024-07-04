package Unit2JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ozads
 * @version v1.0
 * @project JAVA TUTORIAL
 * @since 2024-04-24
 **/
public class Connect {
    public static void main(String[] args) {
        String user = "root";
        String password = "root";
        String host = "localhost";
        String port = "3306";
        String databaseName = "AADIM";
        String databaseType = "mysql";
        String jdbcUrl = "jdbc:"+databaseType+"://" + host + ":" + port + "/" + databaseName;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
            Statement statement = connection.createStatement();
            System.out.println("Connection Successful");
//            C
//            String insertionQuery = "insert into student values(6,'ada')";
//            int i = statement.executeUpdate(insertionQuery);
//            System.out.println("Records updated:"+ i);

            //U
//
//            String updateQuery = "update student set name='hizz' where id=6";
//            int j = statement.executeUpdate(updateQuery);
//            System.out.println("Records updated:"+ j);

            //D
//
//            String deletiopQuery = "delete from student where id = 6";
//            int k =statement.executeUpdate(deletiopQuery);
//            System.out.println("Records Updated:"+k);

            //R
//
            String retrievalQuery = "select * from student";
            ResultSet resultSet = statement.executeQuery(retrievalQuery);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                students.add(student);
                System.out.println(
                    "Name:"+resultSet.getString("name")+
                        " id:"+resultSet.getInt("id"));
            }
            connection.close();
        }catch (Exception e){
            System.out.println("Connection Failed due to " + e.getMessage());
        }
    }
}
