package Projeto_de_ayla;

public class Desafio {
	
	private String palavraIngles;
	private String palavrasPortugues;
	private String frase;
	
		
	public Desafio(){
		this("","","");
	}
	
	public Desafio(String palavrasIngles, String palavrasPortugues, String frase){
		this.palavraIngles = palavrasIngles;
		this.palavrasPortugues = palavrasPortugues ;
		this.frase = frase;
		
	}
	
	public String getPalavraIngles() {
		return palavraIngles;
	}
	public void setPalavraIngles(String palavraIngles) {
		this.palavraIngles = palavraIngles;
	}
	public String getPalavrasPortugues() {
		return palavrasPortugues;
	}
	public void setPalavrasPortugues(String palavrasPortugues) {
		this.palavrasPortugues = palavrasPortugues;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	

}
