/**
 * @file Kidary
 * @author Silvie Chlupová, xchlup08
 */
package calendar.Controllers;

import calendar.Models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Kidary extends Application {

    private static String name;
    private static String eventName;

    private static Data data;
    private static contactModel cm;
    private static Event lastClicked;
    private static String newCalendar;
    private static String birthday;
    private static Stage previousStage;
    private static User loggedUser;

    @Override
    public void start(Stage primaryStage) throws Exception {
        data = new Data();
        cm = new contactModel();
        new messengerModel().setData();

        Parent root = FXMLLoader.load(getClass().getResource("/calendar/Views/calendar.fxml"));
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
    public static void setMyVariable(String myVariable) { Kidary.name = myVariable; }

    public static String getEventName() {
        return eventName;
    }
    public static void setEventName(String eventName) { Kidary.eventName = eventName; }

    public static Data getData() {
        return data;
    }
    public static void setData(Data data) {
        Kidary.data = data;
    }

    public static Event getLastClicked() {
        return lastClicked;
    }

    public static void setLastClicked(Event lastClicked) {
        Kidary.lastClicked = lastClicked;
    }
    public static contactModel getCm() {
        return cm;
    }

    public static void setCm(contactModel cm) {
        Kidary.cm = cm;
    }

    public static String getNewCalendar() {
        return newCalendar;
    }
    public static void setNewCalendar(String newCalendar) { Kidary.newCalendar = newCalendar;}

    public static String getBirthday() {
        return birthday;
    }
    public static void setBirthday(String birthday) { Kidary.birthday = birthday;}

    public static Stage getPreviousStage() {
        return previousStage;
    }
    public static void setPreviousStage(Stage previousStage) { Kidary.previousStage = previousStage;}

    public static User getLoggedUser() {
        return loggedUser;
    }
    public static void setLoggedUser(User loggedUser) { Kidary.loggedUser = loggedUser;}
}
