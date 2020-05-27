package aufgaben;

import aufgaben.felder.Feld;
import aufgaben.felder.ZahlFeld;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import joker.Joker;
import wuerfel.Wuerfel;

public class LilaAufgabe extends LineareAufgabe {

	private static final int anzahlFelder = 10;

	public LilaAufgabe(Blatt blatt) {
		super(blatt);

		// Felder einfügen
		((HBox) visualRepresentation).getChildren().add(felder[0].getVisualRepresentation());
		Insets padding = new Insets(8.0);
		for (int i = 1; i < felder.length; i++) {
			Feld f = felder[i];
			Label delimiter = new Label(">");
			delimiter.setPadding(padding);
			((HBox) visualRepresentation).getChildren().add(delimiter);
			((HBox) visualRepresentation).getChildren().add(f.getVisualRepresentation());
		}
		farbe = Wuerfel.LILA;

	}

	@Override
	public boolean pruefeBedingung(Wuerfel w, Feld f) {
		if (!super.pruefeBedingung(w, f)) {
			return false;
		}
		if (aktuelleAufgabe == 0) {
			return true;
		}
		boolean vorherigerGroesser = ((ZahlFeld) felder[aktuelleAufgabe - 1]).getValue() > w.getAugenzahl();
		return vorherigerGroesser || w.getAugenzahl() == 6;
	}

	@Override
	protected void init() {
		farbe = Wuerfel.LILA;
		felder = new ZahlFeld[anzahlFelder];
		for (int i = 0; i < anzahlFelder; i++)
			felder[i] = new ZahlFeld(this, Joker.BLAU);

	}
}
