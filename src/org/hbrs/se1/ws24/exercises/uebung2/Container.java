package org.hbrs.se1.ws24.exercises.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {
    List<Member> members;

    public Container() {
        members = new ArrayList<Member>();
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

    public void dump() {
        for(Member aMember : members)
            System.out.println(aMember.toString());
    }

    public int size() {
        return members.size();
    }
}
