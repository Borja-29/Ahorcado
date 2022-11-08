package dad.ahorcado.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class PuntuacionesController {

	 @FXML
	    private ListView<?> puntuacionesList;

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
	    
	    public BorderPane getView() {
	    	return puntuacionesRoot;
	    }
}
