package aufgaben.felder;

import aufgaben.Aufgabe;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import joker.Joker;

public class ZahlFeld extends Feld {
	
	@FXML
    private Label faktorLabel;

    @FXML
    private Label valueLabel;

	public ZahlFeld(Aufgabe aufgabe) {
		this(aufgabe, 1);
	}
	
	public ZahlFeld(Aufgabe aufgabe, Joker joker) {
		this(aufgabe, joker, 1);
	}

	public ZahlFeld(Aufgabe aufgabe, int faktor) {
		this(aufgabe, null, faktor);
	}
	
	public ZahlFeld(Aufgabe aufgabe, Joker joker, int faktor) {
		super(aufgabe, joker);
		this.faktor = faktor;
		if (this.faktor != 1)
			faktorLabel.setText("" + this.faktor);
	}

	private int faktor = 1; // für Multiplikation in Orange

	@Override
	public void bearbeiten(int augenzahl) {
		value = faktor * augenzahl;
		valueLabel.setText("" + value);
		visualRepresentation.setDisable(bearbeitet);
		super.bearbeiten(augenzahl);
	}

	public int getValue() {
		return value;
	}

}
