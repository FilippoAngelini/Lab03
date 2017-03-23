package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola) {
		this.parola = parola;
		this.corretta = false;
	}

	/**
	 * @return the corretta
	 */
	public boolean isCorretta() {
		return corretta;
	}

	/**
	 * @param corretta the corretta to set
	 */
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	/**
	 * @return the parola
	 */
	public String getParola() {
		return parola;
	}
	
	

}
