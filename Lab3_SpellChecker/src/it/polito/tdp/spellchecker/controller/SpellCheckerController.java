/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbLanguage"
    private ComboBox<String> cmbLanguage; // Value injected by FXMLLoader

    @FXML // fx:id="txtInsert"
    private TextArea txtInsert; // Value injected by FXMLLoader

    @FXML // fx:id="btnCheck"
    private Button btnCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="lblNumber"
    private Label lblNumber; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="lblTime"
    private Label lblTime; // Value injected by FXMLLoader

    @FXML
    void doCheck(ActionEvent event) {
    	
    	if(cmbLanguage.getValue() == null)
    		return;
    	
    	if(txtInsert.getText().compareTo("")==0){
    		txtResult.setText("Devi inserire del testo!");
    		return;
    	}
    	
    	/*
    	String testo = txtInsert.getText().replaceAll("[ \\p{Punct}]", " ");
    	testo = txtInsert.getText().replaceAll(" +", " ");
    	*/
    	
    	model.loadDictionary(cmbLanguage.getValue());
    	
    	Long t1 = System.nanoTime();
    	
    	String risultato = model.controllaTesto(txtInsert.getText());
    	
    	Long t2 = System.nanoTime();
    	
    	txtResult.setText(risultato);
    	lblNumber.setText("The text contains " + model.getNumeroErrori() + " errors");
    	lblNumber.setVisible(true);
    	
    	lblTime.setText("Spell check completed in " + ((t2-t1)/1e9) + " seconds");
    	lblTime.setVisible(true);

    }

    @FXML
    void doClear(ActionEvent event) {
    	
    	txtInsert.clear();
    	txtResult.clear();
    	lblNumber.setVisible(false);
    	lblTime.setVisible(false);

    }
    
    public void setModel(Model model){
    	this.model = model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblNumber != null : "fx:id=\"lblNumber\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        cmbLanguage.getItems().addAll("English","Italian");
        if(cmbLanguage.getItems().size() > 0)
        	cmbLanguage.setValue(cmbLanguage.getItems().get(0));
        lblNumber.setVisible(false);
    	lblTime.setVisible(false);
    }
}
