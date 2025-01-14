package org.hbrs.se1.ws24.tests.uebung10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hbrs.se1.ws24.exercises.uebung10.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyPrettyRectangleTest {

	private MyPrettyRectangle left;
	private MyPrettyRectangle middle;
	private MyPrettyRectangle right; 
	private MyPrettyRectangle somewhere;
	
	/*
	 * Set-Up Methode ("BeforeEach"), die fuer alle Test-Methoden die Rechtecke gemaeß der Skizze definiert.
	 * Wird vor jeder Test-Methode ausgefuehrt. 
	 *
	 */
	//
	@BeforeEach
	public void setUp() throws Exception { 
		// 
		//     +-----------+   +---+
		//     |         r |   | s |
		// +---+---+---+   |   |   |
		// | l |   | m |   |   |   |
		// |   |   +---+   |   |   |
		// |   |       |   |   |   |
		// +---+-------+   |   +---+
		//     |           |
		//     +-----------+
		//
		// Annahme: 1 Einheit = 1cm
		// MyPrettyRectangle-Konstruktor: MyPrettyRectangle(x1,y1,x2,y2)
		// x1,y1: Punkt links unten
		// x2,y2: Punkt rechts oben
		
		left = new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0); // l
		middle = new MyPrettyRectangle(2.0, 2.0, 3.0, 3.0); // m
		right = new MyPrettyRectangle(1.0, 0.0, 4.0, 4.0);  // r
		somewhere = new MyPrettyRectangle(5.0, 1.0, 6.0, 4.0); // s
	}
	
	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche prueft, ob ein Rechteck
	 * ein anderes Rechteck vollstaendig enthaelt. Bitte geben Sie einen vollständigen Test an!
	 * (Ergebnis: boolean Wert)
	 * 
	 */
	@Test
	public void testContains() {
        assertTrue(left.contains(left));
		assertTrue(left.contains(middle));
		assertTrue(middle.contains(middle));
		assertTrue(right.contains(right));
		assertTrue(right.contains(middle));
		assertTrue(somewhere.contains(somewhere));

		assertFalse(left.contains(right));
		assertFalse(left.contains(somewhere));
		assertFalse(middle.contains(left));
		assertFalse(middle.contains(right));
		assertFalse(middle.contains(somewhere));
		assertFalse(right.contains(left));
		assertFalse(right.contains(somewhere));
		assertFalse(somewhere.contains(left));
		assertFalse(somewhere.contains(middle));
		assertFalse(somewhere.contains(right));
	}
	
	/*
	 * Methode zum Testen einer Methode der Kasse MyPrettyRectangle, welche den Mittelpunkt eines Rechtecks berechnet
	 * (Ergebnis: ein Punkt in einem Koordinatensystem)
	 * 
	 */
	@Test
	public void testGetCenter(){
		// Erster Test, um die Korrektheit der Methode getCenter() zu ueberpruefen
		assertEquals(new MyPoint(1.5, 2.0), left.getCenter());
		assertEquals(new MyPoint(2.5, 2.5), middle.getCenter());
		assertEquals(new MyPoint(2.5, 2.0), right.getCenter());
		assertEquals(new MyPoint(5.5, 2.5), somewhere.getCenter());
    }
	
	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche die Flaeche eines Rechtecks berechnet
	 * (Ergebnis: Wert in Quadratzentimeter, cm2)
	 * 
	 */
	
	@Test
	public void testGetArea(){
		assertEquals(6.0, left.getArea(), 0.0001);
		assertEquals(1.0, middle.getArea(), 0.0001);
		assertEquals(12.0, right.getArea(), 0.0001);
		assertEquals(3.0, somewhere.getArea(), 0.0001);
	}

	
	
	/*
	 * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche den Umfang eines Rechtecks berechnet
	 * (Ergebnis: Wert in Zentimeter, cm)
	 * 
	 */
	@Test
	public void testGetPerimeter(){
        assertEquals(10.0, left.getPerimeter(), 0.0001);
		assertEquals(4.0, middle.getPerimeter(), 0.0001);
		assertEquals(14.0, right.getPerimeter(), 0.0001);
		assertEquals(8.0, somewhere.getPerimeter(), 0.0001);
	}
	
	/*
	 * Methode zum Testen der Objekt-Identitaet zwischen den MyPrettyRectangle-Objekten
	 * 
	 */
	@Test
	public void testSameIdentity() {
		MyPrettyRectangle other = left;
		assertTrue(left.equals(left));
		assertTrue(left.equals(other));
		assertTrue(other.equals(left));
		assertTrue(other.equals(other));
		assertTrue(middle.equals(middle));
		assertTrue(right.equals(right));
		assertTrue(somewhere.equals(somewhere));

		assertFalse(left.equals(middle));
		assertFalse(left.equals(right));
		assertFalse(left.equals(somewhere));
		assertFalse(middle.equals(left));
		assertFalse(middle.equals(right));
		assertFalse(middle.equals(somewhere));
		assertFalse(middle.equals(other));
		assertFalse(right.equals(left));
		assertFalse(right.equals(middle));
		assertFalse(right.equals(somewhere));
		assertFalse(right.equals(other));
		assertFalse(somewhere.equals(left));
		assertFalse(somewhere.equals(middle));
		assertFalse(somewhere.equals(right));
		assertFalse(somewhere.equals(other));
		assertFalse(other.equals(middle));
		assertFalse(other.equals(right));
		assertFalse(other.equals(somewhere));
	}
	
	/*
	 * Methode zum Testen einer statischen Methode einer weiteren Klasse BoundingBoxFactory, die auf Basis eines Arrays von
	 * Rechtecken eine Bounding Box berechnet und zurueckliefert.
	 * 
	 * Definition Bounding Box: Eine Bounding Box (deutsch: minimal umgebendes Rechteck, MUR) bezeichnet das
	 * kleinstmoegliche achsenparallele Rechteck, das eine vorgegebene Menge von Rechtecken umschliesst.
	 * 
	 */
	@Test
	public void testGetBoundingBox( ) {
		MyPrettyRectangle[] rect = {middle, right, somewhere};
		MyPrettyRectangle boundingBox = BoundingBoxFactory.getBoundingBox(rect);
		MyPrettyRectangle expected = new MyPrettyRectangle(1.0, 0.0, 6.0, 4.0);

		assertEquals(boundingBox, expected);

		assertNotNull(boundingBox);

		MyPrettyRectangle boundingBox2 = BoundingBoxFactory.getBoundingBox(new MyPrettyRectangle[0]);

		assertEquals(0.0, boundingBox2.getX1());
		assertEquals(0.0, boundingBox2.getY1());
		assertEquals(0.0, boundingBox2.getX2());
		assertEquals(0.0, boundingBox2.getY2());

		MyPrettyRectangle boundingBox3 = BoundingBoxFactory.getBoundingBox(null);

		assertNull(boundingBox3);
	}
}