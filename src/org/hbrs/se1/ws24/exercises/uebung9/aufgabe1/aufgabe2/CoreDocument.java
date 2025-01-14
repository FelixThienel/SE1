package org.hbrs.se1.ws24.exercises.uebung9.aufgabe1.aufgabe2;

public abstract class CoreDocument implements Document {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract int getSize();
}