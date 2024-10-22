package org.hbrs.se1.ws24.exercises.uebung3;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Container {
    // Singleton-Pattern
    private static Container instance;
    // aktuelle Strategie zur Speicherung der Member-Objekte
    private PersistenceStrategy<Member> ps;
    List<Member> members;

    private Container() {
        members = new ArrayList<Member>();
    }

    /**
     * Statische Methode, um die einzige Instanz der Klasse Container zu erhalten
     * @return Die einzige Instanz der Klasse Container
     */
    public static Container getInstance() {
        if(instance == null)
            instance = new Container();
        return instance;
    }

    public void addMember(Member member) throws ContainerException {
        for(Member aMember : members)
            if(aMember.getID() == member.getID())
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
        members.add(member);
    }

    public String deleteMember(int id) {
        for(Member aMember : members)
            if(aMember.getID() == id) {
                members.remove(aMember);
                return "Das Member-Objekt mit der ID " + id + " wurde erfolgreich gelöscht!";
            }
        return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!";
    }

    public int size() {
        return members.size();
    }

    /**
     * Methode zum Speichern der Member-Objekte in einer Datei
     */
    public void store() throws PersistenceException {
        if(ps == null)
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Es wurde keine Strategie zum Speichern der Member-Objekte festgelegt!");
        try {
            ps.save(members);
        } catch (UnsupportedOperationException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Es konnte keine Verbindung zur Datenbank hergestellt werden!");
        }
    }

    /**
     * Methode zum Laden der Member-Objekte aus einer Datei
     */
    public void load() throws PersistenceException {
        if(ps == null)
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Es wurde keine Strategie zum Laden der Member-Objekte festgelegt!");
        try {
            List<Member> loadedMembers = ps.load();
            members.clear();
            members.addAll(loadedMembers);
        } catch (UnsupportedOperationException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Es konnte keine Verbindung zur Datenbank hergestellt werden!");
        }
    }

    /**
     * Methode zum Setzen der Strategie zur Speicherung der Member-Objekte
     * @param strategy Die Strategie zur Speicherung der Member-Objekte
     */
    public void setStrategy(PersistenceStrategy<Member> strategy) {
        this.ps = strategy;
    }

    /**
     * Methode zum Ausgeben der Member-Objekte
     */
    public List<Member> getCurrentList() {
        return members;
    }
}
