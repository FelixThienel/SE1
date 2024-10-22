package org.hbrs.se1.ws24.exercises.uebung3;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;

public class Main {
    public static void main(String[] args) {
        Container container = Container.getInstance();
        container.setStrategy(new PersistenceStrategyStream<Member>());
        Client client = new Client();
        client.test(container);
    }
}
