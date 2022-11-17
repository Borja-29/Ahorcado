package dad.ahorcado.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PartidaController implements Initializable{
	
	private StringProperty adivinar = new SimpleStringProperty();
	
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

	public PartidaController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PartidaView.fxml"));
			loader.setController(this);
			loader.load();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		adivinarLabel.textProperty().bindBidirectional(adivinar);
		
	}
	

	public BorderPane getView() {
		return partidaRoot;
	}
	
	@FXML
	void OnLetraAction(ActionEvent event) {

	}

	@FXML
	void OnResolverAction(ActionEvent event) {

	}

	public final StringProperty adivinarProperty() {
		return this.adivinar;
	}
	

	public final String getAdivinar() {
		return this.adivinarProperty().get();
	}
	

	public final void setAdivinar(final String adivinar) {
		this.adivinarProperty().set(adivinar);
	}
	
	
	

	
}
