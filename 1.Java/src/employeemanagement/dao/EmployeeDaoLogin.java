package employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import employeemanagement.web.EmployeeLogin;

public class EmployeeDaoLogin {
	public boolean validate(EmployeeLogin employeedaologin) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
        	.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "rithvik99");

            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from employee where username = ? and password = ? ")) {
            preparedStatement.setString(1, employeedaologin.getUsername());
            preparedStatement.setString(2, employeedaologin.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
