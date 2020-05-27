package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import spiel.Spiel;

public class Controller {

	Spiel spiel = new Spiel();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private VBox links;

	@FXML
	private HBox mitte;

	@FXML
	private VBox rechts;

	@FXML
	void initialize() {
		assert links != null : "fx:id=\"links\" was not injected: check your FXML file 'GUI.fxml'.";
		assert mitte != null : "fx:id=\"mitte\" was not injected: check your FXML file 'GUI.fxml'.";
		assert rechts != null : "fx:id=\"rechts\" was not injected: check your FXML file 'GUI.fxml'.";

		spiel.startVisual(links, mitte, rechts);
	}

	@FXML
	void wuerfeln(ActionEvent event) {
		spiel.wuerfeln();
	}
}
