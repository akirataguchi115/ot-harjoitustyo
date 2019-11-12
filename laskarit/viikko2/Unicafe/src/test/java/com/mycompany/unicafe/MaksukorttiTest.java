package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinsaldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void lataaminenOnnistuu() {
        kortti.lataaRahaa(10);
        kortti.lataaRahaa(20);
        assertEquals(40, kortti.saldo());
    }
    
    @Test
    public void ottaminenToimii1() {
        kortti.otaRahaa(10);
        assertEquals(0, kortti.saldo());
    }
    
    @Test
    public void ottaminenToimii2() {
        kortti.otaRahaa(11);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void ottaminenToimii3() {
        boolean toimii = true;
        if (kortti.otaRahaa(10) == false) {
            toimii = false;
        }
        if (kortti.otaRahaa(10) == true) {
            toimii = false;
        }
        assertTrue(toimii);
    }
}
