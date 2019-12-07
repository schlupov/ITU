package calendar;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    public Pane loginCentralPane;
    @FXML
    public JFXTextField username;
    @FXML
    public ImageView kidaryLogo;
    @FXML
    public Label errorLabel;

    @FXML
    public JFXButton loginButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String password = "";
                for (Node node: loginCentralPane.getChildren()) {
                    if (node instanceof JFXPasswordField) {
                        password = ((JFXPasswordField) node).getText();
                    }
                }
                if (username.getText().isEmpty() || password.equals("")) {
                    errorLabel.setStyle("-fx-text-fill: red");
                    errorLabel.setText("Špatné přihlašovací údaje!");
                }
                else if (!username.getText().equals("admin") || !password.equals("admin")) {
                    errorLabel.setStyle("-fx-text-fill: red");
                    errorLabel.setText("Špatné přihlašovací údaje!");
                }
                else {
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    try {
                        login(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void login(Stage window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("calendarDetail.fxml"));
        window.setScene(new Scene(root, 1300 ,850));
        window.setTitle("Kidary");
        window.show();
    }
}
