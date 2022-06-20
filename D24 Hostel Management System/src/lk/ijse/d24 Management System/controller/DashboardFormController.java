package controller;

import animatefx.animation.*;
import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class DashboardFormController {
    public AnchorPane MainPane;
    public Label lblHome;
    public Label lblKey;
    public Label lblUsers;
    public Label lblRooms;
    public Label lblStudent;
    public AnchorPane NavigationContext;

    /*   Stage stage = null;
       double xOffset=0;
       double yOffset=0;*/
    public void initialize() throws IOException {
        setUI("HomeForm");
      /*  DropShadow shadow = new DropShadow();
        shadow.setColor(Color.BLACK);
        MainPane.setEffect(shadow);*/
/*        MainPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });


        MainPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });*/
    }

    public void ExitApplcationOnAction(ActionEvent actionEvent) {
        javafx.application.Platform.exit();
    }

    public void ScaleUpOnEntered(MouseEvent mouseEvent) {
        JFXButton btn = (JFXButton) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(100), btn);
        scaleT.setToX(1.12);
        scaleT.setToY(1.12);
        scaleT.play();

    }

    public void ScaleDownOnExit(MouseEvent mouseEvent) {
        JFXButton btn = (JFXButton) mouseEvent.getSource();
        ScaleTransition scaleT = new ScaleTransition(Duration.millis(100), btn);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();

    }

    private void setUI(String URI) throws IOException {
        NavigationContext.getChildren().clear();
        NavigationContext.getChildren().add(FXMLLoader.load(getClass().getResource("/view/"+URI+".fxml")));
        new FadeIn(NavigationContext).play();
    }

    public void minimizeApplcationOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) MainPane.getScene().getWindow();
        stage.setIconified(true);
    }


    public void toStudentsOnAction(ActionEvent actionEvent) throws IOException {
        manageButtonLabels(lblStudent);
        setUI("StudentManagementForm");
    }

    public void toRoomsOnAction(ActionEvent actionEvent) throws IOException {
        manageButtonLabels(lblRooms);
        setUI("RoomManagementForm");
    }

    public void toHomeOnAction(ActionEvent actionEvent) throws IOException {
        manageButtonLabels(lblHome);
       setUI("HomeForm");
    }

    public void toKeyOnAction(ActionEvent actionEvent) throws IOException {
        manageButtonLabels(lblKey);
        setUI("FindPendingKeyPaymentForm");
    }

    public void toUsersOnAction(ActionEvent actionEvent) throws IOException {
        manageButtonLabels(lblUsers);
        setUI("UserManagementForm");
    }

    private void manageButtonLabels(Label label){
        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(lblStudent);
        labelList.add(lblRooms);
        labelList.add(lblHome);
        labelList.add(lblUsers);
        labelList.add(lblKey);

        for (Label l : labelList){
            if(l.equals(label)){
                l.setVisible(true);
                continue;
            }
            l.setVisible(false);
        }
    }
}
