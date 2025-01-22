package entites;

import java.util.ArrayList;

public class Utils {

    public String convertToString(int d) {
        return String.format("%.2f", d);
    }

    public boolean arrayListIsEmpty(ArrayList<?> a) {
        return a == null || a.isEmpty();
    }

    public byte checkInstance(Object o) {
        if (o == null) {
            return -1;
        }
        if (o instanceof Pessoa) {
            return 1;
        } else if (o instanceof Cliente) {
            return 2;
        } else if (o instanceof Atendente) {
            return 3;
        } else if (o instanceof Tecnico) {
            return 4;
        } else {
            return -1;
        }

    }

}
