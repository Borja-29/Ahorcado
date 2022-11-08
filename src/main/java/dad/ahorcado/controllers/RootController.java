package dad.ahorcado.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController implements Initializable{
	
	 	
	private ListProperty<String> palabras = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	@FXML
	    private Tab palabrasTab;

	    @FXML
	    private Tab partidaTab;

	    @FXML
	    private Tab puntuacionesTab;
	    
	    @FXML
	    private TabPane view;
	    
	    private PartidaController partidaController = new PartidaController();
	    private PalabrasController palabrasController = new PalabrasController();
	    private PuntuacionesController puntuacionesController = new PuntuacionesController();
	
	    public RootController() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader (getClass().getResource("/FXML/RootView.fxml"));
	    		loader.setController(this);
	    		loader.load();
	    	} catch (IOException e){
	    		throw new RuntimeException(e);
	    	}
	    }
	    
	    
	    
	public void initialize(URL location, ResourceBundle resources) {
		palabrasTab.setContent(palabrasController.getView());
		partidaTab.setContent(partidaController.getView());
		puntuacionesTab.setContent(puntuacionesController.getView());
		
		palabrasController.palabrasProperty().bind(palabras);
	}
	
	public TabPane getView() {
		return view;
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
