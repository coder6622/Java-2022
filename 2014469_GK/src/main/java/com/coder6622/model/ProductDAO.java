/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coder6622.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coder6622
 */
public class ProductDAO {

    public ProductDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't load driver");
        }
    }

    private Connection getConnection() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=false;database=product;integratedSecurity=false;";

        String user = "test";
        String pass = "999999999";
        System.out.println("Dang ket noi");
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, user, pass);
            System.out.println("Databases connected");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Can't connect to database");
            throw new RuntimeException(ex);
        }
    }

    private void closeConnection(Connection conn) {
        try {
            conn.close();
            System.out.println("Database closed");
        } catch (SQLException ex) {
            System.out.println("Can't close connection");
            throw new RuntimeException(ex);
        }
    }

    public List<Product> getProducts() {
        Connection conn = getConnection();
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Product_TBL]";

        try {
            Statement selectStatement = conn.createStatement();
            ResultSet result = selectStatement.executeQuery(sql);
            while (result.next()) {
                String maSp = result.getString("MaSP");
                String tenSp = result.getString("TenSP");
                String dvt = result.getString("DVT");
                int donGiaBan = result.getInt("DonGiaBan");
                String nhaCungCap = result.getString("NhaCungCap");

                Product product = new Product(maSp, tenSp, dvt, donGiaBan, nhaCungCap);
                products.add(product);
            }

            selectStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return products;
    }

    public boolean add(Product product) {
        Connection conn = getConnection();

        String sql = """
                     INSERT INTO [dbo].[Product_TBL]
                                ([MaSP]
                                ,[TenSP]
                                ,[DVT]
                                ,[DonGiaBan]
                                ,[NhaCungCap])
                          VALUES
                                (?,?,?,?,? )""";

        try {
            PreparedStatement insertStatement;
            insertStatement = conn.prepareStatement(sql);
            insertStatement.setString(1, product.getMaSP());
            insertStatement.setString(2, product.getTenSP());
            insertStatement.setString(3, product.getDvt());
            insertStatement.setInt(4, product.getDonGia());
            insertStatement.setString(5, product.getNhaCungCap());

            insertStatement.executeUpdate();

            insertStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return false;
    }

    public boolean edit(Product product) {
        Connection conn = getConnection();

        String sql = """
                     UPDATE [dbo].[Product_TBL]
                        SET [TenSP] = ?
                           ,[DVT] = ?
                           ,[DonGiaBan] = ?
                           ,[NhaCungCap] = ?
                      WHERE [MaSP] = ?""";

        try {
            PreparedStatement updateStatement;
            updateStatement = conn.prepareStatement(sql);
            updateStatement.setString(1, product.getTenSP());
            updateStatement.setString(2, product.getDvt());
            updateStatement.setInt(3, product.getDonGia());
            updateStatement.setString(4, product.getNhaCungCap());
            updateStatement.setString(5, product.getMaSP());

            updateStatement.executeUpdate();

            updateStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return false;
    }

    public boolean delete(Product product) {
        Connection conn = getConnection();

        String sql = """
                     DELETE FROM [dbo].[Product_TBL]
                            WHERE [MaSP] = ?""";

        try {
            PreparedStatement deleteStatement;
            deleteStatement = conn.prepareStatement(sql);

            deleteStatement.setString(1, product.getMaSP());

            deleteStatement.executeUpdate();

            deleteStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return false;
    }
}
