package application;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class POSMainSceneController {
	 public POSMainSceneController() {
		
	    }
	 public void initialize() {
		 Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	      SimpleDateFormat ft2 = new SimpleDateFormat ("hh:mm");
	      date.setText(ft.format(dNow));
	      time.setText(ft2.format(dNow));
	      checkbtn.setOnMouseEntered(new EventHandler<MouseEvent>() {

	 			@Override
	 			public void handle(MouseEvent arg0) {
	 				// TODO Auto-generated method stub
	 				checkbtn.setStyle("-fx-background-color: #93A1C0; -fx-background-radius: 15;");
	 			}

	 			
	     		 
	     	 });
	      checkbtn.setOnMouseExited(new EventHandler<MouseEvent>() {

	  			@Override
	  			public void handle(MouseEvent arg0) {
	  				// TODO Auto-generated method stub
	  				checkbtn.setStyle("-fx-background-color: LightSteelBlue; -fx-background-radius: 15;");
	  			}

	  			
	      		 
	      	 });
	      
	      orderbtn.setOnMouseEntered(new EventHandler<MouseEvent>() {

	 			@Override
	 			public void handle(MouseEvent arg0) {
	 				// TODO Auto-generated method stub
	 				orderbtn.setStyle("-fx-background-color: #93A1C0; -fx-background-radius: 15;");
	 			}

	 			
	     		 
	     	 });
	      orderbtn.setOnMouseExited(new EventHandler<MouseEvent>() {

	  			@Override
	  			public void handle(MouseEvent arg0) {
	  				// TODO Auto-generated method stub
	  				orderbtn.setStyle("-fx-background-color: LightSteelBlue; -fx-background-radius: 15;");
	  			}

	  			
	      		 
	      	 });
	    }
    @FXML
    private Button checkbtn;

    @FXML
    private Button orderbtn;

    @FXML
    private Label date;
    
    @FXML
    private Label time;
    
    void setDate() {
    	Date date = new Date();
    	this.date.setText(date.toString());
    }
    @FXML
    
    void checkEvent(ActionEvent event) throws IOException  {
    	Stage stage = new Stage();
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("POS_Payment.fxml")); 
    	Scene scene = new Scene(root,700,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		stage = (Stage) checkbtn.getScene().getWindow();
		stage.close();
		
    }

    @FXML
    void orderEvent(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("POS_Order.fxml")); 
    	Scene scene = new Scene(root,700,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		stage = (Stage) orderbtn.getScene().getWindow();
		stage.close();
		
    }
}
