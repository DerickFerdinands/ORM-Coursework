package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

public class RoomManagementFormController {
    public JFXTextField txtTypeID;
    public JFXTextField txtQty;
    public JFXTextField txtRoomType;
    public TableView tblRooms;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public TableColumn colOption;
    public JFXTextField txtKeyMoney;
    public JFXButton btnAddRoom;
    public JFXButton btnCancel;
    public JFXTextField txtSearch;

    public void addStudentOnAction(ActionEvent actionEvent) {
    }

    public void initialize(){
    btnAddRoom.setDisable(true);

    }

    public void ValidateFields(KeyEvent keyEvent) {
    }

    public void clearFOrmOnAction(ActionEvent actionEvent) {
    }

    public void SearchMatchingResults(KeyEvent keyEvent) {
    }
}
