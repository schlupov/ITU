package calendar;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static calendar.Calendar.setEventName;

public class weekCalendarController implements Initializable {

    @FXML
    public GridPane bodyPane;
    @FXML
    public GridPane calendarGrid;
    @FXML
    public GridPane calendarHeader;
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
    @FXML
    public JFXButton newEvent;
    @FXML
    public JFXButton contacts;
    @FXML
    public JFXButton messenger;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // nastavi jmeno na Petr, pokud uzivatel kliknul na tlacitko Petr
        labelName.setText(labelName.getText() + Calendar.getMyVariable());
        labelName.setStyle("" +
                "-fx-font-family: 'Helvetica', Arial, sans-serif;" +
                " -fx-font-weight: bold; -fx-text-fill: white;" +
                " -fx-font-size: 24px;"
        );

        bodyPane.setHgap(3);
        bodyPane.setVgap(3);
        bodyPane.setPadding(new Insets(3, 3, 3, 3));

        for (int i = 0; i < 2; i++) {

            LocalDate today = LocalDate.now();

            LocalDate monday = today;
            while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
                monday = monday.minusDays(1);
            }

            for (int j = 0; j < 7; j++) {
                if (i == 0) {

                    Label dateLabel = new Label(monday.toString());
                    dateLabel.setStyle("-fx-text-fill: white;");

                    VBox day = new VBox();
                    String whichDayInWeek = getDay(j);
                    Label label = new Label(whichDayInWeek);
                    label.setStyle("-fx-text-fill: white;");
                    day.setPrefHeight(20);
                    day.setMaxHeight(30);
                    day.setStyle("-fx-background-color: #6C7B8B; -fx-min-height: 50px;");

                    day.getChildren().add(dateLabel);
                    day.getChildren().add(label);

                    day.setAlignment(Pos.CENTER);
                    calendarHeader.add(day, j+1, i);

                    monday = monday.plusDays(1);
                }
            }
            for (int t = 0 ; t<24; t++) {

                String text = String.valueOf(t) + ":00";
                calendarGrid.add(new Label(text), 0,t);
            }
        }

        addEvent(calendarGrid, 0, 8, "Angličtina");
        addEvent(calendarGrid, 1,12, "Matematika");
        addEvent(calendarGrid, 1,23, "Matematika");

        leftTopVBoxCalendar.setSpacing(8);

        backButton.setOnAction(event -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            try {
                goBack(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        newEvent.setOnAction(event -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            try {
                newEvent(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        contacts.setOnAction(event -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("contacts.fxml"));
                Stage window = new Stage();
                window.setTitle("Kidary");
                window.setScene(new Scene(root, 350, 430));
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        messenger.setOnAction(event -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("messenger.fxml"));
                Stage window = new Stage();
                window.setTitle("Kidary");
                window.setScene(new Scene(root, 350, 430));
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void addEvent(GridPane gridPane, int day, int time, String subject) {
        VBox calendarEvent = new VBox();
        //calendarEvent.setSpacing(8);
        //calendarEvent.setPadding(new Insets(5, 5, 5, 5));
        switch (subject) {
            case "Angličtina":
                calendarEvent.setStyle("-fx-background-color: #DB2645; -fx-background-radius: 20px;");
                break;
            case "Matematika":
                calendarEvent.setStyle("-fx-background-color: #4CBB17; -fx-background-radius: 20px;");
                break;
        }
        Label label = new Label(subject);
        label.setStyle("-fx-text-fill: white;");
        calendarEvent.getChildren().add(label);
        calendarEvent.setAlignment(Pos.CENTER);
        calendarEvent.setOnMouseClicked(event -> {
            setEventName(subject);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("eventDetail.fxml"));
                Stage window = new Stage();
                window.setTitle("Kidary");
                window.setScene(new Scene(root, 350, 430));
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        gridPane.add(calendarEvent, day+1, time, 1 , 2);
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
        window.setScene(new Scene(root, 1300, 850));
        window.setTitle("Kidary");
        window.show();
    }

    private void newEvent(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newEvent.fxml"));
        window.setScene(new Scene(root, 650, 850));
        window.setTitle("Kidary");
        window.show();
    }
}
