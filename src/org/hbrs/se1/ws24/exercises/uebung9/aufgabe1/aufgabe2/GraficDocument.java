package org.hbrs.se1.ws24.exercises.uebung9.aufgabe1.aufgabe2;

public class GraficDocument extends CoreDocument {
    private String url;

    public GraficDocument(String url) {
        this.url = url;
    }

    @Override
    public int getSize() {
        return 1200;
    }
}