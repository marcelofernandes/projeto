package Projeto_de_ayla;
public class PalavrasAcabaramException extends Exception{

	public PalavrasAcabaramException(){
		this("Parab�ns, voc� chegou ao final do jogo!");
	}

	public PalavrasAcabaramException(String mensagem){
		super(mensagem);
	}
}