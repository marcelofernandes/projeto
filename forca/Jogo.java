package Projeto_de_ayla;

public class Jogo{

	ForcaIngles forca;
	InterfaceComUsuario interfaceComUsuario;

	public Jogo(){
		forca = new ForcaIngles();
		interfaceComUsuario = new InterfaceTexto();
	}

	public static void main(String ... args){
		Jogo jogo = new Jogo();
		jogo.iniciar();
	}
	
	public void iniciar(){
		interfaceComUsuario.mostrarMenu();
		interfaceComUsuario.escolherNivel();
		interfaceComUsuario.nomeDoJogador();
		interfaceComUsuario.iniciarJogo();
	}
}