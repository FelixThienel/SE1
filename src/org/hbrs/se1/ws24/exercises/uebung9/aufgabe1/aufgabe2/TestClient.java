package org.hbrs.se1.ws24.exercises.uebung9.aufgabe1.aufgabe2;

public class TestClient {
    public static void main(String[] args) {
        ComplexDocument doc0 = new ComplexDocument();
        doc0.setId(0);
        Document doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt!", Encoding.UTF8);
        doc2.setId(2);
        ComplexDocument doc3 = new ComplexDocument();
        doc3.setId(3);
        Document doc4 = new GraficDocument("localhost:8080");
        doc4.setId(4);
        Document doc5 = new TextDocument("Software Engineering I ist eine Vorlesung in den Studiengaengen BIS und BCS", Encoding.UTF32);
        doc5.setId(5);

        doc3.addDocument(doc5);
        doc3.addDocument(doc4);
        doc0.addDocument(doc2);
        doc0.addDocument(doc3);

        System.out.println("Dokument 5 ist " + doc5.getSize() + " Bytes groß.");
        System.out.println("Dokument 4 ist " + doc4.getSize() + " Bytes groß.");
        System.out.println("Dokument 3 ist " + doc3.getSize() + " Bytes groß.");
        System.out.println("Dokument 2 ist " + doc2.getSize() + " Bytes groß.");
        System.out.println("Dokument 0 ist " + doc0.getSize() + " Bytes groß.");
    }
}