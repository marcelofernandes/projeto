package br.com.ufpb.projetoPoo3a;

import java.util.List;

public interface ForcaInterface {
	
	public void criarJogador(String nome);
	public void obterDesafio() throws PalavrasAcabaramException;
	public int verificarLetra(char letra);
	public boolean verificarPalavra(String palavra);
	public List<Jogador> getDadosDoRanking();
	public void sair();

}
