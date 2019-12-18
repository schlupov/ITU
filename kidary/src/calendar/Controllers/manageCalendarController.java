/**
 * @file manageCalendarController
 * @author Ivana Saranová, xsaran02
 */
package calendar.Controllers;

import calendar.Models.User;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static calendar.Controllers.Kidary.*;

public class manageCalendarController implements Initializable {
    @FXML
    public JFXButton add;
    @FXML
    public JFXButton Petr;
    @FXML
    public VBox vboxNewUser;
    @FXML
    public JFXButton Nina;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage previousStage = (Stage) add.getScene().getWindow();
                    setPreviousStage(previousStage);
                    Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/newCalendar.fxml"));
                    Stage window = new Stage();
                    window.setTitle("Kidary");
                    window.setScene(new Scene(root, 400, 300));
                    window.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Petr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setMyVariable("Petr");
                Stage stage = (Stage) Petr.getScene().getWindow();
                try {
                    getViewWeekCalendar(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        User loggedUser = getLoggedUser();
        if (loggedUser.username.equals("Petr")) {
            Nina.setVisible(false);
        }

        if (getNewCalendar() != null && !getNewCalendar().isEmpty()) {
            JFXButton button = new JFXButton(getNewCalendar());
            button.setStyle("-jfx-button-type: FLAT;" +
                    "-fx-background-color: #F5F4EF;" +
                    "-fx-text-fill: BLACK;" +
                    "-fx-font-size: 30px;-fx-pref-width: 200px; " +
                    "-fx-pref-height: 62px");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setMyVariable(getNewCalendar());
                    Stage stage = (Stage) Petr.getScene().getWindow();
                    try {
                        getViewWeekCalendar(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            vboxNewUser.getChildren().add(button);
        }
    }

    private void getViewWeekCalendar(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/weekCalendar.fxml"));
        window.setScene(new Scene(root, 1300 ,850));
        window.setTitle("Kidary");
        window.show();
    }
}
