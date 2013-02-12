package br.com.ufpb.projetoPoo;

public class Desafio {
	
	private String palavraIngles;
	private String dica;
	private String frase;
	private String palavraPortugues;
	private char [] vetorPalavrasIngles;
	
	
		
	public Desafio(){
		this("","","");
	}
	
	public Desafio(String palavrasIngles, String dica, String frase){
		this.palavraIngles = palavrasIngles;
		this.dica = dica;
		this.frase = frase;
				
	}
	
	public void setDesafio(){
		
	}
	public String getPalavraIngles() {
		return palavraIngles;
	}
	public void setPalavraIngles(String palavraIngles) {
		this.palavraIngles = palavraIngles;
		this.vetorPalavrasIngles = new char [this.palavraIngles.length()];
		for(int i= 0; i<this.palavraIngles.length(); i++){
			this.vetorPalavrasIngles[i]= '*';
		}
		
	}
	public char[] getVetorpalavrasIngles(){
		return this.vetorPalavrasIngles;
	}
	public String getDica() {
		return this.dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public int verificarLetra(char letra) {
		int contador = 0;
		String palavra = getPalavraIngles(); 
		for(int i= 0 ; i< palavra.length(); i++){
			if(palavra.charAt(i)== letra){
				pintaVetor(i, letra);
				 contador++;
			}
		}
		return  contador;
	}
	
	public void pintaVetor(int indice, char letra){
		vetorPalavrasIngles[indice] = letra;
		
	}


}
