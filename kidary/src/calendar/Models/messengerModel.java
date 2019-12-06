package calendar.Models;

import java.time.LocalDate;

public class messengerModel {
    public Message[]messages = new Message[4];

    public messengerModel(){
        Message m1 = new Message();

        m1.date = LocalDate.now().minusDays(-2);
        m1.my = false;
        m1.msg = "Bude v pátek družina?";

        Message m2 = new Message();

        m2.date = LocalDate.now().minusDays(-1);
        m2.my = true;
        m2.msg = "Ano bude mami";

        Message m3 = new Message();

        m3.date = LocalDate.now().minusDays(-1);
        m3.my = false;
        m3.msg = "Tak pa";

        Message m4 = new Message();

        m4.date = LocalDate.now().minusDays(-1);
        m4.my = false;
        m4.msg = "a pozdravuj zuzanku";

        messages[0] = m1;
        messages[1] = m2;
        messages[2] = m3;
        messages[3] = m4;
    }
}
