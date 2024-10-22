package org.hbrs.se1.ws24.exercises.uebung3;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {
    private final int id;

    public ConcreteMember(int id) {
        this.id = id;
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Member (ID = " + id + ")";
    }
}
