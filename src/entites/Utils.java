package entites;

import java.util.ArrayList;

public class Utils {

    public String convertToString(int d) {
        return String.format("%.2f", d);
    }

    public boolean arrayListIsEmpty(ArrayList<?> a) {
        return a == null || a.isEmpty();
    }
}
