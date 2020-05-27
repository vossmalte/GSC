package aufgaben.konkret;

import aufgaben.Blatt;
import aufgaben.felder.Feld;
import aufgaben.felder.KreuzFeld;
import javafx.scene.layout.Pane;
import wuerfel.Wuerfel;

public class GrueneAufgabe extends LineareAufgabe {

	private static final int[] untereSchranke = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6 };

	public GrueneAufgabe(Blatt blatt) {
		super(blatt);
		for (int i = 0; i < felder.length; i++) {
			Feld f = felder[i];
			// VBox v = new VBox();
			// v.getChildren().add(f.getVisualRepresentation());
			// Label l = new Label("≥" + untereSchranke[i]);
			((Pane) visualRepresentation).getChildren().add(f.getVisualRepresentation());
		}

	}

	@Override
	protected void init() {
		farbe = Wuerfel.GRUEN;
		felder = new KreuzFeld[untereSchranke.length];
		for (int i = 0; i < felder.length; i++)
			felder[i] = new KreuzFeld(this, i + 1, untereSchranke[i]);
	}

	@Override
	public boolean pruefeBedingung(Wuerfel w, Feld f) {
		if (!super.pruefeBedingung(w, f))
			return false;
		// Einträge in Grün müssen größer gleich der Schranke sein
		return w.getAugenzahl() >= ((KreuzFeld) f).getSchranke();
	}

}
