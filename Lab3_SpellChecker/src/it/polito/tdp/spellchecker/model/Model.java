package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
	
	private List <String> dictionary;
	
	public Model(){
		dictionary = new ArrayList <String>();
	}
	
	public void loadDictionary (String language){
		
		dictionary.clear();
		
		String file = "rsc/" + language + ".txt";
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader (fr);
			String parola = "";
		
			while((parola = br.readLine())!=null){
				dictionary.add(parola.toLowerCase());
			}
			
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
		
		
	}
	/*
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
		/*
		for(int i = 0; i<text.length ; i++)
			if(!dictionary.contains(text[i].replaceAll("[ \\p{Punct}]", ""))){
				ris += text[i].replaceAll("[ \\p{Punct}]", "") + "\n";
				numeroErrori ++;
			}
		
		return ris;
		
	}*/
	
	public List <RichWord> controllaTesto (String testo){
		
		List <RichWord> ris = new ArrayList <RichWord>();
		
		testo = testo.replaceAll(" +", " ");
		
		String[] text = testo.split(" ");
		
		String temp = "";
		
		for(int i = 0; i<text.length ; i++){
			temp = text[i].toLowerCase().replaceAll("[ \\p{Punct}]", "");
			ris.add(new RichWord (temp));
			if(dictionary.contains(temp))
				ris.get(i).setCorretta(true);
		}
		
		return ris;
	}
	/*
	public String controlloDicotomico(String testo){
		
		String ris = "";
		
		int j = 0;
		
		numeroErrori = 0;
		
    	testo = testo.replaceAll(" +", " ");
		
		String[] text = testo.split(" ");
		
		Collections.sort(dictionary);
		
		int inizio = 0;
		int fine = dictionary.size() - 1;
		boolean trovata = false;
		
		
		for(int i = 0 ; i < text.length ; i++){
			inizio = 0;
			fine = dictionary.size() - 1;
			trovata = false;
			while(fine - inizio >= 1){
				if(fine - inizio == 1){
					if(dictionary.get(inizio).equals(text[i].replaceAll("[ \\p{Punct}]", "")) || dictionary.get(fine).equals(text[i].replaceAll("[ \\p{Punct}]", "")))
						trovata = true;
					break;
					}
				if(dictionary.get((inizio+fine)/2).equals(text[i].replaceAll("[ \\p{Punct}]", ""))){
					trovata = true;
					break; //parola trovata
				}
				if(dictionary.get((inizio+fine)/2).compareTo(text[i].replaceAll("[ \\p{Punct}]", ""))>0)
					fine = (inizio + fine) / 2;
				else
					inizio = (inizio + fine) / 2;
			}
			if(trovata == false){
				ris += text[i].replaceAll("[ \\p{Punct}]", "") + "\n";
				numeroErrori ++;
			}
				
		}
		
		return ris;
	}
	*/
	public List <RichWord> controlloDicotomico(String testo){
		
		List <RichWord> ris = new ArrayList <RichWord>();
		
    	testo = testo.replaceAll(" +", " ");
		
		String[] text = testo.split(" ");
		
		Collections.sort(dictionary);
		
		int inizio = 0;
		int fine = dictionary.size() - 1;
		String temp = "";
		
		for(int i = 0 ; i < text.length ; i++){
			inizio = 0;
			fine = dictionary.size() - 1;
			temp = text[i].replaceAll("[ \\p{Punct}]", "").toLowerCase();
			ris.add(new RichWord(temp));
			while(fine - inizio >= 1){
				if(fine - inizio == 1){
					if(dictionary.get(inizio).equals(temp) || dictionary.get(fine).equals(temp))
						ris.get(i).setCorretta(true);
					break;
					}
				if(dictionary.get((inizio+fine)/2).equals(temp)){
					ris.get(i).setCorretta(true);
					break;
				}
				if(dictionary.get((inizio+fine)/2).compareTo(temp)>0)
					fine = (inizio + fine) / 2;
				else
					inizio = (inizio + fine) / 2;
			}
				
		}
		
		return ris;
	}

}
