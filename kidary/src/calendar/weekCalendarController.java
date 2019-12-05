package calendar;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class weekCalendarController  implements Initializable {

    @FXML
    public GridPane bodyPane;
    @FXML
    public VBox leftTopVBoxCalendar;
    @FXML
    public GridPane monday;
    @FXML
    public GridPane tuesday;
    @FXML
    public GridPane wednesday;
    @FXML
    public GridPane thursday;
    @FXML
    public GridPane saturday;
    @FXML
    public GridPane friday;
    @FXML
    public GridPane sunday;
    @FXML
    public JFXButton backButton;
    @FXML
    public Label labelName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // nastavi jmeno na Petr, pokud uzivatel kliknul na tlacitko Petr
        labelName.setText(labelName.getText() + Calendar.getMyVariable());
        labelName.setStyle("-fx-font-family: 'Helvetica', Arial, sans-serif; -fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 24px");

        bodyPane.setHgap(3);
        bodyPane.setVgap(3);
        bodyPane.setPadding(new Insets(3, 3, 3, 3));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <7; j++) {
                if (i == 0) {
                    VBox day = new VBox();
                    String whichDayInWeek = getDay(j);
                    Label label = new Label(whichDayInWeek);
                    label.setStyle("-fx-text-fill: white;");
                    day.setPrefHeight(20);
                    day.setMaxHeight(30);
                    day.setStyle("-fx-background-color: #6C7B8B; -fx-min-height: 50px;");
                    day.getChildren().add(label);
                    day.setAlignment(Pos.CENTER);
                    bodyPane.add(day, j,i);
                }
            }
        }

        addEvent(monday, 1, "Angličtina");
        addEvent(tuesday, 4, "Matematika");

        leftTopVBoxCalendar.setSpacing(8);

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) backButton.getScene().getWindow();
                try {
                    goBack(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addEvent(GridPane gridPane, int time, String subject) {
        VBox event = new VBox();
        event.setSpacing(8);
        event.setPadding(new Insets(5, 5, 5, 5));
        switch (subject) {
            case "Angličtina":
                event.setStyle("-fx-background-color: #DB2645; -fx-background-radius: 20px;");
                break;
            case "Matematika":
                event.setStyle("-fx-background-color: #4CBB17; -fx-background-radius: 20px;");
                break;
        }
        Label label = new Label(subject);
        label.setStyle("-fx-text-fill: white;");
        event.getChildren().add(label);
        event.setAlignment(Pos.CENTER);
        gridPane.add(event, 0,time);
    }

    private String getDay(int numberOfDayInWeek) {
        switch (numberOfDayInWeek) {
            case 0:
                return "Pondělí";
            case 1:
                return "Úterý";
            case 2:
                return "Středa";
            case 3:
                return "Čtvrtek";
            case 4:
                return "Pátek";
            case 5:
                return "Sobota";
            case 6:
                return "Neděle";
        }
        return null;
    }

    private void goBack(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("calendarDetail.fxml"));
        window.setScene(new Scene(root, 1300 ,850));
        window.setTitle("Kidary");
        window.show();
    }
}
