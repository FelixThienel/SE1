package org.hbrs.se1.ws24.exercises.uebung9.aufgabe1.aufgabe2;

import java.util.ArrayList;

public class ComplexDocument implements Document {
    private int id;
    private ArrayList<Document> documents = new ArrayList<Document>();

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void deleteDocument(Document document) {
        documents.remove(document);
    }

    public int getSize() {
        int size = 0;
        for (Document document : documents) {
            size += document.getSize();
        }
        return size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
