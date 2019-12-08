/**
 * @file Credentials
 * @author Silvie Chlupová, xchlup08
 */
package calendar.Models;

import java.util.HashMap;
import java.util.Map;

public class Credentials {
    Map<String, String> credentials;

    public Credentials() {
        this.credentials = new HashMap<>();

        this.credentials.put("admin", "admin");
        this.credentials.put("Petr", "heslo123");
        this.credentials.put("Alena", "alena");
    }

    public Map<String, String> getCredentials() {
        return this.credentials;
    }
}
