/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author coder6622
 */
public class StudentModelTable extends AbstractTableModel {

    private final String[] columnNames = {"Mã sinh viên", "Tên sinh viên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ"};
    private List<Student> students;

    public StudentModelTable() {
        students = new ArrayList<>();
    }

    public void setData(List<Student> students) {
        this.students = students;

        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);

        switch (columnIndex) {
            case 0 -> {
                return student.getMaSV();
            }
            case 1 -> {
                return student.getHoTen();
            }
            case 2 -> {
                return student.getEmail();
            }
            case 3 -> {
                return student.getSoDT();
            }
            case 4 -> {
                return student.getDiaChi();
            }
            case 5 -> {
                return student.getGioiTinh();
            }
            default ->
                throw new AssertionError();
        }
    }

}
