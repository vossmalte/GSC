package aufgaben.konkret;

import java.util.HashMap;

import aufgaben.BingoAufgabe;
import aufgaben.Blatt;
import aufgaben.felder.KreuzFeld;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import joker.Joker;
import wuerfel.Wuerfel;

public class BlaueAufgabe extends BingoAufgabe {
	
	// TODO
	/**
	 * kreuze die Felder mit diesen Indizes ab und erhalte einen Joker.
	 */
	private static final int[][] patterns = {
			{0,0,1,2},
			{3,4,5,6},
			{7,8,9,10}
	};
	
	private static final Joker[] jokers = {
			null,
			null,
			null
	};
	
	HashMap<int[], Joker> tasksForJokers;
	

	public BlaueAufgabe(Blatt blatt) {
		super(blatt);
		int i;
		HBox h;
		
		h = new HBox(3.);
		for (i = 0; i < 3; i++)
			h.getChildren().add(felder[i].getVisualRepresentation());
		((Pane) visualRepresentation).getChildren().add(h);
		
		h = new HBox(3.);
		for (; i < 7; i++)
			h.getChildren().add(felder[i].getVisualRepresentation());
		((Pane) visualRepresentation).getChildren().add(h);
		
		h = new HBox(3.);
		for (; i < felder.length; i++)
			h.getChildren().add(felder[i].getVisualRepresentation());
		((Pane) visualRepresentation).getChildren().add(h);
		
		tasksForJokers = new HashMap<int[], Joker>();
		for (int j = 0; j < patterns.length; j++) {
			tasksForJokers.put(patterns[j], jokers[j]) ;
		}
	}

	@Override
	public void checkBingo() {
		for (int[] p : tasksForJokers.keySet()) {
			boolean and = true;
			for (int i : p) {
				and &= felder[i].istBearbeitet();
			}
			if (and)	// alle Felder des Pattern bearbeitet -> Joker
				tasksForJokers.remove(p).einloesen();
		}
	}

	@Override
	protected void init() {
		farbe = Wuerfel.BLAU;
		felder = new KreuzFeld[11];
		for (int i = 0; i < felder.length; i++) {
			felder[i] = new KreuzFeld(this, 0, i + 2);
		}

	}

}
