

import java.util.*;

public class Ranking {
	
	private List <Jogador> jogadoresDoRanking; 
	private int qtdMaximaDeJogadoresNoRanking;
	
	public Ranking(){
		this.jogadoresDoRanking = new ArrayList <Jogador>(); 
		qtdMaximaDeJogadoresNoRanking = 5;
	}
	public void carregarRanking(List<String> nomes, List<Integer> pontuacoes){
		
		for(int i = 0; i<qtdMaximaDeJogadoresNoRanking; i++){
			Jogador jogador = new Jogador(nomes.get(i), pontuacoes.get(i));
			jogadoresDoRanking.add(jogador);
		}
	}
	
	public List<String> getNomesDosJogadores(){
		List<String> nomes = new ArrayList<String>();
		for(Jogador jogador: this.jogadoresDoRanking){
			nomes.add(jogador.getNome());
		}
		return nomes;
	}
	
	public List<Integer> getPontuacoesDosJogadores(){
		List<Integer> pontuacoes = new ArrayList<Integer>();
		for(Jogador jogador: this.jogadoresDoRanking){
			pontuacoes.add(jogador.getPontuacao());
		}
		return pontuacoes;
	}
	
	public void compararJogadorComRanking(Jogador jogador){
		if( jogador.getPontuacao() > jogadoresDoRanking.get(qtdMaximaDeJogadoresNoRanking-1).getPontuacao() ){
			jogadoresDoRanking.remove(qtdMaximaDeJogadoresNoRanking-1);
			jogadoresDoRanking.add(jogador);
			ordenarRanking();
		}
	}
	private void ordenarRanking(){
		Collections.sort(jogadoresDoRanking);
		Collections.reverse(jogadoresDoRanking);
	}
	
	public String getDadosDoRanking(){
		String dados = "\n   ";
		for(int i = 0; i<qtdMaximaDeJogadoresNoRanking; i++){
			Jogador jogador = jogadoresDoRanking.get(i);
			dados = dados + jogador.getNome() +
				"    " + jogador.getPontuacao() + "  \n   ";
		}
		return dados;
	}
	
	public void zerarRanking(){
		for(Jogador jogador: jogadoresDoRanking){
			jogador.setNome("Jogador");
			jogador.setPontuacao(0);
		}
	}
	
		
}
