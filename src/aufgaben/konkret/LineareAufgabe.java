/**
 * 
 */
package aufgaben.konkret;

import aufgaben.Aufgabe;
import aufgaben.Blatt;
import aufgaben.felder.Feld;
import wuerfel.Wuerfel;

/**
 * @author malte
 *
 */
public abstract class LineareAufgabe extends Aufgabe {

	protected LineareAufgabe(Blatt blatt) {
		super(blatt);
	}

	/**
	 * Macht nach Möglichkeit die nächste Aufgabe
	 * 
	 * @param augenzahl
	 * @return lösbar
	 */

	@Override
	public boolean pruefeBedingung(Wuerfel w, Feld f) {
		if (!super.pruefeBedingung(w, f))
			return false;
		if (aktuelleAufgabe >= felder.length)
			return false;
		return f == felder[aktuelleAufgabe];
	}

}
