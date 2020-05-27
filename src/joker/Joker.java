package joker;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import wuerfel.Wuerfel;

public enum Joker {
	BLAU(Wuerfel.BLAU),
	GRUEN(Wuerfel.GRUEN),
	GELB(Wuerfel.GELB),
	LILA(Wuerfel.LILA),
	FREE(Wuerfel.WEISS);
	
	static Joker aktuellerJoker = null;
	public static Joker getAktuellerJoker() {
		return aktuellerJoker;
	}
	public static void jokerEingeloest() {
		aktuellerJoker = null;
	}
	
	
	final Wuerfel farbe;
	public Wuerfel getFarbe() {
		return farbe;
	}
	Joker(Wuerfel f) {
		this.farbe = f;
	}
	
	public void einloesen() {
		aktuellerJoker = this;
	}
	
	
	Parent visualRepresentation;
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
			visualRepresentation.setStyle("-fx-background-color: " + this.getFarbe().getFarbCode());
			return visualRepresentation;
		} catch (IOException e) {
			e.printStackTrace();
			return new ProgressIndicator();
		}
	}
}
