package br.com.ufpb.projetoPoo;

public interface InterfaceComUsuario{
	
	public String mostrarMenu();
	public String escolherNivel();
	public String nomeDoJogador();
	public String iniciarJogo();
	public void desenharPalavra(char []qtsLetras);
	public String chutarPalavra();
	public char chutarLetra();

}