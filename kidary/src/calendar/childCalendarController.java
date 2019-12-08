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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static calendar.Kidary.setEventName;

public class childCalendarController implements Initializable {
    @FXML
    public GridPane childCalendarGrid;

    @FXML
    public HBox hboxNewEventTop;

    @FXML
    public JFXButton messenger;

    @FXML
    public JFXButton left;
    @FXML
    public JFXButton right;

    private LocalDate date = LocalDate.now();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkDate();

        left.setOnAction(event->{
            date = date.minusDays(1);

            checkDate();
        });

        right.setOnAction(event->{
            date = date.plusDays(1);

            checkDate();
        });

        messenger.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) messenger.getScene().getWindow();
                try {
                    gotoMessenger(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private  void checkDate(){
        //if (!childCalendarGrid.getChildren().isEmpty())
            childCalendarGrid.getChildren().clear();

        if (date.equals(LocalDate.now()))
        {
            addEvent(2, "Angličtina");
            addEvent( 8, "Matematika");
        } else {
            addEvent(5, "Tělocvik");
            addEvent( 7, "Čeština");
        }
    }

    private void addEvent( int time, String subject) {
        VBox calendarEvent = new VBox();
        calendarEvent.setSpacing(5);
        calendarEvent.setPadding(new Insets(5, 5, 5, 5));
        switch (subject) {
            case "Angličtina":
                calendarEvent.setStyle("-fx-background-color: #DB2645; -fx-background-radius: 20px;");
                break;
            case "Matematika":
                calendarEvent.setStyle("-fx-background-color: #4CBB17; -fx-background-radius: 20px;");
                break;
            case "Tělocvik":
                calendarEvent.setStyle("-fx-background-color: #35d4db; -fx-background-radius: 20px;");
                break;
            case "Čeština":
                calendarEvent.setStyle("-fx-background-color: #bba53c; -fx-background-radius: 20px;");
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
                window.setScene(new Scene(root, 450, 400));
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        childCalendarGrid.add(calendarEvent, 0, time,1,2);
    }

    private void gotoMessenger(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("childMessenger.fxml"));
        window.setScene(new Scene(root, 400, 700));
        window.setTitle("Kidary");
        window.show();
    }
}
