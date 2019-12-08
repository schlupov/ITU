/**
 * @file Message
 * @author Michal Bucher, xbuche01
 */
package calendar.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Message implements Serializable {
    public LocalDate date;
    public boolean my;
    public String msg;
}
