package dad.ahorcado.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PartidaController {
	@FXML
	private Label adivinarLabel;

	@FXML
	private ImageView ahorcadoImage;

	@FXML
	private Label fallosLabel;

	@FXML
	private TextField intentoField;

	@FXML
	private Button letraButton;

	@FXML
	private Label puntosLabel;

	@FXML
	private Button resolverButton;

	@FXML
	private BorderPane partidaRoot;

	@FXML
	void OnLetraAction(ActionEvent event) {

	}

	@FXML
	void OnResolverAction(ActionEvent event) {

	}

	public PartidaController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PartidaView.fxml"));
			loader.setController(this);
			loader.load();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public BorderPane getView() {
		return partidaRoot;
	}
}
