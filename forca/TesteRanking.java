package Projeto_de_ayla;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TesteRanking {
	
	Ranking2 ranking = new Ranking2(); 
	
	@Test
	public void TesteRanking(){
		
		//verificando se o vetor está vazio.
		assertEquals(0,ranking.pontosDoJogador[0]);
		assertEquals(0,ranking.pontosDoJogador[3]);
		
		//pontuacao do jogador
		ranking.pontuacaoDoJogador(76);
		ranking.pontuacaoDoJogador(5);
		ranking.pontuacaoDoJogador(1);
		ranking.pontuacaoDoJogador(98);
		
		
		
						
		// verificar se está ordenando o vetor.
		ranking.rankingOrdenado();
		assertEquals(1, ranking.pontosDoJogador[0]);
		assertEquals(5, ranking.pontosDoJogador[1]);
		assertEquals(76, ranking.pontosDoJogador[2]);
		assertEquals(98, ranking.pontosDoJogador[3]);
	
		//testando maior pontuação
		assertEquals(98, ranking.getMaiorPontuacao());
		
		//testando saída do ranking
		int vetor[] = ranking.ranking();
		assertEquals(1, ranking.pontosDoJogador[0]);
		assertEquals(5, ranking.pontosDoJogador[1]);
		assertEquals(76, ranking.pontosDoJogador[2]);
		assertEquals(98, ranking.pontosDoJogador[3]);
		
		
		
		
		
		
		
		
		
	}
	

}
