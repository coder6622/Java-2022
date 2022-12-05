/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coder6622.controllers;

import com.coder6622.model.Product;
import com.coder6622.model.ProductDAO;
import com.coder6622.view.ProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author coder6622
 */
public class ProductController {

    private ProductView productView;
    private ProductDAO productDAO;

    public ProductController(ProductView view) {
        this.productView = view;

        productDAO = new ProductDAO();

        productView.addAddProductListener(new AddProductListener());

        productView.addTableSelectionListener(new TableSelectionListener());

        productView.addEditProductListener(new EditProductListener());

        productView.addDeleteProductListener(new DeleteProductListener());
    }

    public void showProductView() {

        List<Product> products = productDAO.getProducts();
        productView.showListProduct(products);

        productView.setVisible(true);
    }

    class AddProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.add(product);

                if (success) {
                    productView.showListProduct(productDAO.getProducts());

                    productView.showMessage("Thêm thành công!");
                } else {
                    productView.showMessage("Thêm thất bại!");
                }
            }
        }

    }

    class EditProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.edit(product);

                if (success) {
                    productView.showListProduct(productDAO.getProducts());

                    productView.showMessage("Sửa thành công!");
                } else {
                    productView.showMessage("Sửa thất bại!");
                }
            }
        }
    }

    class DeleteProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Product product = productView.getProductData();

            if (product != null) {
                boolean success = productDAO.delete(product);

                if (success) {
                    productView.showListProduct(productDAO.getProducts());

                    productView.showMessage("Xóa thành công!");
                } else {
                    productView.showMessage("Xóa thất bại!");
                }
            }
        }
    }

    class TableSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            productView.fillInputForm();
        }
    }
}
