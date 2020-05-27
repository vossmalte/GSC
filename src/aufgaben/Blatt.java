package aufgaben;

import application.VisualObject;
import aufgaben.konkret.BlaueAufgabe;
import aufgaben.konkret.GrueneAufgabe;
import aufgaben.konkret.LilaAufgabe;
import aufgaben.konkret.OrangeAufgabe;
import javafx.scene.layout.VBox;

/**
 * Modelliert das Blatt, in dem Würfe eingetragen werden. Besteht aus Aufgaben
 * und Jokern.
 * 
 * @author malte
 *
 */
public class Blatt extends VisualObject {
	Aufgabe aufgaben[] = { new BlaueAufgabe(this), new GrueneAufgabe(this), new LilaAufgabe(this),
			new OrangeAufgabe(this) };

	public Blatt() {
		getVisualRepresentation();
		for (Aufgabe a : aufgaben)
			((VBox) visualRepresentation).getChildren().add(a.getVisualRepresentation());
	}

	/**
	 * Berechnet die Punktzahl der Aufgaben
	 * 
	 * @return
	 */
	public int getValue() {
		int value = 0;
		for (Aufgabe a : aufgaben) {
			value += a.getValue();
		}
		return value;
	}

}
