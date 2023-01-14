/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.edu.controller;

import dlu.edu.view.FormStudent1;
import dlu.edu.model.StudentDAO;
import dlu.edu.model.Student;
import dlu.edu.view.FormStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author coder6622
 */
public class StudentController {

    private FormStudent studentView;
    private StudentDAO studentDAO;

    public StudentController(FormStudent studentView) {
        this.studentDAO = new StudentDAO();
        this.studentView = studentView;
    }

    public void showStudentView() {
        List<Student> students = null;
        try {
            students = studentDAO.getStudents();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        studentView.showStudents(students);
        studentView.setVisible(true);

        studentView.addTableSelectionListener(new TableSelectionListener());
        studentView.addAddStudentListener(new AddStudentListener());
        studentView.addEditStudentListener(new EditStudentListener());
        studentView.addRemoveStudentListener(new DeleteStudentListener());

    }

    class AddStudentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student std = studentView.getStudentData();

            if (std != null) {
                boolean sucess = false;

                try {
                    sucess = studentDAO.insert(std);
                } catch (Exception ex) {
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (sucess) {
                    try {
                        studentView.showStudents(studentDAO.getStudents());
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    studentView.showMessag("Them thanh cong");
                } else {
                    studentView.showMessag("Them that bai");
                }
            }
        }

    }

    class EditStudentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student std = studentView.getStudentData();

            if (std != null) {
                boolean sucess = false;

                try {
                    sucess = studentDAO.edit(std);
                } catch (Exception ex) {
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (sucess) {
                    try {
                        studentView.showStudents(studentDAO.getStudents());
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    studentView.showMessag("Chinh sua thanh cong");
                } else {
                    studentView.showMessag("Chinh sua that bai");
                }
            }
        }

    }

    class DeleteStudentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student std = studentView.getStudentData();

            if (std != null) {
                boolean sucess = false;

                try {
                    sucess = studentDAO.delete(std);
                } catch (SQLException ex) {
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (sucess) {
                    try {
                        studentView.showStudents(studentDAO.getStudents());
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    studentView.showMessag("Xoa thanh cong");
                } else {
                    studentView.showMessag("Xoa that bai");
                }
            }
        }

    }

    class TableSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillInputForm();
        }
    }
}
