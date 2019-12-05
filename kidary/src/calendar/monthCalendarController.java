package calendar;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class monthCalendarController {

    @FXML
    public GridPane bodyPane;
    @FXML
    public GridPane headerPane;


    public void initialize() throws IOException {
        bodyPane.setHgap(5); //horizontal gap in pixels
        bodyPane.setVgap(5); //vertical gap in pixels
        bodyPane.setPadding(new Insets(5, 5, 5, 5));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <7; j++) {
                if (i == 0) {
                    VBox day = new VBox();
                    Label label = new Label("Pondělí");
                    day.setStyle("-fx-background-color: #6C7B8B; -fx-background-radius: 20px");
                    day.setPrefHeight(30);
                    day.setMaxHeight(70);
                    day.getChildren().add(label);
                    bodyPane.add(day, j,i);
                    day.setAlignment(Pos.CENTER);
                }
                else {
                    Pane day = new Pane();
                    day.setStyle("-fx-background-color: #E6E8FA;");
                    day.setPrefHeight(140);
                    day.setMaxHeight(180);
                    bodyPane.add(day, j,i);
                }
            }
        }
    }

}
