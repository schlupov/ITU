package calendar.Controllers;

import calendar.Models.Event;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import static calendar.Controllers.Kidary.getData;

public class createNewEventController implements Initializable {
    Date from = null;
    Date to = null;

    @FXML
    public JFXButton buttonBack;
    @FXML
    public JFXTextField name;
    @FXML
    public JFXTextField type;
    @FXML
    public JFXTextField contact;
    @FXML
    public DatePicker date;
    @FXML
    public JFXTimePicker fromTime;
    @FXML
    public JFXTimePicker toTime;
    @FXML
    public JFXTextField place;
    @FXML
    public JFXTextArea note;
    @FXML
    public JFXButton buttonCreate;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public ComboBox<Label> To;
    @FXML
    public ComboBox<Label> From;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addTimes();

        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) buttonBack.getScene().getWindow();
                try {
                   //goBack(stage);
                   stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonCreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (From.getValue() != null && To.getValue() != null) {
                    String selectedFrom = From.getValue().getText();
                    String selectedTo = To.getValue().getText();
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                    try {
                        from = formatter.parse(selectedFrom);
                        to = formatter.parse(selectedTo);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Event e = new Event();
                    e.Id = getData().a.size()+1;
                    e.Name = name.getText();
                    e.Type = type.getText();
                    e.Contacts = contact.getText();
                    e.Date = date.getValue();
                    e.From = from;
                    e.To = to;
                    e.Place = place.getText();
                    e.Note = note.getText();
                    e.Color = toRGBCode(colorPicker.getValue());

                    getData().a.add(e);
                } catch (Exception ex) {
                    //
                }

                Stage stage = (Stage) buttonBack.getScene().getWindow();
                try {
                    stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addTimes() {
        for (int i = 0; i <= 9; i++) {
            String time = "0" + Integer.toString(i) + ":" + "00";
            Label label = new Label(time);
            label.setStyle("-fx-text-fill: black");
            From.getItems().add(label);
        }
        for (int i = 10; i < 24; i++) {
            String time = Integer.toString(i) + ":" + "00";
            Label label = new Label(time);
            label.setStyle("-fx-text-fill: black");
            From.getItems().add(label);
        }
        for (int i = 0; i <= 9; i++) {
            String time = "0" + Integer.toString(i) + ":" + "00";
            Label label = new Label(time);
            label.setStyle("-fx-text-fill: black");
            To.getItems().add(label);
        }
        for (int i = 10; i < 24; i++) {
            String time = Integer.toString(i) + ":" + "00";
            Label label = new Label(time);
            label.setStyle("-fx-text-fill: black");
            To.getItems().add(label);
        }
    }

    public static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    private void goBack(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/weekCalendar.fxml"));
        window.setScene(new Scene(root, 1300 ,850));
        window.setTitle("Kidary");
        window.show();
    }

}
