package calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calendar extends Application {

    private static String name;
    private static String eventName;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));
        primaryStage.setTitle("Kidary");
        primaryStage.setScene(new Scene(root, 1300, 850));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static String getMyVariable() {
        return name;
    }

    public static String getEventName() {
        return eventName;
    }

    public static void setEventName(String eventName) {
        Calendar.eventName = eventName;
    }

    public static void setMyVariable(String myVariable) {
        Calendar.name = myVariable;
    }
}
