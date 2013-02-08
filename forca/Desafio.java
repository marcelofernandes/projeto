package br.com.ufpb.projetoPoo;

public class Desafio {
	
	private String palavraIngles;
	private String dica;
	private String frase;
	private String palavraPortugues;
	private Nivel nivel;
	
		
	public Desafio(){
		this("","","");
	}
	
	public Desafio(String palavrasIngles, String dica, String frase){
		this.palavraIngles = palavrasIngles;
		this.dica = dica;
		this.frase = frase;
		
	}
	
	public void setNivel(int nivel){
		if(nivel==1){
			this.nivel = Nivel.FACIL;
		}else{
			this.nivel = Nivel.DIFICIL;
		}
		
	}	
	public void setDesafio(){
		
	}
	public String getPalavraIngles() {
		return palavraIngles;
	}
	public void setPalavraIngles(String palavraIngles) {
		this.palavraIngles = palavraIngles;
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
	public boolean verificarLetra(char letra) {
		String palavra = getPalavraIngles(); 
		for(int i= 0 ; i< palavra.length(); i++){
			if(palavra.charAt(i)== letra){
				return true;
			}
		}
		return false;
	}


}
