package org.hbrs.se1.ws24.exercises.uebung3;

public class ContainerException extends Exception{
    public ContainerException(String message) {
        super(message);
    }

    public ContainerException() {
        super("Das Member-Objekt ist bereits vorhanden!");
    }
}
