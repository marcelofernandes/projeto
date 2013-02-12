package br.com.ufpb.projetoPoo;

import javax.swing.JOptionPane;

public class InterfaceTexto implements InterfaceComUsuario{

	public String mostrarMenu(){
			String opcao = JOptionPane.showInputDialog("Digite\n 1 p/ Jogar,\n 2 p/ Instrução, \n 3 p/ Sair");
			return opcao;
	}
	
	public String escolherNivel(){
		String nivel = JOptionPane.showInputDialog("Digite\n 1 p/ Fácil,\n 2 p/ Díficil");
		return nivel;
	}

	public String nomeDoJogador(){
		String nome = JOptionPane.showInputDialog("Digite o seu nome");
		return nome;
	}

	public String iniciarJogo(){
		String opcao = JOptionPane.showInputDialog("Digite\n 1 p/ dica,\n 2 p/ chutar palavra, \n 3 p/ chutar letra, " +
		"\n 4 p/ proximo desafio ", "\n 5 p/ sair do jogo");
		return opcao;
	}
	public String chutarPalavra(){
		String opcao = JOptionPane.showInputDialog("Digite a palavra");
		return  opcao;
	}
	public void desenharPalavra(char []qtsLetras){
		System.out.println("A palavra é "+ qtsLetras);
	}

	@Override
	public char chutarLetra() {
		char opcao = JOptionPane.showInputDialog("Digite a letra").charAt(0);
		return  opcao;
		
	}


}