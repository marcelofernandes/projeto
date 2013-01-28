package Projeto_de_ayla;

import java.util.Arrays;

public class Ranking {
	
	 int pontosDoJogador []; 
	 
	
	public Ranking(){
		this.pontosDoJogador = new int [4]; 
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
