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

    /**
     * Empty constructor for the Finder -class.
     */
    public Finder() {

    }

    /**
     * Finds the word passed in the parameter from a given link.
     *
     * @param searchWord the word user wants to search FOR
     * @param link the link from where the user wants to search FROM
     * @return returns true if the searched word was found succesfully, else
     * returns false
     * @throws IOException because Java
     */
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

    /**
     * Adds a link passed in the parameter to links.txt via Jsoup verification.
     *
     * @param link the link to be added
     * @return true if the append was succesful; false if not
     */
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
