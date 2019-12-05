package calendar;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class manageCalendarController {
    @FXML
    public JFXButton add;
    @FXML
    public JFXButton Petr;

    public void initialize() throws IOException {
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
                Stage stage = (Stage) Petr.getScene().getWindow();
                try {
                    getViewMonthCalendar(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getViewMonthCalendar(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("monthCalendar.fxml"));
        window.setScene(new Scene(root, 1100 ,700));
        window.setTitle("Kidary");
        window.show();
    }
}
