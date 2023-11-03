package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class POS_OrderController {
	
	private ArrayList<String> data;
	
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
    private Button b59;

    @FXML
    private Button b6;

    @FXML
    private Button b69;

    @FXML
    private Button b7;

    @FXML
    private Button b79;

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
    private Button bp1;

    @FXML
    private Button bp2;

    @FXML
    private Button bp3;

    @FXML
    private Button bp4;

    @FXML
    private TextField orderfield;

    @FXML
    private TextField phonefield;

    @FXML
    private TextField tablefield;
    
    private int people;
    
    private int price;

    public void initialize() {
    	 orderfield.textProperty().addListener(new ChangeListener<String>(){

  			@Override
  			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
  				// TODO Auto-generated method stub
  				bp4.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
  		    	bp2.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
  		    	bp3.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
  		    	bp1.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
  			}
      		 
      	 });
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
    	 setPeople(0);
    	 setPrice(0);
    	 
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
    void b59Event(ActionEvent event) {
    	b59.setStyle("-fx-background-color: #4682B4; -fx-background-radius: 10;");
    	b69.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	b79.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	setPrice(599);
    }

    @FXML
    void b5Event(ActionEvent event) {

    }

    @FXML
    void b69Event(ActionEvent event) {
    	b69.setStyle("-fx-background-color: #4682B4; -fx-background-radius: 10;");
    	b59.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	b79.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	setPrice(699);
    }

    @FXML
    void b6Event(ActionEvent event) {

    }

    @FXML
    void b79Event(ActionEvent event) {
    	b79.setStyle("-fx-background-color: #4682B4; -fx-background-radius: 10;");
    	b69.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	b59.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	setPrice(799);
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
    void bp1Event(ActionEvent event) {
    	bp1.setStyle("-fx-background-color: #4682B4; -fx-background-radius: 10;");
    	bp2.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp3.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp4.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	setPeople(1);
    }

    @FXML
    void bp2Event(ActionEvent event) {
    	bp2.setStyle("-fx-background-color: #4682B4; -fx-background-radius: 10;");
    	bp1.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp3.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp4.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	setPeople(2);
    }

    @FXML
    void bp3Event(ActionEvent event) {
    	bp3.setStyle("-fx-background-color: #4682B4; -fx-background-radius: 10;");
    	bp2.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp1.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp4.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	setPeople(3);
    }

    @FXML
    void bp4Event(ActionEvent event) {
    	bp4.setStyle("-fx-background-color: #4682B4; -fx-background-radius: 10;");
    	bp2.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp3.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp1.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	setPeople(4);
    }
    
    void setPeople(int x) {
    	people = x;
    }
    
    int getPeople() {
    	return people;
    }
    
    void setPrice(int x) {
    	price = x;
    }
    
    int getPrice() {
    	return price;
    }
    
    @FXML
    void confirmEvent(ActionEvent event) throws IOException {
    	
    	data = new ArrayList<String>();
    	
    	if(!orderfield.getText().equals("")) {
    		setPeople(Integer.parseInt(orderfield.getText()));
    	}
    	File csvFile = new File("src/application/confirm.csv");
    	FileWriter fileWriter = new FileWriter(csvFile,true);
    	data.add(tablefield.getText()+',');
		data.add(String.format("%d,",getPeople()));
		data.add(String.format("%d,",getPrice()));
		data.add(phonefield.getText());
    	if(getPeople()!=0 && getPrice()!=0 && !tablefield.getText().equals("") && !phonefield.getText().equals("")) {
    		for (String data : data) { 
    			fileWriter.write(data.toString());
    		}
    		fileWriter.write("\n");
       		fileWriter.close();
    	}else {
       		Stage stage = new Stage();
        	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Error.fxml")); 
        	Scene scene = new Scene(root);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		stage.setScene(scene);
    		stage.show();
    	}
    }
    
    @FXML
    void ortherEvent(ActionEvent event) {
    	 orderfield.textProperty().addListener(new ChangeListener<String>(){

 			@Override
 			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
 				// TODO Auto-generated method stub
 				bp4.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
 		    	bp2.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
 		    	bp3.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
 		    	bp1.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
 			}
     		 
     	 });
    }
    
   

    @FXML
    void phoneEvent(ActionEvent event) {

    }

    @FXML
    void tableEvent(ActionEvent event) {
    	
    }
    
   
    
    @FXML
    void otherClicked(MouseEvent event) {
    	bp4.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp2.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp3.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    	bp1.setStyle("-fx-background-color: LightBlue; -fx-background-radius: 10;");
    }
    	

}
