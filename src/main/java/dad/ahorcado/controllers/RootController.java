package dad.ahorcado.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController implements Initializable{
	
	 	
	private ListProperty<String> palabras = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<String> puntuaciones = new SimpleListProperty<>(FXCollections.observableArrayList());
	private StringProperty adivinar = new SimpleStringProperty();
	
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
		puntuacionesController.puntuacionesProperty().bind(puntuaciones);
		partidaController.adivinarProperty().bind(adivinar);
		
		//setAdivinar(palabraAleatoria());
		
	}
	
	public String palabraAleatoria() {
		
		int numeroAleatorio = (int) (Math.random()*(palabras.getSize()));
		StringProperty selected = new SimpleStringProperty(palabras.get(numeroAleatorio));
		
		return palabras.get(numeroAleatorio);
		
	}
	
	public TabPane getView() {
		return view;
	}
	
	public String obtenerPalabra() {
		int aleatorioAux = (int) (Math.random()*palabrasProperty().size()+0);
		return palabrasProperty().get(aleatorioAux);
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
	
	public final ListProperty<String> puntuacionesProperty() {
		return this.puntuaciones;
	}
	
	public final ObservableList<String> getPuntuaciones() {
		return this.puntuacionesProperty().get();
	}
	

	public final void setPuntuaciones(final ObservableList<String> puntuaciones) {
		this.puntuacionesProperty().set(puntuaciones);
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
