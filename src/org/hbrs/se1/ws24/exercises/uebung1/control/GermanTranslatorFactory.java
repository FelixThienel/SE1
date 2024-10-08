package org.hbrs.se1.ws24.exercises.uebung1.control;

public class GermanTranslatorFactory {
    public static GermanTranslator createGermanTranslator() {
        GermanTranslator translator = new GermanTranslator();
        translator.setDate("Okt/2024");
        return translator;
    }
}