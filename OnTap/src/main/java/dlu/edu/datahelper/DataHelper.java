/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu.datahelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author coder6622
 */
public class DataHelper {

    private static DataHelper instanceDataHelper;

    private DataHelper() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't load driver");
        }
    }

    public static DataHelper getInstance() throws SQLException {

        if (instanceDataHelper == null) {
            instanceDataHelper = new DataHelper();
        } else if (instanceDataHelper.getConnection().isClosed()) {
            instanceDataHelper = new DataHelper();
        }
        return instanceDataHelper;
    }

    public Connection getConnection() {
        String connUrl = "jdbc:sqlserver://localhost:1433;encrypt=false;database=Student;integeratedSecurity=false;";
        String user = "Group5";
        String pass = "123";

        System.out.println("Dang ket noi");
        try {
            Connection conn = DriverManager.getConnection(connUrl, user, pass);
            System.out.println("Database connected");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Can't connect to database");
            throw new RuntimeException(ex);
        }
    }

    public void closeConnection() {
        try {
            instanceDataHelper.getConnection().close();
            System.out.println("Database closed");
        } catch (SQLException ex) {
            System.out.println("Can't close connection");
            throw new RuntimeException(ex);
        }
    }
}
