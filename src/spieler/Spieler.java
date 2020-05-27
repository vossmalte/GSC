package spieler;

import application.VisualObject;
import aufgaben.Blatt;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import wuerfel.Wuerfel;

public class Spieler extends VisualObject {
	private Blatt blatt = new Blatt();

	@FXML
	private Label score;
	@FXML
	private HBox wuerfelBox;
	
	public void addWuerfel(Wuerfel w) {
		wuerfelBox.getChildren().add(w.getVisualRepresentation());
	}

	public Spieler() {
		super();
		((Pane) visualRepresentation).getChildren().add(blatt.getVisualRepresentation());
	}

	public int getValue() {
		int value = this.blatt.getValue();
		score.setText("Punkte: " + value);
		return value;
	}

}
