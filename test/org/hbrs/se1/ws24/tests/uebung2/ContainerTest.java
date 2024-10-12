package org.hbrs.se1.ws24.tests.uebung2;

import org.hbrs.se1.ws24.exercises.uebung2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerTest {
    ConcreteMember member1 = new ConcreteMember(1);
    ConcreteMember member2 = new ConcreteMember(2);
    Container container;

    @BeforeEach
    public void setUp() {
        container = new Container();
    }

    @Test
    public void testAddMember() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
    }

    @Test
    public void testAddSameMember() throws ContainerException {
        container.addMember(member1);
        try {
            container.addMember(member1);
        } catch (ContainerException e) {
            assertEquals("Das Member-Objekt mit der ID 1 ist bereits vorhanden!", e.getMessage());
        }
    }

    @Test
    public void testDeleteMember() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        assertEquals("Das Member-Objekt mit der ID 1 wurde erfolgreich gelöscht!", container.deleteMember(1));
    }

    @Test
    public void testDeleteNonExistentMember() {
        assertEquals("Das Member-Objekt mit der ID 1 ist nicht vorhanden!", container.deleteMember(1));
    }

    @Test
    public void testDump() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        container.dump();
        //Auslesen der Konsole und überprüfen ob die Member-Objekte korrekt ausgegeben wurden
    }

    @Test
    public void testSize() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        assertEquals(2, container.size());
    }
}
