package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import view.tm.StudentTM;

import java.util.ArrayList;

public class StudentManagementFormController {
    public JFXTextField txtStudentID;
    public JFXTextField txtAddress;
    public JFXTextField txtStudentName;
    public TableView<StudentTM> tblStudent;
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

    private StudentBO sBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);
    public void addStudentOnAction(ActionEvent actionEvent) {
    }

    public void clearFormOnAction(ActionEvent actionEvent) {
    }

    public void SearchMatching(KeyEvent keyEvent) {
    }

    public void initialize(){
    cmbGender.getItems().addAll("Male","Female","Rather Not Specify","Custom");
    colId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));
    colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    colMobile.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
    colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
    colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        try {
            loadStudents(sBO.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStudents(ArrayList<StudentDTO> students) {
    }
}
