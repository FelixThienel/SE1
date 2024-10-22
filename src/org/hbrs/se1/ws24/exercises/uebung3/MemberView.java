package org.hbrs.se1.ws24.exercises.uebung3;

import java.util.List;

/**
 * Klasse zur Ausgabe der Member-Objekte
 */
public class MemberView {
    /**
     * Methode zum Ausgeben der Member-Objekte
     * @param member Liste der Member-Objekte
     */
    public void dump(List<Member> member) {
        for(Member m : member)
            System.out.println(m.toString());
    }
}
