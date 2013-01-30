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
		
	public boolean chutarLetra(char letra) {
		String recebe = this.desafio.getPalavraIngles(); 
		for(int i= 0 ; i< recebe.length(); i++){
			if(recebe.charAt(i)== letra){
				return true;
			}
		}
		return false;
	}


	public boolean chutarPalavra(String palavra) {
		if(this.desafio.getPalavraIngles().equals(palavra)){
			return true;
		}
		else{
			return false;
		}
	
	}

	
	public Ranking mostrarRanking() {
		
		return null;
	}

	
	public void sair() {
		
		
	}

}
