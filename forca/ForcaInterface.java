package br.com.ufpb.projetoPoo;

import java.util.List;

public interface ForcaInterface {
	
	public void criarJogador(String nome);
	public void obterDesafio();
	public boolean verificarLetra(char letra);
	public boolean verificarPalavra(String palavra);
	public List<Jogador> getDadosDoRanking();
	public void sair();

}
