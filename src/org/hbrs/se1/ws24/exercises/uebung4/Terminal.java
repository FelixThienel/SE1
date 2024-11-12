package org.hbrs.se1.ws24.exercises.uebung4;

import org.hbrs.se1.ws24.exercises.uebung4.persistence.PersistenceException;

import java.util.Scanner;

public class Terminal {
    private static final String USER = "WeissNix GmbH > ";
    private static final String SYSTEM = "System > ";

    public static void main(String[] args) {
        System.out.println("Willkommen im User-Story-Manager der WeissNix GmbH");
        eingabe();
    }

    private static void eingabe() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print(USER);
            String[] eingabe = scanner.nextLine().split(" ");
            switch(eingabe[0]) {
                case "exit":
                    System.out.print(SYSTEM);
                    System.out.println("Der User-Story-Manager wird beendet.");
                    System.exit(0);
                    break;
                case "help":
                    System.out.print(SYSTEM);
                    System.out.println("Folgende Befehle stehen zur Verfügung: help, exit, enter, dump, store, load");
                    break;
                case "enter":
                    eingabe(eingabe);
                    break;
                case "dump":
                    for(UserStories us : Container.getInstance().getCurrentList()) {
                        System.out.print(SYSTEM);
                        System.out.println(us);
                    }
                    break;
                case "store":
                    try {
                        Container.getInstance().store();
                        System.out.print(SYSTEM);
                        System.out.println("User-Stories erfolgreich gespeichert.");
                    } catch(PersistenceException e) {
                        System.out.print(SYSTEM);
                        System.out.println(e.getMessage());
                    }
                    break;
                case "load":
                    try {
                        Container.getInstance().load();
                        System.out.print(SYSTEM);
                        System.out.println("User-Stories erfolgreich geladen.");
                    } catch(PersistenceException e) {
                        System.out.print(SYSTEM);
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.print(SYSTEM);
                    System.out.println("Fehlerhafte Eingabe! Bitte geben Sie einen gültigen Befehl ein.");
            }
        }
    }

    private static void eingabe(String[] eingabe) {
        if(eingabe.length != 9) {
            System.out.print(SYSTEM);
            System.out.println("Fehlerhafte Eingabe! Bitte geben Sie alle Attribute ein.");
            return;
        }
        try {
            int id = Integer.parseInt(eingabe[1]);
            int mehrwert = Integer.parseInt(eingabe[4]);
            int strafe = Integer.parseInt(eingabe[5]);
            int aufwand = Integer.parseInt(eingabe[6]);
            int risiko = Integer.parseInt(eingabe[7]);
            UserStories us = new UserStories(id, eingabe[2], eingabe[3], mehrwert, strafe, aufwand, risiko, eingabe[8]);
            Container.getInstance().addUserStories(us);
            System.out.print(SYSTEM);
            System.out.println("User-Story erfolgreich hinzugefügt.");
        } catch(NumberFormatException e) {
            System.out.print(SYSTEM);
            System.out.println("Fehlerhafte Eingabe! Bitte geben Sie nur Zahlen für die Attribute ein.");
        } catch(ContainerException e) {
            System.out.print(SYSTEM);
            System.out.println(e.getMessage());
        }
    }
}