package controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginFormController {

    public AnchorPane MainPane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXTextField txtShowPassword;
    public JFXButton btnLogin;
    private double xOffset = 0;
    private double yOffset = 0;
    private LoginBO lBO = (LoginBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LOGIN);

    public void setPosition(MouseEvent mouseEvent) {
        Stage stage = (Stage) MainPane.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() + xOffset);
        stage.setY(mouseEvent.getScreenY() + yOffset);
    }

    public void getPositionOnClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) MainPane.getScene().getWindow();
        xOffset = stage.getX() - mouseEvent.getScreenX();
        yOffset = stage.getY() - mouseEvent.getScreenY();

    }

    public void ExitApplcationOnAction(ActionEvent actionEvent) {
        javafx.application.Platform.exit();
    }

    public void minimizeApplcationOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) MainPane.getScene().getWindow();
        stage.setIconified(true);
    }

    public void LogInOnAction(ActionEvent actionEvent) {
        try {
            if(lBO.checkCredentials(txtUserName.getText(),txtPassword.getText())){
                MainPane.getChildren().clear();
                MainPane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml")));
            }else{
                new Alert(Alert.AlertType.WARNING,"Incorrect UserName Or Password", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UnmaskPassword(MouseEvent mouseEvent) {
        txtShowPassword.setText(txtPassword.getText());
        txtShowPassword.setVisible(true);
    }

    public void MaskPassword(MouseEvent mouseEvent) {
        txtShowPassword.setVisible(false);
        txtPassword.requestFocus();
    }

    public void checkCredentials(ActionEvent actionEvent) {
        btnLogin.fire();
    }
}
