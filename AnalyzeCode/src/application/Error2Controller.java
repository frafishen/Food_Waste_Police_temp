package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Error2Controller {
	
	 @FXML
	    private Button close;
	 
	 public void initialize() {
    	 close.setOnMouseEntered(new EventHandler<MouseEvent>() {

 			@Override
 			public void handle(MouseEvent arg0) {
 				// TODO Auto-generated method stub
 				close.setStyle("-fx-background-color: #FF4500; -fx-background-radius: 15;");
 			}

 			
     		 
     	 });
     	 close.setOnMouseExited(new EventHandler<MouseEvent>() {

  			@Override
  			public void handle(MouseEvent arg0) {
  				// TODO Auto-generated method stub
  				close.setStyle("-fx-background-color: coral; -fx-background-radius: 15;");
  			}

  			
      		 
      	 });
    }
   
	 @FXML
    void close(ActionEvent event) throws IOException{
    	Stage stage = new Stage();
    	stage = (Stage) close.getScene().getWindow();
		stage.close();
    }

}
