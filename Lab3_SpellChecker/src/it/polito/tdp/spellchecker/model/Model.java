package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List <String> dictionary;
	
	public Model(){
		dictionary = new ArrayList <String>();
	}
	
	public void loadDictionary (String language){
		
		String file = language + ".txt";
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader (fr);
			String parola = "";
		
			while((parola = br.readLine())!=null){
				dictionary.add(parola);
			}
			
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
		
		
	}

}
