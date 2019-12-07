package calendar;

import calendar.Models.Message;
import calendar.Models.messengerModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class messengerController implements Initializable {
    @FXML
    public JFXButton buttonBack;
    @FXML
    public VBox bodyVBox;
    public JFXButton buttonSend;
    public JFXButton buttonRefresh;
    public JFXTextField text;


    private messengerModel mm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mm = new messengerModel();
        fillMessager();


        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) buttonBack.getScene().getWindow();
                try {
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fillMessager();
            }
        });

        buttonSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Message m = new Message();
                m.my = false;
                m.date = LocalDate.now();
                m.msg = text.getText();
                text.setText("");
                mm.messages.add(m);
                mm.saveMsgs();
                fillMessager();
            }
        });

    }

    public void fillMessager() {
        mm.loadMsgs();
        bodyVBox.getChildren().clear();

        for (int i = 0; i < mm.messages.size(); i++) {
            Label text = new Label(mm.messages.get(i).msg);
            Label date = new Label(mm.messages.get(i).date.toString());
            VBox msgbox = new VBox();
            msgbox.getChildren().add(date);
            msgbox.getChildren().add(text);
            if (mm.messages.get(i).my) {
                msgbox.setStyle("-fx-background-color: #a5bbb3; -fx-background-radius: 20px;");
            } else {
                msgbox.setStyle("-fx-background-color: #9fa5bb; -fx-background-radius: 20px;");
            }

            bodyVBox.getChildren().add(msgbox);
        }

    }
}