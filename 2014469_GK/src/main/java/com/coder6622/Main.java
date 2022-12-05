package com.coder6622;

import com.coder6622.controllers.ProductController;
import com.coder6622.view.ProductView;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ProductView view = new ProductView();

            ProductController controller = new ProductController(view);

            controller.showProductView();
        });
    }
}
