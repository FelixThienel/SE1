package org.hbrs.se1.ws24.tests.uebung3;

import org.hbrs.se1.ws24.exercises.uebung3.*;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeicherTests {
    Container container = Container.getInstance();

    Member m1 = new ConcreteMember(1);
    Member m2 = new ConcreteMember(2);
    Member m3 = new ConcreteMember(3);

    @BeforeEach
    public void setUp() {
        try {
            container.addMember(m1);
            container.addMember(m2);
            container.addMember(m3);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        container.deleteMember(1);
        container.deleteMember(2);
        container.deleteMember(3);
    }

    @Test
    public void testKeineStrategie() {
        try {
            container.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, e.getExceptionTypeType());
        }
    }

    @Test
    public void testMongoDB() {
        container.setStrategy(new PersistenceStrategyMongoDB<>());
        try {
            container.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.ImplementationNotAvailable, e.getExceptionTypeType());
        }
    }

    @Test
    public void testOrdner() {
        PersistenceStrategyStream<Member> ps = new PersistenceStrategyStream<>();
        ps.setLocation("src\\org\\hbrs\\se1\\ws24\\exercises\\uebung3\\Daten\\");
        container.setStrategy(ps);
        try {
            container.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getExceptionTypeType());
        }
    }

    @Test
    public void testRoundTrip() {
        container.setStrategy(new PersistenceStrategyStream<>());
        try {
            assertEquals(3, container.size());
            container.store();
            assertEquals(3, container.size());
            container.deleteMember(1);
            container.deleteMember(2);
            container.deleteMember(3);
            assertEquals(0, container.size());
            container.load();
            assertEquals(3, container.size());
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}