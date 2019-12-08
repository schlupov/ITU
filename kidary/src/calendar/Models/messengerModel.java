/**
 * @file messengerModel
 * @author Michal Bucher, xbuche01
 */
package calendar.Models;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class messengerModel {
    public List<Message> messages = new ArrayList<>();

    public messengerModel() {

    }

    public void setData() {
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

        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
        messages.add(m4);

        saveMsgs();
    }

    public void loadMsgs() {
        messages.clear();

        try {
            String fileName = "Test.txt";
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);

            Message msg;
            while (true) {
                msg = (Message) ois.readObject();
                messages.add(msg);
            }
        } catch (EOFException eofx) {
            //
        } catch (Exception e) {
            //
        }
    }

    public void saveMsgs() {
        try
        {
            String fileName = "Test.txt";
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.close();
        }
        catch(Exception e)
        {
            //
        }

        try {
            String fileName = "Test.txt";
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < messages.size(); i++) {
                oos.writeObject(messages.get(i));
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
