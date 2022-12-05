/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coder6622.model;

import com.coder6622.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author coder6622
 */
public class ProductTableModel extends AbstractTableModel {

    private final String[] columnNames
            = {"MaSP", "TenSP", "DVT", "Don gia ban", "Nha cung cap"};
    private List<Product> products;

    public String[] getColumnNames() {
        return columnNames;
    }

    public ProductTableModel() {
        products = new ArrayList<>();
    }

    public void setData(List<Product> products) {
        this.products = products;

        // Mỗi khi dữ liệu của tableModel được cập nhật qua hàm setData thì 
        // tableModel sẽ thông báo cho cái table trong View cập lại
//        fireTableDataChanged();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return product.getMaSP();
            }
            case 1 -> {
                return product.getTenSP();
            }
            case 2 -> {
                return product.getDvt();
            }
            case 3 -> {
                return product.getDonGia();
            }
            case 4 -> {
                return product.getNhaCungCap();
            }
            default -> {
                throw new AssertionError();

            }
        }
    }
}
