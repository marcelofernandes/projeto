package Projeto_de_ayla;

import java.util.Arrays;

public class Ranking {
	  
	int pontos [];


	public Ranking(){
		pontos = new int [4];
	}

	public void pontuacaoJogador(int []pontuacao){
		for(int i=0; i<pontos.length; ++i){
			pontos[i]= pontuacao[i];
		}
	}

	public void PontuacoesOrdenadas(){
		Arrays.sort(pontos,0,pontos.length);
		
	}
	public void imprimnirRanking(){
		PontuacoesOrdenadas();
		System.out.println(Arrays.toString(pontos));
	}


}

