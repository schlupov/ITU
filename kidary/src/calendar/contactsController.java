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
import javafx.scene.control.Button;
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

    @FXML
    public JFXButton buttonCreate;

    @FXML
    public JFXButton drop;

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

        buttonCreate.setOnAction(event -> {
            Stage stage = (Stage) buttonCreate.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("newContact.fxml"));
                Stage window = new Stage();
                window.setTitle("Kidary");
                window.setScene(new Scene(root, 400, 300));
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
