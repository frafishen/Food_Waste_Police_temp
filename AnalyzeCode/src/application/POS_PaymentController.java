package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class POS_PaymentController {

    @FXML
    private Button b0;

    @FXML
    private Button b00;

    @FXML
    private Button b000;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button bback;

    @FXML
    private Button bc;

    @FXML
    private Button bconfirm;

    @FXML
    private Button binput;

    @FXML
    private Button bo;

  
    @FXML
    private TextField tablefield;
    
    public String getTableNumber() {
    	return tablefield.getText();
    }

    public void initialize() {
    	 bconfirm.setOnMouseEntered(new EventHandler<MouseEvent>() {

 			@Override
 			public void handle(MouseEvent arg0) {
 				// TODO Auto-generated method stub
 				bconfirm.setStyle("-fx-background-color: #FF4500; -fx-background-radius: 15;");
 			}

 			
     		 
     	 });
     	 bconfirm.setOnMouseExited(new EventHandler<MouseEvent>() {

  			@Override
  			public void handle(MouseEvent arg0) {
  				// TODO Auto-generated method stub
  				bconfirm.setStyle("-fx-background-color: coral; -fx-background-radius: 15;");
  			}

  			
      		 
      	 });
    }
    @FXML
    void b000Event(ActionEvent event) {

    }

    @FXML
    void b00Event(ActionEvent event) {

    }

    @FXML
    void b0Event(ActionEvent event) {

    }

    @FXML
    void b1Event(ActionEvent event) {

    }

    @FXML
    void b2Event(ActionEvent event) {

    }

    @FXML
    void b3Event(ActionEvent event) {

    }

    @FXML
    void b4Event(ActionEvent event) {

    }

    @FXML
    void b5Event(ActionEvent event) {

    }

    @FXML
    void b6Event(ActionEvent event) {

    }

    @FXML
    void b7Event(ActionEvent event) {

    }

    @FXML
    void b8Event(ActionEvent event) {

    }

    @FXML
    void b9Event(ActionEvent event) {

    }

    @FXML
    void bbackEvent(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("POSMainScene.fxml")); 
    	Scene scene = new Scene(root,700,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		stage = (Stage) bback.getScene().getWindow();
		stage.close();
    }
    
    
    
    @FXML
    void bcEvent(ActionEvent event) {

    }

    @FXML
    void binputEvent(ActionEvent event) {

    }

    @FXML
    void boEvent(ActionEvent event) {

    }

    @FXML
    void confirmEvent(ActionEvent event) throws IOException {
    	if(tablefield.getText().equals("")) {
    		Stage stage = new Stage();
        	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Error.fxml")); 
        	Scene scene = new Scene(root);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		stage.setScene(scene);
    		stage.show();
    	}else {
    		
    		File csvFile = new File("src/application/confirm.csv");
            FileReader fr = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fr);
            
            int count = 0;
        	String[] tempArr;
        	String line = " ";
        	ArrayList<String[]> confirm_csv = new ArrayList<>();
        	while ((line = br.readLine()) != null) {
        		if(count>0) {
        			tempArr = line.split(",");
    	    		confirm_csv.add(tempArr);
        		}
        		count++;
        	}
        	
        	Boolean tableExist = false;
        	String tableNumber = tablefield.getText();
        	int basicCost;
        	for(int i=0; i<confirm_csv.size(); ++i) {
        		if(confirm_csv.get(i)[0].equals(tableNumber)) {
        			tableExist = true;
        			basicCost = Integer.parseInt(confirm_csv.get(i)[1])*Integer.parseInt(confirm_csv.get(i)[2]);
        			break;
        		}
        	}
        	
        	if(!tableExist) {
        		Stage stage = new Stage();
            	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Error2.fxml")); 
            	Scene scene = new Scene(root);
        		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        		stage.setScene(scene);
        		stage.show();
        	}else {
        		POS_LastController pos_lastController = new POS_LastController(this);
        		pos_lastController.showStage();
        	}
    	}
    }

 

    @FXML
    void tableEvent(ActionEvent event) {

    }

}
