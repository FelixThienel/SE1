package org.hbrs.se1.ws24.exercises.uebung4;

import org.hbrs.se1.ws24.exercises.uebung4.persistence.*;

import java.util.*;

public class Container {
        // Singleton-Pattern
        private static Container instance;
        List<UserStories> userStories;

        private Container() {
            userStories = new ArrayList<>();
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

        public void addUserStories(UserStories us) throws ContainerException {
            for(UserStories aus : userStories)
                if(Objects.equals(aus.getID(), us.getID()))
                    throw new ContainerException("Das Member-Objekt mit der ID " + us.getID() + " ist bereits vorhanden!");
            userStories.add(us);
            sortieren();
        }

        public String deleteUserStories(int id) {
            for(UserStories aus : userStories)
                if(aus.getID() == id) {
                    userStories.remove(aus);
                    return "Das Member-Objekt mit der ID " + id + " wurde erfolgreich gelöscht!";
                }
            return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden!";
        }

        public int size() {
            return userStories.size();
        }

        /**
         * Methode zum Speichern der Member-Objekte in einer Datei
         */
        public void store() throws PersistenceException {
            PersistenceStrategyStream<UserStories> ps = new PersistenceStrategyStream<>();
            ps.save(userStories);
        }

        /**
         * Methode zum Laden der Member-Objekte aus einer Datei
         */
        public void load() throws PersistenceException {
            try {
                PersistenceStrategyStream<UserStories> ps = new PersistenceStrategyStream<>();
                List<UserStories> loadedMembers = ps.load();
                userStories.clear();
                userStories.addAll(loadedMembers);
            } catch (UnsupportedOperationException e) {
                throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Es konnte keine Verbindung zur Datenbank hergestellt werden!");
            }
        }

        /**
         * Methode zum Ausgeben der Member-Objekte
         */
        public List<UserStories> getCurrentList() {
            return userStories;
        }

        private void sortieren() {
            userStories.sort(new Comparator<UserStories>() {
                @Override
                public int compare(UserStories us1, UserStories us2) {
                    // Vergleich von prio in umgekehrter Reihenfolge für absteigende Sortierung
                    return Double.compare(us2.getPrio(), us1.getPrio());
                }
            });
        }
}
