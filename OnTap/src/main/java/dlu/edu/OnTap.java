/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package dlu.edu;

import dlu.edu.controller.StudentController;
import dlu.edu.view.FormStudent;
import java.awt.EventQueue;

/**
 *
 * @author coder6622
 */
public class OnTap {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FormStudent view = new FormStudent();

            StudentController controller = new StudentController(view);
            controller.showStudentView();

        });
    }
}
