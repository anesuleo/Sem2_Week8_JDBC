package ie.atu;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {
        // MySQL database connection details
        String url = "jdbc:mysql://localhost:3306/formula1";
        String username = "root";
        String password = "password";

        // SQL statement
        String selectSQL = "SELECT * " +
                "FROM driver ";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");

                System.out.println("Driver: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
