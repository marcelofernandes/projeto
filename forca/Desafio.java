

import java.util.ArrayList;
import java.util.List;

public class Desafio {
	
	private String palavraIngles;
	private String dica;
	private String frase;
	private String audioDaFrase;
	private char [] vetorPalavrasIngles;
	private List<Character> letrasSaidas;
	
	
	public Desafio(){
		this.letrasSaidas = new ArrayList<Character>();
	}
	
	public Desafio(String palavrasIngles,String dica, String frase, String audioFrase){
		this.palavraIngles = palavrasIngles;
		this.dica = dica;
		this.frase = frase;
						
	}
	
	public void setDesafio(String palavrasIngles,String dica, String frase, String audioFrase){
			
			setPalavraIngles(palavrasIngles);
			setDica(dica);
			setFrase(frase);
			setAudioDaFrase(audioFrase);
			letrasSaidas.clear() ;
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
	
	public String getAudioDaFrase() {
		return this.audioDaFrase;
	}
	
	public List<Character> getLetrasQueSairam(){
		return this.letrasSaidas;
	}
	
	public void setAudioDaFrase(String audioDaFrase) {
		this.audioDaFrase = audioDaFrase;
	}
	
	public int verificarLetra(char letra) {
		int contador = 0;
		letra = Character.toUpperCase(letra);
		if(letrasSaidas.contains(letra)){
			return contador; 
		}else{
			String palavra = getPalavraIngles().toUpperCase(); 
			letrasSaidas.add(letra);
			for(int i= 0 ; i< palavra.length(); i++){
				if(palavra.charAt(i)== letra){
					preencheVetor(i, letra);
					contador++;
				}
			
			}
		
		}
		return contador;
	}
	
	public boolean verificarPalavra(String palavraParaVerificar){
		return this.palavraIngles.equalsIgnoreCase(palavraParaVerificar);
	}
	
	public void preencheVetor(int indice, char letra){
		vetorPalavrasIngles[indice] = letra;
		
	}

	


}
