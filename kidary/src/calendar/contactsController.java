package calendar;

import calendar.Models.contactModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static calendar.Calendar.getCm;

public class contactsController implements Initializable {
//    @FXML
//    public JFXButton buttonBack;
    @FXML
    public GridPane bodyGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillContacts();


//        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Stage stage = (Stage) buttonBack.getScene().getWindow();
//                try {
//                    goBack(stage);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    public void fillContacts() {

        for (int i=0; i<4; i++){
            for (int j = 0; j<5; j++) {

                Label text = new Label(getCm().a[j][i]);

                bodyGrid.add(text,i,j+1);
            }
        }

    }
}
