package spiel;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import spieler.Spieler;
import wuerfel.Wuerfel;

/**
 * Spiel-Klasse. Koordiniert Würfel, Spieler und Runden.
 * 
 * @author malte
 *
 */
public class Spiel {
	private static Spiel spiel;
	/**
	 * Singleton
	 * @return instance
	 */
	public static Spiel getSpiel() {
		return spiel;
	}

	private List<Wuerfel> freieWuerfel = new ArrayList<>();
	private List<Wuerfel> silberTablett = new ArrayList<>();
	private List<Spieler> spieler = new ArrayList<>();
	private Spieler aktiverSpieler;

	// GUI Elemente
	Pane links, mitte, rechts;

	public Spiel() {
		this(1);
	}

	public Spiel(int playerNumber) {
		for (Wuerfel w : Wuerfel.values())
			freieWuerfel.add(w);
		for (int i = 0; i < playerNumber; i++)
			spieler.add(new Spieler());

		spiel = this;
	}

	public void wuerfeln() {
		for (Wuerfel w : freieWuerfel)
			w.wuerfeln();
	}

	/**
	 * Nach dem Eintragen des Würfels (siehe {@link feld.Feld}), wird dieser Würfel
	 * zum Spieler gelegt und Würfel mit kleinerer Augenzahl zum Silbertablett
	 * hinzugefügt.
	 * 
	 * @param wuerfel
	 */
	public void wuerfelEintragen(Wuerfel wuerfel) {
		// TODO: Würfel zum Spieler

		for (Wuerfel w : freieWuerfel.toArray(new Wuerfel[freieWuerfel.size()])) {
			if (w.getAugenzahl() < wuerfel.getAugenzahl()) {
				freieWuerfel.remove(w);
				links.getChildren().remove(w.getVisualRepresentation());
				silberTablett.add(w);
				rechts.getChildren().add(w.getVisualRepresentation());

			}
		}
		
		// Punkte aktualisieren
		for (Spieler s : this.spieler)
			s.getValue();
	}

	/**
	 * Fügt Objekte in die GUI ein.
	 * 
	 * @param links
	 * @param mitte
	 * @param rechts
	 */
	public void startVisual(Pane links, Pane mitte, Pane rechts) {
		this.links = links;
		this.mitte = mitte;
		this.rechts = rechts;

		for (Spieler s : spieler)
			mitte.getChildren().add(s.getVisualRepresentation());
		for (Wuerfel w : freieWuerfel)
			links.getChildren().add(w.getVisualRepresentation());
	}

}
