package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

public class StudentManagementFormController {
    public JFXTextField txtStudentID;
    public JFXTextField txtAddress;
    public JFXTextField txtStudentName;
    public TableView tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colMobile;
    public TableColumn colDOB;
    public TableColumn colGender;
    public TableColumn colOption;
    public JFXTextField txtContactNo;
    public JFXDatePicker dtpckrDOB;
    public JFXComboBox cmbGender;
    public JFXButton btnAddStudent;
    public JFXButton btnCancel;
    public JFXTextField txtSearch;

    public void addStudentOnAction(ActionEvent actionEvent) {
    }

    public void clearFormOnAction(ActionEvent actionEvent) {
    }

    public void SearchMatching(KeyEvent keyEvent) {
    }

    public void initialize(){

    }
}
