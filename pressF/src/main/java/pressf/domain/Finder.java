package pressf.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Finder {

    public Finder() {

    }

    public boolean etsi(String searchWord, String link) throws IOException {
        Scanner scanner = new Scanner(new File("links.txt"));
        while (scanner.hasNextLine()) {
            String realLink = scanner.nextLine();

            Document document = Jsoup.connect(realLink).timeout(0).get();
            for (Element element : document.getAllElements()) {
                if (element.nodeName().equals("p")) {
                    if (element.text().contains(searchWord)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean add(String link) {
        try {
            Document document = Jsoup.connect(link).timeout(0).get();
            File file = new File("links.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(link);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Link given in incorrect form/PrintWriter error: " + e.getMessage());
            return false;
        }
        return true;
    }
}
