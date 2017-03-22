package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
	
	private List <String> dictionary;
	private int numeroErrori;
	
	public Model(){
		dictionary = new ArrayList <String>();
		numeroErrori = 0;
	}
	
	public void loadDictionary (String language){
		
		dictionary.clear();
		
		String file = "rsc/" + language + ".txt";
		
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

	public String controllaTesto(String testo) {
		
		String ris = "";
		//int j = 0;
		numeroErrori = 0;
		
    	testo = testo.replaceAll(" +", " ");
		
		String[] text = testo.split(" ");
		
		/*for(int i = 0; i<text.length ; i++){
			for(j = 0; j<dictionary.size() ; j++)
				if(text[i].toLowerCase().compareTo(dictionary.get(j).toLowerCase())==0)
					break;
			if(j == dictionary.size()){
				ris += text[i] + "\n";
				numeroErrori ++;
			}
		}*/
		
		for(int i = 0; i<text.length ; i++)
			if(!dictionary.contains(text[i].replaceAll("[ \\p{Punct}]", ""))){
				ris += text[i] + "\n";
				numeroErrori ++;
			}
		
		return ris;
		
	}
	
	public String controlloDicotomico(String testo){
		
		String ris = "";
		
		int j = 0;
		
		numeroErrori = 0;
		
    	testo = testo.replaceAll(" +", " ");
		
		String[] text = testo.split(" ");
		
		Collections.sort(dictionary);
		
		/*
		for(int i = 0 ; i < testo.length() ; i++)
			while(j== 0 || j==dictionary.size()-1)
				if(dictionary.get(j).equals(text[i].replaceAll("[ \\p{Punct}]", "")))
		*/
		return ris;
	}
	
	public int getNumeroErrori(){
		return numeroErrori;
	}

}
