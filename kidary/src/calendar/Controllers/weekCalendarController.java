package calendar.Controllers;

import calendar.Models.Event;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Calendar;

import static calendar.Controllers.Kidary.setEventName;
import static calendar.Controllers.Kidary.getData;
import static calendar.Controllers.Kidary.setLastClicked;

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
    public JFXButton weekBack;
    @FXML
    public JFXButton weekForward;
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
    @FXML
    public JFXTextField birthdayText;
    @FXML
    public Text weekInfo;

    private LocalDate date = LocalDate.now();
    private LocalDate monday = null;
    private int week;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setName();
        setBirthday();
        setBPane();

        Calendar cal = Calendar.getInstance();
        this.week = cal.get(Calendar.WEEK_OF_YEAR);
        weekInfo.setStyle("-fx-font-family: 'Accanthis ADF Std'");
        createWeekInfo();

        createCalendarHeader();
        setContent();


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
            Stage stage = new Stage();

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    // Refresh the parent window here
                    setContent();
                }
            });

            try {
                newEvent(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        weekBack.setOnAction(event -> {
            date = date.minusWeeks(1);
            this.week -= 1;
            createWeekInfo();
            createCalendarHeader();
        });

        weekForward.setOnAction(event -> {
            date = date.plusWeeks(1);
            this.week += 1;
            createWeekInfo();
            createCalendarHeader();
        });

        contacts.setOnAction(event -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/contacts.fxml"));
                Stage window = new Stage();
                window.setTitle("Kidary");
                window.setScene(new Scene(root, 650, 900));
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        messenger.setOnAction(event -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/messenger.fxml"));
                Stage window = new Stage();
                window.setTitle("Kidary");
                window.setScene(new Scene(root, 650, 950));
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setContent() {
        calendarGrid.getChildren().clear();
        setTimeStamps();

        for (var item : getData().a) {
            addEvent(calendarGrid, item);
        }


    }

    private void setTimeStamps() {
        for (int t = 0; t < 24; t++) {
            String text = String.valueOf(t) + ":00";
            Label label = new Label(text);
            label.setStyle("-fx-text-fill: black");
            calendarGrid.add(label, 0, t);
            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setValignment(label, VPos.TOP);
        }
    }

    private void setName() {
        // nastavi jmeno na Petr, pokud uzivatel kliknul na tlacitko Petr
        labelName.setText(labelName.getText() + Kidary.getMyVariable());
        labelName.setStyle("" +
                "-fx-font-family: 'Helvetica', Arial, sans-serif;" +
                " -fx-font-weight: bold; -fx-text-fill: white;" +
                " -fx-font-size: 24px;"
        );
        if (Kidary.getMyVariable().equals("Petr")) {
            birthdayText.setText("31.5, 8 let");
        }
    }

    private void setBirthday() {
        if (!Kidary.getMyVariable().equals("Petr")) {
            birthdayText.setText(Kidary.getBirthday());
        }
    }


    private void setBPane() {
        bodyPane.setHgap(3);
        bodyPane.setVgap(3);
        bodyPane.setPadding(new Insets(3, 3, 3, 3));
    }

    private void createCalendarHeader() {
        calendarHeader.getChildren().clear();

        monday = date;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }

        for (int j = 0; j < 7; j++) {

            Label dateLabel = new Label(monday.toString());
            dateLabel.setStyle("-fx-text-fill: BLACK; -fx-font-size: 20px; -fx-font-family: 'Accanthis ADF Std'");

            VBox day = new VBox();
            String whichDayInWeek = getDay(j);
            Label label = new Label(whichDayInWeek);
            label.setStyle("-fx-text-fill: BLACK;");
            label.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
            day.setPrefHeight(20);
            day.setMaxHeight(30);
            day.setStyle("-fx-background-color: #E1E2DC; -fx-min-height: 50px;");

            day.getChildren().add(dateLabel);
            day.getChildren().add(label);

            day.setAlignment(Pos.CENTER);
            calendarHeader.add(day, j + 1, 0);

            monday = monday.plusDays(1);
        }
    }

    private void createWeekInfo() {
        weekInfo.setText(Integer.toString(this.week) + ". týden");
    }


    private void addEvent(GridPane gridPane, Event e) {

        int day;
        int time;
        String subject;
        VBox calendarEvent = new VBox();
        //calendarEvent.setSpacing(8);
        //calendarEvent.setPadding(new Insets(5, 5, 5, 5));
        String style = String.format("-fx-background-color: %s; -fx-background-radius: 20px;", e.Color);
        calendarEvent.setStyle(style);
        Label label = new Label(e.Name);
        label.setStyle("-fx-text-fill: white;");
        calendarEvent.getChildren().add(label);
        calendarEvent.setAlignment(Pos.CENTER);
        calendarEvent.setOnMouseClicked(event -> {
            setEventName(e.Name);
            try {
                setLastClicked(e);
                Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/eventDetail.fxml"));
                Stage window = new Stage();
                window.setTitle("Kidary");
                window.setScene(new Scene(root, 450, 400));
                window.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        day = e.Date.getDayOfWeek().getValue();
        time = (int) (((e.To.getTime()) / (60 * 60 * 1000) % 24));
        int diff = (int) (((e.To.getTime() - e.From.getTime()) / (60 * 60 * 1000) % 24));

        gridPane.add(calendarEvent, day, time, 1, diff);
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
        Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/calendarDetail.fxml"));

        window.setScene(new Scene(root, 1300, 850));
        window.setTitle("Kidary");
        window.show();
    }

    private void newEvent(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/newEvent.fxml"));
        window.setScene(new Scene(root, 650, 850));
        window.setTitle("Kidary");
        window.show();
    }
}
