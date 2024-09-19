package tek_insurance.tdd.api.test;

import org.testng.annotations.Test;

import java.sql.*;

public class DataBaseConnectivityTest {
    @Test
    public void dataBaseConnectionTest(){
        //Step 1: Create connection
        String url = "jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app";
        String username = "tek_student_user";
        String password = "FEB_2024";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            //Step 2: Create statement
            Statement statement = connection.createStatement();
            //Step 3: execute query
            ResultSet result = statement.executeQuery("select * from primary_person where id = 10107;");
            //Step 4: Get result set
            while (result.next()){
                System.out.println(result.getString("id"));
                System.out.println(result.getString("email"));
                System.out.println(result.getString("date_of_birth"));
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    @Test
    public void retrieveLastIdFromPrimaryPersonDB(){
        String url = "jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app";
        String username = "tek_student_user";
        String password = "FEB_2024";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from primary_person where id = (select MAX(id) from primary_person);");
            result.next();
                System.out.println(result.getString("id"));
                System.out.println(result.getString("email"));
                System.out.println(result.getString("date_of_birth"));

        } catch (SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }


    }
}
