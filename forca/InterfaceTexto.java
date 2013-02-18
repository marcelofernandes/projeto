package br.com.ufpb.projetoPoo3a;
import java.util.List;
import java.util.Scanner;

public class InterfaceTexto implements InterfaceComUsuario{
	
	Scanner entrada = new Scanner(System.in);

	public String mostrarMenu(){
		System.out.println("Digite\n 1 p/ Jogar,\n 2 p/ Instrução,\n 3 p/ Ranking, \n 4 p/ Sair");
		return entrada.nextLine();
	}
	
	public String escolherNivel(){
		System.out.println("Digite\n 1 p/ Fácil,\n 2 p/ Difícil");
		return entrada.nextLine();
	}

	public String nomeDoJogador(){
		System.out.println("Digite o seu nome");
		return entrada.nextLine();
	}

	public String iniciarJogo(){
		System.out.println("Digite\n 1 p/ dica,\n 2 p/ chutar palavra, \n 3 p/ chutar letra, " +
				"\n 4 p/ próximo desafio, \n 5 p/ sair do jogo");
		return entrada.nextLine();
	}
	
	public String chutarPalavra(){
		System.out.println("Digite a palavra");
		return entrada.nextLine();
	}
	
	public void desenharPalavra(char []qtsLetras){
		System.out.println(qtsLetras);
	}

	@Override
	public char chutarLetra() {
		System.out.println("Digite a letra");
		return entrada.nextLine().charAt(0);
	}
	public void imprimirRanking(List<Jogador> lista){
		for(Jogador jogador: lista){
			System.out.println("\nNome: " + jogador.getNome() + "\tPontuação: " + jogador.getPontuacao());
		}
		
	}

}
