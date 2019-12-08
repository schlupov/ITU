/**
 * @file createNewCalendarController
 * @author Silvie Chlupová, xchlup08
 */
package calendar.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

public class createNewCalendarController implements Initializable {

    @FXML
    public Pane newCalendarPane;
    @FXML
    public JFXButton createButton;
    @FXML
    public JFXButton drop;
    @FXML
    public JFXTextField nameTextField;
    @FXML
    public DatePicker datePicker;
    @FXML
    public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Kidary.setNewCalendar(nameTextField.getText());
                if (nameTextField.getText().isEmpty()) {
                    errorLabel.setStyle("-fx-text-fill: red");
                    errorLabel.setText("Jméno je nutné vyplnit!");
                }
                if (datePicker.getValue() != null) {
                    LocalDate birthDate = datePicker.getValue();
                    int age = calculateAge(birthDate, LocalDate.now());
                    String day = Integer.toString(birthDate.getDayOfMonth());
                    String month = Integer.toString(birthDate.getMonthValue());
                    if (age+1 == 1) {
                        Kidary.setBirthday(day + "." + month + ", " + Integer.toString(age+1) + " rok");
                    }
                    else if (age+1 > 0 && age+1 <= 4) {
                        Kidary.setBirthday(day + "." + month + ", " + Integer.toString(age+1) + " roky");
                    } else {
                        Kidary.setBirthday(day + "." + month + ", " + Integer.toString(age+1) + " let");
                    }
                }
                if (!nameTextField.getText().isEmpty()) {
                    Stage previousStage = Kidary.getPreviousStage();
                    previousStage.close();
                    Stage stage = (Stage) createButton.getScene().getWindow();
                    try {
                        goBack(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        drop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) drop.getScene().getWindow();
                stage.close();
            }
        });
    }

    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    private void goBack(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/calendarDetail.fxml"));
        window.setScene(new Scene(root, 1300, 850));
        window.setTitle("Kidary");
        window.show();
    }
}
