package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

public class UserManagementFormController {
    public JFXTextField txtNic;
    public JFXTextField txtConfirmPassword;
    public JFXTextField txtPassword;
    public JFXTextField txtName;
    public JFXTextField txtUserName;
    public JFXButton btnAddUser;
    public JFXButton btnCancel;

    public void addUserOnAction(ActionEvent actionEvent) {
        if(btnAddUser.getText().equals("Add User")){

        }
    }

    public void clearFormOnAction(ActionEvent actionEvent) {
    }
}
