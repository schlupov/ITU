package calendar;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class weekCalendarController {

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


    public void initialize() throws IOException {
        bodyPane.setHgap(3); //horizontal gap in pixels
        bodyPane.setVgap(3); //vertical gap in pixels
        bodyPane.setPadding(new Insets(3, 3, 3, 3));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <7; j++) {
                if (i == 0) {
                    VBox day = new VBox();
                    String whichDayInWeek = getDay(j);
                    Label label = new Label(whichDayInWeek);
                    day.setStyle("-fx-background-color: #6C7B8B; -fx-min-height: 50px;");
                    day.getChildren().add(label);
                    bodyPane.add(day, j,i);
                    day.setAlignment(Pos.CENTER);
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
        window.setScene(new Scene(root, 1100 ,700));
        window.setTitle("Kidary");
        window.show();
    }

}
