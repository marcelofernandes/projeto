package br.com.ufpb.projetoPoo;

import java.util.List;

public class ForcaIngles implements ForcaInterface {
	
	private Jogador jogador;
	private Desafio desafio;
	private Ranking ranking;
	private GerenteDePersistencia gerente;
		
	public ForcaIngles(){
		gerente = new GerenteDePersistencia();
		ranking = new Ranking();
		obterDesafio();
		
	}
	
	public void criarJogador(String nome) {
		this.jogador = new Jogador(nome);
				
	}
	
	public void obterDesafio() {
		this.desafio = new Desafio (gerente.getPalavraIngles(), gerente.getPalavrasPortuges(), gerente.getFrase());
						
	}
		
	public boolean verificarLetra(char letra) {
		return desafio.verificarLetra(letra);
	}


	public boolean verificarPalavra(String palavra) {
		return (this.desafio.getPalavraIngles().equals(palavra));
	}

	
	public List<Jogador> getDadosDoRanking() {
		return ranking.getDadosDoRanking();
	}
	
	public String getDica(){
		return desafio.getDica();
	}
	
	public String getNomeDoJogador(){
		return jogador.getNome();
	}
	
	public int getPontuacaoDoJogador(){
		return jogador.getPontuacao();
	}
	
	public int getQuantidadeDeEspacos(){
		return desafio.getPalavraIngles().length();
	}

	public void iniciar(){
		//TODO
	}
	public void sair() {
		//TODO
	}
	public void selecionarNivel(int nivel){
		desafio.setDesafio(nivel);
		
		
	}

}
