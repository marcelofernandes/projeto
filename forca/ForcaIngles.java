package br.com.ufpb.projetoPoo;

import java.util.List;

public class ForcaIngles implements ForcaInterface {
	
	private Jogador jogador;
	private Desafio desafio;
	private Ranking ranking;
	private GerenteDePersistencia gerente;
	private Nivel nivel;
		
	public ForcaIngles(){
		gerente = new GerenteDePersistencia();
		ranking = new Ranking();
		obterDesafio();
		
	}
	
	public void criarJogador(String nome) {
		this.jogador = new Jogador(nome);
				
	}
	
	public void obterDesafio() {
		this.desafio = new Desafio (gerente.getPalavraIngles(), gerente.getDica(nivel), gerente.getFrase());
						
	}
		
	public int verificarLetra(char letra) {
		return desafio.verificarLetra(letra);
	}
	public char[] getVetorpalavrasIngles(){
		return desafio.getVetorpalavrasIngles();
	}


	public boolean verificarPalavra(String palavra) {
		return (this.desafio.getPalavraIngles().equals(palavra));
	}

	
	public List<Jogador> getDadosDoRanking() {
		return ranking.getDadosDoRanking();
	}
	public String getPalavra(){
		return desafio.getPalavraIngles();
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
	public void selecionarNivel(String nivel){
		if(nivel.equals("1")){
			this.nivel = Nivel.FACIL;
		}else{
			this.nivel = Nivel.DIFICIL;
		}
		
		
	}
	
	public void pontuacaoPalavras(){
		jogador.pontuacaoPalavras();
	}
	public void pontuacaoLetra(int qtsDeLetra){
		jogador.pontuacaoLetra(qtsDeLetra);
	}

}
