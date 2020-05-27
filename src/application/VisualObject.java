package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;

public abstract class VisualObject {
	protected Parent visualRepresentation;

	public VisualObject() {
		visualRepresentation = getVisualRepresentation();
	}

	/**
	 * Lädt eine fxml-Datei mit dem Klassennamen. Falls keine Datei existiert, lädt
	 * es einen Default Wert.
	 * 
	 * @return visualRepresentation
	 */
	public final Parent getVisualRepresentation() {
		// if representation already loaded, return it.
		if (visualRepresentation != null)
			return visualRepresentation;

		// load representation from fxml
		URL location = getClass().getResource(getClass().getSimpleName() + ".fxml");
		// System.out.println(location);
		if (location == null)
			// return load if class not found
			return new ProgressIndicator();

		FXMLLoader loader = new FXMLLoader(location);
		loader.setController(this);

		try {
			return visualRepresentation = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return new ProgressIndicator();
		}
	}

	@FXML
	protected void clicked(MouseEvent event) {
		System.out.println(getClass().getName() + " was clicked");
	}
}
