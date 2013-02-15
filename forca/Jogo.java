package br.com.ufpb.projetoPoo3a;

import javax.swing.JOptionPane;

public class Jogo{

	ForcaIngles forca;
	InterfaceComUsuario interfaceComUsuario;
	private String opcao;
	private boolean continua = false;

	public Jogo() throws PalavrasAcabaramException{
		forca = new ForcaIngles();
		interfaceComUsuario = new InterfaceTexto();
	}

	public static void main(String []args) throws PalavrasAcabaramException{
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
			System.out.println("PONTOS ["+forca.getPontuacaoDoJogador()+"] "+" NOME["+forca.getNomeDoJogador()+"]\n");
			interfaceComUsuario.desenharPalavra(forca.getVetorpalavrasIngles());
			String opcao = interfaceComUsuario.iniciarJogo();
			if(opcao.equals("1")){
				System.out.println(forca.getDica());										
			}
			else if(opcao.equals("2")){
				String nomePalavra = interfaceComUsuario.chutarPalavra();
				boolean acertou = forca.verificarPalavra(nomePalavra);
				if(acertou){
					System.out.println("voc� acertou! "+forca.getPalavra()); 
					System.out.println(forca.getFrase());//mostra frase
					forca.pontuacaoPalavras();//pontuando por palavra certa
					try {
						forca.obterDesafio();
					} catch (PalavrasAcabaramException e) {
						// TODO Auto-generated catch block
						System.err.println("Fim!");
						continua = true;
					}
				}
				else{
					System.out.println("voc� errou! "); 
				}
				
			}
			else if(opcao.equals("3")){
				char letraPalavra = interfaceComUsuario.chutarLetra();
				int pontuadorDeletras = forca.verificarLetra(letraPalavra);
				if(pontuadorDeletras>0){// se acertou
					forca.pontuacaoLetra(pontuadorDeletras); //pontuando por letra
				}
				
			}
			else if(opcao.equals("4")){
				try {
					forca.obterDesafio();
				} catch (PalavrasAcabaramException e) {
					// TODO Auto-generated catch block
					System.err.println("Fim!");
					continua = true;
				}
				
				
			}
			
			else if(opcao.equals("5")){
				System.out.println("Fim de jogo");
				continua = true;
				
			}
		
		}while(continua!= true);
	}
}