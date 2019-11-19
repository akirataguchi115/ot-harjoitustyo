package pressf.domain;

import java.util.ArrayList;

public class Finder {

    public Finder() {

    }

    public String etsi(ArrayList<String> lista, String etsittava) {
        for (String sivut : lista) {
            if (sivut.contains(etsittava)) {
                return etsittava;
            }
        }
        return null;
    }
}
