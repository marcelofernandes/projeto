package Projeto_de_ayla;

public class ForcaIngles implements ForcaInterface {
	
	private Jogador jogador;
	private Desafio desafio;
	private Ranking ranking;
	private InterfaceDePersistencia gerente;
	
	public ForcaIngles(){
		gerente = GerenteDePersistencia.getGerente();
		ranking = new Ranking();
		desafio = obterDesafio();
	}
	
	public void criarJogador(String nome) {
		this.jogador = new Jogador(nome);
				
	}
	
	public void obterDesafio() {
		this.desafio = new Desafio (gerente.getPalavraIngles(), gerente.getPalavrasPortuges(), gerente.getFrase());
						
	}
		
	public boolean verificarLetra(char letra) {
		String palavra = this.desafio.getPalavraIngles(); 
		for(int i= 0 ; i< palavra.length(); i++){
			if(palavra.charAt(i)== letra){
				return true;
			}
		}
		return false;
	}


	public boolean verificarPalavra(String palavra) {
		return (this.desafio.getPalavraIngles().equals(palavra))
	}

	
	public String imprimirRanking() {
		return rankig.getDadosDoRanking();
	}

	
	public void sair() {
		//TODO
	}

}
