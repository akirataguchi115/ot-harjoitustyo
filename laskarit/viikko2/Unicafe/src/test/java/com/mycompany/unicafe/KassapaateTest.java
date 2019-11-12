package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate paate;

    @Before
    public void setUp() {
        paate = new Kassapaate();
    }

    @Test
    public void alkuArvotOikein() {
        boolean toimii = true;
        if (paate.kassassaRahaa() != 100000) {
            toimii = false;
        }
        if (paate.edullisiaLounaitaMyyty() + paate.maukkaitaLounaitaMyyty() != 0) {
            toimii = false;
        }
        assertTrue(toimii);
    }

    @Test
    public void käteisostoToimii() {
        boolean toimii = true;
        if (paate.syoMaukkaasti(410) == 10) {
            if (paate.maukkaitaLounaitaMyyty() != 1) {
                toimii = false;
            }
        } else {
            toimii = false;
        }
        paate.syoEdullisesti(240);
        if (paate.edullisiaLounaitaMyyty() != 1) {
            toimii = false;
        }

        if (paate.syoEdullisesti(233) != 233) {
            toimii = false;
        }
        if (paate.syoMaukkaasti(399) != 399) {
            toimii = false;
        }
        assertTrue(toimii);
    }

    @Test
    public void korttiostoToimii() {
        boolean toimii = true;
        Maksukortti kortti = new Maksukortti(640);
        if (paate.syoMaukkaasti(kortti) != true) {
            toimii = false;
        }
        if (paate.syoMaukkaasti(kortti) == true) {
            toimii = false;
        }
        if (paate.syoEdullisesti(kortti) != true) {
            toimii = false;
        }
        if (paate.syoEdullisesti(kortti) == true) {
            toimii = false;
        }
        if (kortti.saldo() != 0) {
            toimii = false;
        }
        if (paate.maukkaitaLounaitaMyyty() != 1) {
            toimii = false;
        }
        if (paate.edullisiaLounaitaMyyty() != 1) {
            toimii = false;
        }
        if (paate.kassassaRahaa() != 100000) {
            toimii = false;
        }
        assertTrue(toimii);
    }

    @Test
    public void kortinlatausToimii() {
        boolean toimii = true;
        Maksukortti kortti = new Maksukortti(0);
        paate.lataaRahaaKortille(kortti, 10);
        if (kortti.saldo() != 10 || paate.kassassaRahaa() != 100010) {
            toimii = false;
        }
        paate.lataaRahaaKortille(kortti, -1);
        if (paate.kassassaRahaa() != 100010 || kortti.saldo() != 10) {
            toimii = false;
        }
        assertTrue(toimii);
    }
}
