package wuerfel;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import spiel.Spiel;

/**
 * Enum halt alle Würfel.
 * 
 * @author malte
 *
 */
public enum Wuerfel {
	BLAU("#193bdf"), WEISS("#FFFFFF"), GELB("#ffd700"), ORANGE("#ffa54f"), LILA("#a427dd"), GRUEN("#4f983c");

	/**
	 * Der aktuell ausgewählte Würfel des Spiels
	 */
	static Wuerfel aktuellerWuerfel = null;

	public static Wuerfel getAktuellerWuerfel() {
		return aktuellerWuerfel;
	}

	private int augenzahl;
	private String farbCode;
	private Label visualRepresentation;

	Wuerfel(String farbCode) {
		this.farbCode = farbCode;
		getVisualRepresentation();
	}

	/**
	 * Würfelt den Würfel
	 * 
	 * @return Augenzahl
	 */
	public int wuerfeln() {
		augenzahl = (int) (Math.random() * 6) + 1;
		// TODO: würfel zufällig visuell verteilen
		// Parent p = visualRepresentation.getParent();
		// visualRepresentation.relocate(Math.random()*200, Math.random()*300);
		visualRepresentation.setText("" + augenzahl);
		return augenzahl;
	}

	public int getAugenzahl() {
		return augenzahl;
	}

	public String getFarbCode() {
		return farbCode;
	}

	public final Parent getVisualRepresentation() {
		// if representation already loaded, return it.
		if (visualRepresentation != null)
			return visualRepresentation;

		// load representation from fxml
		URL location = getClass().getResource(getClass().getSimpleName() + ".fxml");
		if (location == null)
			// return load if class not found
			return new ProgressIndicator();

		FXMLLoader loader = new FXMLLoader(location);
		loader.setController(this);

		try {
			visualRepresentation = loader.load();
			String style = visualRepresentation.getStyle();
			visualRepresentation.setStyle(style + "; " + "-fx-background-color: " + this.getFarbCode());
			return visualRepresentation;
		} catch (IOException e) {
			e.printStackTrace();
			return new ProgressIndicator();
		}
	}

	private void select() {
		Wuerfel.aktuellerWuerfel = this;
		visualRepresentation.setScaleX(2);
		visualRepresentation.setScaleY(2);
	}

	public void unselect() {
		visualRepresentation.setScaleX(1);
		visualRepresentation.setScaleY(1);
		Wuerfel.aktuellerWuerfel = null;
	}

	public void clicked(MouseEvent event) {
		if (Wuerfel.aktuellerWuerfel != null)
			Wuerfel.aktuellerWuerfel.unselect();
		if (!Spiel.getSpiel().auswaehlbar(this))
			return;
		this.select();
	}

}
