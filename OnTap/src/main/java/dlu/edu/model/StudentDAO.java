/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu.model;

import dlu.edu.datahelper.DataHelper;
import java.sql.Connection;
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
public class StudentDAO {

    public List<Student> getStudents() throws SQLException {
        DataHelper dataHelper = DataHelper.getInstance();
        String sql = "Select * from [dbo].[SinhVien]";
        Connection conn = dataHelper.getConnection();
        List<Student> students = new ArrayList<>();

        try {
            Statement selectStatement = conn.createStatement();
            ResultSet result = selectStatement.executeQuery(sql);
            while (result.next()) {
                String maSv = result.getString("masv");
                String ten = result.getString("hoten");
                String email = result.getString("email");
                String sodt = result.getString("sodt");
                int gioiTinh = result.getInt("gioitinh");
                String diaChi = result.getString("diachi");

                Student student = new Student(maSv, ten, email, sodt, diaChi, gioiTinh);
                students.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataHelper.closeConnection();
        }

        return students;
    }

    public boolean insert(Student std) throws Exception {
        DataHelper dataHelper = DataHelper.getInstance();
        String sql = "insert into [dbo].[SinhVien](masv, hoten, email, sodt, gioitinh, diachi) values (?, ?, ? ,?,?,?)";
        try {
            Connection conn = dataHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, std.getMaSV());
            preparedStatement.setString(2, std.getHoTen());
            preparedStatement.setString(3, std.getEmail());
            preparedStatement.setString(4, std.getSoDT());
            preparedStatement.setInt(5, std.getGioiTinh());
            preparedStatement.setString(6, std.getDiaChi());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dataHelper.closeConnection();
        }
    }

    public boolean delete(Student std) throws SQLException {
        DataHelper dataHelper = DataHelper.getInstance();
        String sql = "delete from [dbo].[SinhVien] where [masv] = ?";
        try {
            Connection conn = dataHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, std.getMaSV());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dataHelper.closeConnection();
        }
    }

    public boolean edit(Student std) throws Exception {
        DataHelper dataHelper = DataHelper.getInstance();
        String sql = """
                     UPDATE [dbo].[SinhVien]
                        SET [masv] = ?
                           ,[hoten] = ?
                           ,[email] =?
                           ,[sodt] = ?
                           ,[gioitinh] =?
                           ,[diachi] = ?
                      WHERE [masv] = ?
                     """;
        try {
            Connection conn = dataHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, std.getMaSV());
            preparedStatement.setString(2, std.getHoTen());
            preparedStatement.setString(3, std.getEmail());
            preparedStatement.setString(4, std.getSoDT());
            preparedStatement.setInt(5, std.getGioiTinh());
            preparedStatement.setString(6, std.getDiaChi());
            preparedStatement.setString(7, std.getMaSV());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dataHelper.closeConnection();
        }
    }
}
