package org.hbrs.se1.ws24.exercises.uebung3.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "src\\org\\hbrs\\se1\\ws24\\exercises\\uebung3\\Daten\\objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     * Look-up in Google for further help! Good source:
     * https://www.digitalocean.com/community/tutorials/objectoutputstream-java-write-object-file
     * (Last Access: Oct, 15th 2024)
     */
    public void save(List<E> member) throws PersistenceException  {
        // Try-Catch with Resources: Schließt die Streams automatisch
        try (FileOutputStream fos = new FileOutputStream(location); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(member);
            oos.flush();
        } catch (Exception e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Datei " + location + " konnte nicht beschrieben werden");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {
        // Try-Catch with Resources: Schließt die Streams automatisch
        try (FileInputStream fis = new FileInputStream(location); ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<E>) ois.readObject();
        } catch (Exception e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "Datei " + location + " konnte nicht gelesen werden");
        }
    }
}
