package org.hbrs.se1.ws24.exercises.uebung4;

import java.io.Serializable;

public class UserStories implements Serializable {
    private int id;
    private String titel;
    private String akzeptanzkriterien;
    private int mehrwert;
    private int strafe;
    private int aufwand;
    private int risiko;
    private double prio;
    private String projekt;

    public UserStories(int id, String titel, String akzeptanzkriterien, int mehrwert, int strafe, int aufwand, int risiko, String projekt) {
        this.id = id;
        this.titel = titel;
        this.akzeptanzkriterien = akzeptanzkriterien;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.aufwand = aufwand;
        this.risiko = risiko;
        this.prio = (double) (mehrwert + strafe) / (aufwand + risiko);
        this.projekt = projekt;
    }

    public int getID() {
        return id;
    }

    public double getPrio() {
        return prio;
    }

    public String toString() {
        return "ID: " + id + ", Titel: " + titel + ", Akzeptanzkriterien: " + akzeptanzkriterien + ", Mehrwert: " + mehrwert + ", Strafe: " + strafe + ", Aufwand: " + aufwand + ", Risiko: " + risiko + ", Prio: " + prio + ", Projekt: " + projekt;
    }
}