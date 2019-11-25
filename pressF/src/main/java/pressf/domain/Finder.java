package pressf.domain;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Finder {

    public Finder() {

    }

    public boolean etsi(String searchWord, String link) throws IOException {
        Document document = Jsoup.connect(link).timeout(0).get();
        for (Element element : document.getAllElements()) {
            if (element.nodeName().equals("p")) {
                if (element.text().contains(searchWord)) {
                    return true;
                }
            }
        }
        return false;
    }
}
