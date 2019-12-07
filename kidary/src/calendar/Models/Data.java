package calendar.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data {
    public List<Event> a = new ArrayList<Event>();

    public Data(){
        Event e1 = new Event();

        e1.Id = 1;
        e1.Name = "Angličtina";
        e1.Calendar = 0;
        e1.Contacts = "342 234 423";
        e1.Date = LocalDate.now();
        e1.From = new Date(System.currentTimeMillis() - 3600 * 2000);
        e1.To = new Date(System.currentTimeMillis() - 3600 * 0);
        e1.Place = "Brno Božetěchova 1";
        e1.Note = "Nezapomenout penál!";
        e1.Type = "škola";

        e1.Color = "#DB2645";

        a.add(e1);

    }
}
