package br.com.ufpb.projetoPoo;

import javax.swing.JOptionPane;

public class Menu {	
	
	public void mostrarMenu(){
		boolean continua= false;
		String opcao;
		do{
			opcao = JOptionPane.showInputDialog("Digite\n 1 p/ dica,\n 2 p/ chutar palavra, \n 3 p/ chutar letra, " +
					"\n 4 p/ sair do jogo, \n 5 p/ proximo desafio ");
			if(opcao.equals("1")){
				System.out.println("Bem vindo ao jogo");
			}
			else if(opcao.equals("2")){
				
			}
			else if(opcao.equals("3")){
				int nivel = Integer.parseInt(JOptionPane.showInputDialog("Digite\n 1 p/ F�cil,\n 2 p/ D�ficil"));
				//forcaIngles.selecionarNivel(nivel);
				opcao = JOptionPane.showInputDialog("Digite\n 1 p/ Jogar,\n 2 p/ Instru��o, \n 3 p/ Nivel, \n 4 p/ Sair");
			}
			else{
				System.out.println("Fim de jogo");
				continua = true;
			}
			
		}while(continua != true);		
	}
}
