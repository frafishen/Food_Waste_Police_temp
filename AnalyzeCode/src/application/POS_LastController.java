package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static java.util.Map.entry;  

public class POS_LastController {
	
	@FXML
    private Label txt_basic;

    @FXML
    private Label txt_extra;

    @FXML
    private Label txt_service;

    @FXML
    private Label txt_tableNumber;

    @FXML
    private Label txt_total;
    
    private POS_PaymentController pos_paymentController;
    
    private Stage stage;
    
    private String tableNumber;
    private int basicCost, extraCost;
    private double serviceCost, totalCost;
    
    private Map<String, Integer> Foods = Map.ofEntries(
    	    entry("Bean", 10),
    	    entry("Bitter_Gourd", 20),
    	    entry("Bottle_Gourd", 30),
    	    entry("Brinjal", 40),
    	    entry("Broccoli", 50),
    	    entry("Cabbage", 60),
    	    entry("Capsicum", 70),
    	    entry("Carrot", 8),
    	    entry("Cauliflower", 9),
    	    entry("Cucumber", 10),
    	    entry("Papaya", 11),
    	    entry("Potato", 12),
    	    entry("Pumpkin", 13),
    	    entry("Radish", 14),
    	    entry("Tomato", 15)
    	);
    
    public POS_LastController(POS_PaymentController pos_paymentController) {

    	this.pos_paymentController = pos_paymentController;
    	stage = new Stage();
    	
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("POS_Last.fxml"));
        	loader.setController(this);
			stage.setScene(new Scene(loader.load()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    public void showStage() {
        stage.showAndWait();
    }
    
    private void calBasicCost() throws IOException {
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
    	for(int i=0; i<confirm_csv.size(); ++i) {
    		if(confirm_csv.get(i)[0].equals(tableNumber)) {
    			basicCost = Integer.parseInt(confirm_csv.get(i)[1])*Integer.parseInt(confirm_csv.get(i)[2]);
    			break;
    		}
    	}
    }
    
    private void calExtraCost() throws IOException {
    	File csvFile = new File("src/application/food_recog.csv");
//        FileReader fr = new FileReader(csvFile);
//        BufferedReader br = new BufferedReader(fr);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"UTF8"));
        
        int count = 0;
    	String[] tempArr;
    	String line = " ";
    	ArrayList<String[]> food_csv = new ArrayList<>();
    	while ((line = br.readLine()) != null) {
    		if(count>0) {
    			tempArr = line.split(",");
    			food_csv.add(tempArr);
    		}
    		count++;
    	}
    	for(int i=0; i<food_csv.size(); ++i) {
    		if(food_csv.get(i)[2].equals(tableNumber)) {
    			extraCost = Foods.get(food_csv.get(i)[3].trim());
    			break;
    		}
    	}
        
    }
    
    private void calTotalCost(){
    	totalCost = basicCost + extraCost + serviceCost;
    }
	
	@FXML
    private void initialize() throws IOException{
        System.out.println("POS_LastController initialized!");

        tableNumber = pos_paymentController.getTableNumber();
        txt_tableNumber.setText(txt_tableNumber.getText() + " " + tableNumber);
 
        calBasicCost();
        
        txt_basic.setText(txt_basic.getText() + " " + String.valueOf(basicCost));
    	
        serviceCost = basicCost*0.1;
        txt_service.setText(txt_service.getText() + " " + String.valueOf(String.format("%.1f", serviceCost)));
        
        calExtraCost();
        txt_extra.setText(txt_extra.getText() + " " + String.valueOf(extraCost));
        
        calTotalCost();
        txt_total.setText(txt_total.getText() + " " + String.valueOf(totalCost));
        
    }
}
