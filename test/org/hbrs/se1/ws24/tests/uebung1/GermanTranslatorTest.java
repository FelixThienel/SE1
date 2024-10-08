package org.hbrs.se1.ws24.tests.uebung1;
import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GermanTranslatorTest {

    GermanTranslator translator;

    @BeforeEach
    public void setUp() {
        translator = new GermanTranslator();
    }

    @Test
    public void test1() {
        assertEquals("eins", translator.translateNumber(1));
    }

    @Test
    public void test2() {
        assertEquals("zwei", translator.translateNumber(2));
    }

    @Test
    public void test3() {
        assertEquals("drei", translator.translateNumber(3));
    }

    @Test
    public void test4() {
        assertEquals("vier", translator.translateNumber(4));
    }

    @Test
    public void test5() {
        assertEquals("fünf", translator.translateNumber(5));
    }

    @Test
    public void test6() {
        assertEquals("sechs", translator.translateNumber(6));
    }

    @Test
    public void test7() {
        assertEquals("sieben", translator.translateNumber(7));
    }

    @Test
    public void test8() {
        assertEquals("acht", translator.translateNumber(8));
    }

    @Test
    public void test9() {
        assertEquals("neun", translator.translateNumber(9));
    }

    @Test
    public void test10() {
        assertEquals("zehn", translator.translateNumber(10));
    }
    
    @Test
    public void testUngueltig() {
        assertEquals("Übersetzung der Zahl 0 nicht möglich (Version 1.0)", translator.translateNumber(0));
        assertEquals("Übersetzung der Zahl 11 nicht möglich (Version 1.0)", translator.translateNumber(11));
    }
}