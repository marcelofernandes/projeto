package Projeto_de_ayla;

import java.util.*;

public class Ranking {
	
	private List <Jogador> jogadoresDoRanking; 
	private int qtdJogadores;
	
	public Ranking(){
		this.jogadoresDoRanking = new ArrayList <Jogador>(); 
		qtdJogadores = 0;
	}
	
	public void comparaComRanking(Jogador jogador){
		if(qtdJogadores<10){
			jogadoresDoRanking.add(jogador);
			qtdJogadores++;
			Collections.sort(jogadoresDoRanking);
			Collections.reverse(jogadoresDoRanking);
		}else if( jogador.getPontuacao() > jogadoresDoRanking.get(qtdJogadores-1).getPontuacao() ){
			jogadoresDoRanking.remove(qtdJogadores-1);
			jogadoresDoRanking.add(jogador);
			Collections.sort(jogadoresDoRanking);
			Collections.reverse(jogadoresDoRanking);
		}
	}

	public void pontuacaoDoJogador(int []pontuacao){
		for(int i=0; i<pontosDoJogador.length; ++i){
			this.pontosDoJogador[i]= pontuacao[i];
		}
	}

	public void imprimnirRankingOrdenado(){
		Arrays.sort(pontosDoJogador,0,pontosDoJogador.length);
		System.out.println(Arrays.toString(pontosDoJogador));
	}

	
	public int maiorPontuacaoDoJogo(){
		int aux = this.pontosDoJogador[0];
		for(int i=1; i<pontosDoJogador.length; ++i){
			if(aux < pontosDoJogador[i]){
				aux = pontosDoJogador[i];
			}			
		}
		return aux;
	} 

		
}
