package calendar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class eventDetailController implements Initializable {
    @FXML
    public Label nameOfEvent;
    @FXML
    public HBox topHboxEventDetail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameOfEvent.setText(nameOfEvent.getText() + Calendar.getEventName());
    }
}
