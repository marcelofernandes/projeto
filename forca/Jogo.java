package br.com.ufpb.projetoPoo;

import javax.swing.JOptionPane;

public class Jogo{

	ForcaIngles forca;
	InterfaceComUsuario interfaceComUsuario;
	private String opcao;
	private boolean continua = false;

	public Jogo(){
		forca = new ForcaIngles();
		interfaceComUsuario = new InterfaceTexto();
	}

	public static void main(String ... args){
		Jogo jogo = new Jogo();
		jogo.iniciarJogo();
	}
	
	public void iniciarJogo(){
		String opcao = interfaceComUsuario.mostrarMenu();
		do{
			if(opcao.equals("1")){
				String nome = interfaceComUsuario.nomeDoJogador();
				forca.criarJogador(nome);
				String nivel = interfaceComUsuario.escolherNivel();
				forca.selecionarNivel(nivel);
				telaDjogo();
							
			}
			else if(opcao.equals("2")){
			
			}
			else if(opcao.equals("3")){
				System.out.println("Fim de jogo");
				continua = true;
			}
			
		
		}while(continua != true);		
		
	}
	
	public void telaDjogo(){
	
		do{
			interfaceComUsuario.desenharPalavra(forca.getVetorpalavrasIngles());
			String inicio = interfaceComUsuario.iniciarJogo();
			if(opcao.equals("1")){
				System.out.println(forca.getDica());										
			}
			else if(opcao.equals("2")){
				String nomePalavra = interfaceComUsuario.chutarPalavra();
				boolean acertou = forca.verificarPalavra(nomePalavra);
				if(acertou){
					System.out.println(forca.getPalavra()); // faltando metodo de pontuaçao
					forca.pontuacaoPalavras();
					forca.obterDesafio();
				}
				
				
			}
			else if(opcao.equals("3")){
				char letraPalavra = interfaceComUsuario.chutarLetra();
				int letra = forca.verificarLetra(letraPalavra);
				
					
				
				
			}
			else if(opcao.equals("4")){
				System.out.println("Fim de jogo");
				continua = true;
				
			}
		
		}while(continua!= true);
	}
}