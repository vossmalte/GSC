package aufgaben.felder;

import aufgaben.Aufgabe;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import joker.Joker;
import wuerfel.Wuerfel;

public class KreuzFeld extends Feld {

	private int schranke;

	@FXML
	private Label labelInBox;
	@FXML
	CheckBox checkbox;

	public KreuzFeld(Aufgabe aufgabe, int value, int schranke) {
		this(aufgabe, null, value, schranke);
	}
	
	public KreuzFeld(Aufgabe aufgabe, Joker joker, int value, int schranke) {
		super(aufgabe, joker);
		this.value = value;
		this.schranke = schranke;
		switch (aufgabe.getFarbe()) {
		case GRUEN:
			labelInBox.setText("≥" + schranke);
			break;
		default:
			labelInBox.setText("" + schranke);
			break;
		}
	}

	@Override
	protected void bearbeiten(int augenzahl) {
		visualRepresentation.setDisable(bearbeitet);
		super.bearbeiten(augenzahl);
	}

	protected void zuruecksetzen() {
		checkbox.setSelected(false);
	}

	public int getSchranke() {
		return schranke;
	}

	protected boolean checkInternal(Wuerfel w) {
		switch (this.aufgabe.getFarbe()) {
		case GRUEN:
			return w.getAugenzahl() >= this.schranke;
		case BLAU:
			return Wuerfel.BLAU.getAugenzahl() + Wuerfel.WEISS.getAugenzahl() == this.schranke;
		default:
			return w.getAugenzahl() == this.schranke;
		}
	}

}
