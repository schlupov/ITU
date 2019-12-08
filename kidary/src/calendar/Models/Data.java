/**
 * @file Data
 * @author Michal Bucher, xbuche01
 */
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
        Event e3 = new Event();
        Event e4 = new Event();
        Event e5 = new Event();
        Event e6 = new Event();
        Event e7 = new Event();

        e1.Id = 1;
        e1.Name = "Kostel";
        e1.Calendar = 0;
        e1.Contacts = "342 234 423";
        e1.Date = LocalDate.now();
        e1.From = new Date(System.currentTimeMillis() - 3600 * 2000);
        e1.To = new Date(System.currentTimeMillis());
        e1.Place = "Kostel Svaté Trojice";
        e1.Note = "Bibličku vzít sebou";
        e1.Type = "náboženství";

        e1.Color = "#DB2645";

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            from = formatter.parse("09:00");
            to = formatter.parse("10:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        e2.Id = 2;
        e2.Name = "Angličtina";
        e2.Calendar = 0;
        e2.Contacts = "342 234 423";
        e2.Date = LocalDate.now();
        e2.From = from;
        e2.To = to;
        e2.Place = "Brno Božetěchova 1";
        e2.Note = "Nezapomenout penál!";
        e2.Type = "škola";

        e2.Color = "#ABCD45";

        formatter = new SimpleDateFormat("HH:mm");
        try {
            from = formatter.parse("10:00");
            to = formatter.parse("11:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        e3.Id = 3;
        e3.Name = "Čeština";
        e3.Calendar = 0;
        e3.Contacts = "777 239 999";
        e3.Date = LocalDate.now();
        e3.From = from;
        e3.To = to;
        e3.Place = "Brno Božetěchova 1";
        e3.Note = "";
        e3.Type = "škola";

        e3.Color = "#CC1523";

        formatter = new SimpleDateFormat("HH:mm");
        try {
            from = formatter.parse("11:00");
            to = formatter.parse("12:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        e6.Id = 6;
        e6.Name = "Matematika";
        e6.Calendar = 0;
        e6.Contacts = "777 239 999";
        e6.Date = LocalDate.now();
        e6.From = from;
        e6.To = to;
        e6.Place = "Brno Božetěchova 1";
        e6.Note = "KRUŽÍTKO";
        e6.Type = "škola";

        e6.Color = "#CC1523";


        formatter = new SimpleDateFormat("HH:mm");
        try {
            from = formatter.parse("12:00");
            to = formatter.parse("13:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        e4.Id = 4;
        e4.Name = "Oběd";
        e4.Calendar = 0;
        e4.Contacts = "342 234 423";
        e4.Date = LocalDate.now();
        e4.From = from;
        e4.To = to;
        e4.Place = "Brno Božetěchova 1";
        e4.Note = "Vyřídit kartičku";
        e4.Type = "škola";

        e4.Color = "#AE2645";

        formatter = new SimpleDateFormat("HH:mm");
        try {
            from = formatter.parse("13:00");
            to = formatter.parse("14:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        e5.Id = 5;
        e5.Name = "Výtvarka";
        e5.Calendar = 0;
        e5.Contacts = "555 888 444";
        e5.Date = LocalDate.now();
        e5.From = from;
        e5.To = to;
        e5.Place = "Brno Božetěchova 1";
        e5.Note = "Vzít knoflíky";
        e5.Type = "škola";

        e5.Color = "#002645";

        formatter = new SimpleDateFormat("HH:mm");
        try {
            from = formatter.parse("13:00");
            to = formatter.parse("14:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        e7.Id = 7;
        e7.Name = "Fotbal";
        e7.Calendar = 0;
        e7.Contacts = "111 111 111";
        e7.From = from;
        e7.To = to;
        e7.Date = LocalDate.of(2019, 12, 18);
        e7.Place = "Brno Božetěchova 10";
        e7.Note = "";
        e7.Type = "družina";

        e7.Color = "#FEDCBA";

        a.add(e1);
        a.add(e2);
        a.add(e3);
        a.add(e4);
        a.add(e5);
        a.add(e6);
        a.add(e7);

    }
}
