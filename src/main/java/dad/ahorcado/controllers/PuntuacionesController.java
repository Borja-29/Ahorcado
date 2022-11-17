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
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class PuntuacionesController implements Initializable{

	
	private ListProperty<String> puntuaciones = new SimpleListProperty<>(FXCollections.observableArrayList());
	
	 @FXML
	    private ListView<String> puntuacionesList;

	    @FXML
	    private BorderPane puntuacionesRoot;

	    public PuntuacionesController(){
	    	
	    	try{
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/PuntuacionesView.fxml"));
			loader.setController(this);
			loader.load();
			
	    	} catch (IOException e) {
				throw new RuntimeException(e);
			}
	    }
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			
	    	puntuacionesList.itemsProperty().bind(puntuaciones);

		}
	    
	    public BorderPane getView() {
	    	return puntuacionesRoot;
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

}
