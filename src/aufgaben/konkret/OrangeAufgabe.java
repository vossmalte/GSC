package aufgaben.konkret;

import aufgaben.Blatt;
import aufgaben.felder.Feld;
import aufgaben.felder.ZahlFeld;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import wuerfel.Wuerfel;

public class OrangeAufgabe extends LineareAufgabe {
	
	private static final int[] faktoren = { -1, 1, 1, 2, 3, 1, 1, 2, 3, -1, 1, 1 };


	public OrangeAufgabe(Blatt blatt) {
		super(blatt);
		for (int i = 0; i < felder.length; i++) {
			Feld f = felder[i];
			((Pane) visualRepresentation).getChildren().add(f.getVisualRepresentation());
		}
	}

	@Override
	protected void init() {
		farbe = Wuerfel.ORANGE;
		felder = new ZahlFeld[faktoren.length];
		for (int i = 0; i < faktoren.length; i++) {
			felder[i] = new ZahlFeld(this, faktoren[i]);
		}

	}

}
