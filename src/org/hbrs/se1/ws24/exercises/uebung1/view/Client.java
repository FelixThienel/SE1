package org.hbrs.se1.ws24.exercises.uebung1.view;

import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslatorFactory;

public class Client {

		/**
		 * Methode zur Ausgabe einer Zahl auf der Console
		 * (auch bezeichnet als CLI, Terminal)
		 *
		 */
		 void display(int aNumber) {
			 System.out.println("Das Ergebnis der Berechnung: " + GermanTranslatorFactory.createGermanTranslator().translateNumber(aNumber));
		 }
}





