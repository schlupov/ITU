package calendar;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    @FXML
    public Pane loginCentralPane;
    @FXML
    public JFXTextField username;
    public JFXTextField password;
    @FXML
    public ImageView kidaryLogo;

    @FXML
    public JFXButton loginButton;


    public void initialize() throws IOException {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) loginButton.getScene().getWindow();
                try {
                    login(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void login(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("calendarDetail.fxml"));
        window.setScene(new Scene(root, 1100 ,700));
        window.setTitle("Kidary");
        window.show();
    }
}
