import java.util.List;


public class ForcaIngles{
	
	private Jogador jogador;
	private Desafio desafio;
	private Ranking ranking;
	private GerenteDePersistencia gerente;
	private Nivel nivel;
	private GerenteDeAudio gerenteAudio;
	
	public ForcaIngles(){
		gerente = new GerenteDePersistencia();
		gerenteAudio = new GerenteDeAudio();
		this.desafio = new Desafio ();
		this.ranking = new Ranking();
		carregarRanking();
	}
	
	public void criarJogador(String nome) { 
		this.jogador = new Jogador(nome,0);
				
	}
	
	public void obterDesafio()throws PalavrasAcabaramException {
		this.desafio.setDesafio(gerente.getPalavraIngles(),gerente.getDica(nivel), gerente.getFrase(), gerente.getAudioDaFrase())	;							
	}
		
	public int verificarLetra(char letra) {
		return desafio.verificarLetra(letra);
	}
	public char[] getVetorpalavrasIngles(){
		return desafio.getVetorpalavrasIngles();
	}


	public boolean verificarPalavra(String palavraParaVerificar) {
		return this.desafio.verificarPalavra(palavraParaVerificar);
	}

	
	public String getDadosDoRanking() {
		return ranking.getDadosDoRanking();
	}
	
	public List<Character> getLetrasQueSairam(){
		return desafio.getLetrasQueSairam();
	}
	
	public String getPalavra(){
		return desafio.getPalavraIngles();
	}
	
	public String getFrase(){
		return desafio.getFrase();
	}
	
	public String getDica(){
		return desafio.getDica();
	}
	
	public String getAudioDaFrase(){
		return desafio.getAudioDaFrase();
	}
	
	
	public String getNomeDoJogador(){
		return jogador.getNome();
	}
	
	public void setNomeDoJogador(String nome){
		this.jogador.setNome(nome);
	}
	
	
	public void setPontuacao(int pontuacao){
		jogador.setPontuacao(pontuacao);
	}
	public int getPontuacaoDoJogador(){
		return jogador.getPontuacao();
	}
	
	public int getQtdDeLetrasAcertdas(){
		return this.jogador.getQtdDeLetrasAcertdas();
	}
	
	public int getQuantidadeDeEspacos(){
		return desafio.getPalavraIngles().length();
	}

	public void selecionarNivel(String nivel){
		if(nivel.equals("1")){
			this.nivel = Nivel.FACIL;
		}else{
			this.nivel = Nivel.DIFICIL;
		}
	}
	
	public void executarAudioDaDica(){
		gerenteAudio.play("./Palavras/"+getDica()+".mp3");
	}
	
	public void executarAudioDaFrase(){
		gerenteAudio.play("./Frases/"+getAudioDaFrase()+".mp3");
	}
	
<<<<<<< HEAD
	public void aumentarPontuacaoPalavra(){
		jogador.aumentarPontuacaoPalavra();
	}
	public void aumentarPontuacaoLetra(int qtsDeLetra){
		jogador.aumentarPontuacaoLetra(qtsDeLetra);
	}

=======
	public void setPontuacao(int pontuacao){
		jogador.setPontuacao(pontuacao);
	}
	
>>>>>>> f12a9d6f767ada1eda137db99ec0a0e122997f25
	public Nivel getNivel() {
		return nivel;
	}

	public void compararRanking() {
		ranking.compararJogadorComRanking(jogador);
	}
	
	public void zerarRanking(){
		this.ranking.zerarRanking();
	}
	
	public void cadastrarNovoDesafio(){
		gerente.cadastrarDesafio();
	}
	
	public void removerDesafio(){
		gerente.removerDesafio();
	}
	
	public void carregarRanking(){
		ranking.carregarRanking(gerente.carregarNomesDosJogadores(),gerente.carregarPontuacoesDosJogadores());
	}
	public void salvarRanking(){
		gerente.salvarRanking(ranking.getNomesDosJogadores(),ranking.getPontuacoesDosJogadores());
	}
	public void close(){
		gerente.fecharConexao();
	}

}
