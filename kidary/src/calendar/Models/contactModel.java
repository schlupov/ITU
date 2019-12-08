/**
 * @file contactModel
 * @author Michal Bucher, xbuche01
 */
package calendar.Models;

import java.util.ArrayList;
import java.util.List;

public class contactModel {
    public List<String[]> a = new ArrayList<>();

    public contactModel() {
        String[] b1 = {"Třídní", "Růžová", "777 888 999", "ruzova.lucie@atlas.cz"};
        String[] b2 = {"Babička", "Romana", "727 843 999", ""};
        String[] b3 = {"Děda", "Eda", "177 868 999", ""};
        String[] b4 = {"Mamka", "", "277 858 999", "mamus@atlas.cz"};
        String[] b5 = {"Zuzka", "", "377 888 999", ""};

        a.add(b1);
        a.add(b2);
        a.add(b3);
        a.add(b4);
        a.add(b5);
    }
}
