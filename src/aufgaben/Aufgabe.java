package aufgaben;

import application.VisualObject;
import aufgaben.felder.Feld;
import wuerfel.Wuerfel;

public abstract class Aufgabe extends VisualObject {
	protected Wuerfel farbe;
	protected Feld[] felder;
	protected Blatt blatt;

	// Attribute für lineare Aufgaben
	protected int aktuelleAufgabe = 0;

	public void incrementAktuelleAufgabe() {
		aktuelleAufgabe++;
	}
	
	/**
	 * Gibt die Punktzahl dieser Ausgabe zurück.
	 * @return Punktzahl
	 */
	public int getValue() {
		int value = 0;
		for (Feld f: felder)
			value += f.getValue();
		return value;
	}
	
	public Wuerfel getFarbe() {
		return farbe;
	}

	protected Aufgabe(Blatt blatt) {
		init();
		this.blatt = blatt;
		getVisualRepresentation();
		visualRepresentation.setStyle("-fx-background-color: " + farbe.getFarbCode());

	}

	/**
	 * Initialisiert die Felder der Aufgabe und setzt den zugehörigen Würfel
	 */
	protected abstract void init();

	/**
	 * Entscheidet, ob das Feld mit dem gewählten Würfel lösbar ist.
	 * 
	 * @param augenzahl
	 * @return lösbar
	 */
	public boolean pruefeBedingung(Wuerfel w, Feld f) {
		return (w.equals(Wuerfel.WEISS) || farbe.equals(w));
	}
}
