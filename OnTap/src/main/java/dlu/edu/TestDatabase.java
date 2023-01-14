/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu;

import dlu.edu.datahelper.DataHelper;
import java.sql.SQLException;

/**
 *
 * @author coder6622
 */
public class TestDatabase {

    public static void main(String[] args) throws SQLException {
        DataHelper dataHelper = DataHelper.getInstance();
        dataHelper.getConnection();
    }

}
