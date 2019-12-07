package calendar;

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
import javafx.scene.control.DatePicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import static calendar.Calendar.getData;

public class createNewEventController implements Initializable {
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
    public DatePicker from;
    @FXML
    public JFXTimePicker fromTime;
    @FXML
    public DatePicker to;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



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

                try {
                    Event e = new Event();
                    e.Id = getData().a.size()+1;
                    e.Name = name.getText();
                    e.Type = type.getText();
                    e.Contacts = contact.getText();
                    e.Date = date.getValue();
                    e.From = Date.from(from.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                    e.To = new Date(Date.from(to.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()+7200000);
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

    public static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    private void goBack(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("weekCalendar.fxml"));
        window.setScene(new Scene(root, 1300 ,850));
        window.setTitle("Kidary");
        window.show();
    }

}
