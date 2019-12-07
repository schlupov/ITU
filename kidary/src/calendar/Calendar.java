package calendar;

import calendar.Models.Data;
import calendar.Models.Event;
import calendar.Models.contactModel;
import calendar.Models.messengerModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calendar extends Application {

    private static String name;
    private static String eventName;

    private static Data data;
    private static contactModel cm;
    private static Event lastClicked;



    @Override
    public void start(Stage primaryStage) throws Exception {
        data = new Data();
        cm = new contactModel();
        new messengerModel().setData();

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

    public static Data getData() {
        return data;
    }

    public static void setData(Data data) {
        Calendar.data = data;
    }

    public static Event getLastClicked() {
        return lastClicked;
    }

    public static void setLastClicked(Event lastClicked) {
        Calendar.lastClicked = lastClicked;
    }
    public static contactModel getCm() {
        return cm;
    }

    public static void setCm(contactModel cm) {
        Calendar.cm = cm;
    }

}
