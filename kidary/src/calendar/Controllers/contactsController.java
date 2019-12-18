/**
 * @file contactsController
 * @author Ivana Saranová, xsaran02
 */
package calendar.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static calendar.Controllers.Kidary.getCm;

public class contactsController implements Initializable {
//    @FXML
//    public JFXButton buttonBack;
    @FXML
    public GridPane bodyGrid;

    @FXML
    public JFXButton buttonCreate;

    @FXML
    public JFXButton drop;

    private int j =0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillContacts();

        buttonCreate.setOnAction(event -> {
            Stage stage = (Stage) buttonCreate.getScene().getWindow();

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/newContact.fxml"));
                Stage window = new Stage();
                window.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        // Refresh the parent window here
                        fillContacts();
                    }
                });
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
            for ( j = 0; j<getCm().a.size(); j++) {

                Label text = new Label(getCm().a.get(j)[i]);

                bodyGrid.add(text,i,j+1);
            }
        }

    }
}
