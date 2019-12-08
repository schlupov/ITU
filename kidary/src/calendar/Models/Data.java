package calendar.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data {
    public List<Event> a = new ArrayList<Event>();

    Date from = null;
    Date to = null;

    public Data(){
        Event e1 = new Event();
        Event e2 = new Event();

        e1.Id = 1;
        e1.Name = "Angličtina";
        e1.Calendar = 0;
        e1.Contacts = "342 234 423";
        e1.Date = LocalDate.now();
        e1.From = new Date(System.currentTimeMillis() - 3600 * 2000);
        e1.To = new Date(System.currentTimeMillis());
        e1.Place = "Brno Božetěchova 1";
        e1.Note = "Nezapomenout penál!";
        e1.Type = "škola";

        e1.Color = "#DB2645";

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            from = formatter.parse("09:00");
            to = formatter.parse("10:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        e2.Id = 1;
        e2.Name = "Angličtina";
        e2.Calendar = 0;
        e2.Contacts = "342 234 423";
        e2.Date = LocalDate.now();
        e2.From = from;
        e2.To = to;
        e2.Place = "Brno Božetěchova 1";
        e2.Note = "Nezapomenout penál!";
        e2.Type = "škola";

        e2.Color = "#DB2645";

        a.add(e1);
        a.add(e2);

    }
}
