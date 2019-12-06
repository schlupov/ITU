package calendar;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static calendar.Calendar.setMyVariable;

public class manageCalendarController implements Initializable {
    @FXML
    public JFXButton add;
    @FXML
    public JFXButton Petr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("newCalendar.fxml"));
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
    }

    private void getViewWeekCalendar(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("weekCalendar.fxml"));
        window.setScene(new Scene(root, 1300 ,850));
        window.setTitle("Kidary");
        window.show();
    }
}
