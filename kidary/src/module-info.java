module kidary {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.controlsfx.controls;
    requires charm.glisten;
    requires com.jfoenix;

    opens calendar.Controllers;
    opens calendar.Views;
    opens calendar.Models;
}