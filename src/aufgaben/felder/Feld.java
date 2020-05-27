package aufgaben.felder;

import application.VisualObject;
import aufgaben.Aufgabe;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import joker.Joker;
import spiel.Spiel;
import wuerfel.Wuerfel;

public abstract class Feld extends VisualObject {
	protected int value = 0;
	protected boolean bearbeitet;
	protected Aufgabe aufgabe;
	protected Joker joker;

	@FXML
	protected Pane visFeld;

	public Feld(Aufgabe aufgabe) {
		this(aufgabe, null);
	}

	public Feld(Aufgabe aufgabe, Joker joker) {
		super();
		this.aufgabe = aufgabe;
		this.joker = joker;
		if (this.joker != null)
			visFeld.getChildren().add(this.joker.getVisualRepresentation());
	}

	/**
	 * Gibt den Spielwert des Feldes zurück. Ein Feld hat nur dann einen Wert, wenn
	 * es bearbeitet wurde.
	 * 
	 * @return value;
	 */
	public int getValue() {
		return bearbeitet ? value : 0;
	}

	public boolean istBearbeitet() {
		return bearbeitet;
	}

	protected void bearbeiten(int augenzahl) {
		bearbeitet = true;
		if (joker != null)
			joker.einloesen();
	}

	/**
	 * Setzt das Feld zurück, bspw nach einem illegalen Bearbeiten
	 */
	protected void zuruecksetzen() {
	}

	/**
	 * Prüft, ob dieses Feld mit dem gewählten Würfel ausfüllbar ist.
	 * 
	 * @param w gewählter Würfel
	 * @return Erfolg?
	 */
	protected boolean checkInternal(Wuerfel w) {
		return true;
	}

	@Override
	protected final void clicked(MouseEvent event) {
		if (!bearbeitet && Joker.getAktuellerJoker() != null && (Joker.getAktuellerJoker().getFarbe() == Wuerfel.WEISS
				|| Joker.getAktuellerJoker().getFarbe() == aufgabe.getFarbe())) {
			// Joker aktiv
			this.bearbeiten(6);
			this.aufgabe.incrementAktuelleAufgabe();
			System.out.println("Joker genutzt");
		} else if (bearbeitet || Wuerfel.getAktuellerWuerfel() == null
				|| !this.checkInternal(Wuerfel.getAktuellerWuerfel())
				|| !aufgabe.pruefeBedingung(Wuerfel.getAktuellerWuerfel(), this)) {
			// Feld schon bearbeitet -> Keine Aktion
			// Kein Würfel -> kein Problem
			zuruecksetzen();
		} else {
			this.bearbeiten(Wuerfel.getAktuellerWuerfel().getAugenzahl());
			this.aufgabe.incrementAktuelleAufgabe();
			Spiel.getSpiel().wuerfelEintragen(Wuerfel.getAktuellerWuerfel());
			System.out.println("Feld wurde bearbeitet");
		}
	}
	
	
}
