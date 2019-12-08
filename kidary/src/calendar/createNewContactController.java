package calendar;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

import static calendar.Kidary.getCm;


public class createNewContactController implements Initializable {

    @FXML
    public Pane newCalendarPane;
    public JFXButton createButton;
    public JFXButton drop;

    public JFXTextField name;
    public JFXTextField name1;
    public JFXTextField phone;
    public JFXTextField email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        drop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) drop.getScene().getWindow();
                try {
                    //goBack(stage);
                    stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    String[] b = {name.getText(), name1.getText(), phone.getText(), email.getText()};
                    getCm().a.add(b);
                } catch (Exception ex) {
                    //
                }

                Stage stage = (Stage) createButton.getScene().getWindow();
                try {
                    stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
