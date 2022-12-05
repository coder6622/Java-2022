/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coder6622;

import com.coder6622.model.Product;
import com.coder6622.model.ProductDAO;
import java.util.List;

/**
 *
 * @author coder6622
 */
public class TestDatabase {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        List<Product> products = productDAO.getProducts();

//        CRUD
//C - CRATE
//R - READ
//U - UPDATE
//D - DELETE
        for (Product product : products) {
            System.out.println(product.getTenSP());
        }

        Product newProduct = new Product("SP03", "Pho", "Thung", 500000, "Tuong An");

        if (productDAO.delete(newProduct)) {
            System.out.println("Them thanh cong");
        } else {
            System.out.println("Khong them thanh cong");
        }
    }

}
