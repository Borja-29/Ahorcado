package dad.ahorcado.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class PalabrasController implements Initializable{

	
	private ListProperty<String> palabras = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	@FXML
	private Button agregarButton;

	@FXML
	private ListView<String> palabrasList;

	@FXML
	private BorderPane palabrasRoot;

	@FXML
	private Button quitarButton;

	

	public PalabrasController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PalabrasView.fxml"));
			loader.setController(this);
			loader.load();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// bindings

		palabrasList.itemsProperty().bind(palabras);

	}

	public BorderPane getView() {
		return palabrasRoot;
	}
	
	@FXML
	void OnAgregarAction(ActionEvent event) {

	}

	@FXML
	void OnQuitarAction(ActionEvent event) {

	}
	
	public final ListProperty<String> palabrasProperty() {
		return this.palabras;
	}

	public final ObservableList<String> getPalabras() {
		return this.palabrasProperty().get();
	}

	public final void setPalabras(final ObservableList<String> palabras) {
		this.palabrasProperty().set(palabras);
	}
}
