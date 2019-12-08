package calendar.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static calendar.Controllers.Kidary.getLastClicked;


public class eventDetailController implements Initializable {
    @FXML
    public Label nameOfEvent;
    @FXML
    public HBox topHboxEventDetail;

    @FXML
    public Label type;
    @FXML
    public Label contact;
    @FXML
    public Label date;
    @FXML
    public Label from;
    @FXML
    public Label to;
    @FXML
    public Label place;
    @FXML
    public Label note;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        nameOfEvent.setText(nameOfEvent.getText() + getLastClicked().Name);
        type.setText(getLastClicked().Type);
        date.setText(getLastClicked().Date.toString());
        from.setText(dateFormat.format(getLastClicked().From));
        to.setText(dateFormat.format(getLastClicked().To));
        place.setText(getLastClicked().Place);
        note.setText(getLastClicked().Note);
    }
}
