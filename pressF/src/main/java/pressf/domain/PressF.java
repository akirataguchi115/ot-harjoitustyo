package pressf.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class PressF {

    public static void main(String[] args) {
        Finder finder = new Finder();
        Scanner lukija = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Tietokannan normalisointi tehdään olemassaolevalle tietokannalle. Tietokannan normalisoinnissa etsimme tietokantatauluista tunnettuja epäkohtia, jonka jälkeen näitä epäkohtia korjataan.");
        lista.add("Tunnettujen epäkohtien tunnistaminen tapahtuu askeleittain valmiita \"säännöstöjä\" eli normaalimuotoja seuraamalla.");
        lista.add("Ensimmäisessä normaalimuodossa otetaan ensiaskeleet tietokannan rakenteen lineaarisoitumiseen");
        while (true) {
            System.out.print("Etsi:");
            String syote = lukija.nextLine();
            if (syote.equals("lopeta")) {
                break;
            }
            if (finder.etsi(lista, syote) == syote) {
                System.out.println(syote + " löytyi!");
            }
        }
    }
}
