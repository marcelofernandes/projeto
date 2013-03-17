

public class Jogador implements Comparable <Jogador> {

	private String nome;
	private int pontuacao;
	private int qtdDeLetrasAcertadas;
	
	
	public Jogador(String nome,int pontuacao){
		setNome(nome);
		setPontuacao(pontuacao);
		this.qtdDeLetrasAcertadas = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int getQtdDeLetrasAcertdas(){
		return this.qtdDeLetrasAcertadas;
	}
	
	public void aumentarPontuacaoPalavra(){
		this.pontuacao += 10;
	}
	
	public void aumentarPontuacaoLetra(int qtsDeLetra){
		this.pontuacao += 2*qtsDeLetra;
		this.qtdDeLetrasAcertadas += qtsDeLetra;
	}
	
	@Override
	public int compareTo(Jogador jogador){
		if(this.pontuacao>jogador.pontuacao){
			return 1;
		}
		else if(this.pontuacao == jogador.pontuacao){
			return 0;
		}
		else{
			return -1;
		}
	}
	
	@Override
	public String toString(){
		return this.nome +" "+ this.pontuacao;
		
	}
}
