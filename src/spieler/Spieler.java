package spieler;

import application.VisualObject;
import aufgaben.Blatt;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import wuerfel.Wuerfel;

public class Spieler extends VisualObject {
	private Blatt blatt = new Blatt();
	private Wuerfel wuerfel;

	@FXML
	private Label score;

	public Spieler() {
		super();
		((Pane) visualRepresentation).getChildren().add(blatt.getVisualRepresentation());
	}

	public Wuerfel getWuerfel() {
		return wuerfel;
	}

	public void setWuerfel(Wuerfel wuerfel) {
		this.wuerfel = wuerfel;
	}

	public int getValue() {
		int value = this.blatt.getValue();
		score.setText("Punkte: " + value);
		return value;
	}

}
