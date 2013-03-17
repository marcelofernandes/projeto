import java.util.List;

/**
 * Classe fachada para as principais operações do jogo.
 * 
 * @author Marcelo de Melo Fernandes.
 * 
 * @author Leonardo dos Santos Costa.
 * 
 * @author Ahemenson Fernandes Cavalcante.
 *
 */
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
	
	
	/**
	 * Método para criar um jogador.
	 * 
	 *@param nome O nome do jogador a ser criado.
	 * 
	 */
	public void criarJogador(String nome) { 
		this.jogador = new Jogador(nome,0);
				
	}
	
	/**
	 * Método para obter um novo desafio.
	 * 
	 * 
	 * @throws PalavrasAcabaramException Exceção que será lançada caso não existam mais palavras cadastradas.
	 * 
	 */
	public void obterDesafio()throws PalavrasAcabaramException {
		this.desafio.setDesafio(gerente.getPalavraIngles(),gerente.getDica(nivel), gerente.getFrase(), gerente.getAudioDaFrase())	;							
	}
	
	/**
	 * Método para verificar se o jogador acertou a letra.
	 * 
	 * @param letra A letra a ser verificada.
	 * 
	 * @return Retorna a quantidade de letras acertadas.
	 * 
	 */
	public int verificarLetra(char letra) {
		return desafio.verificarLetra(letra);
	}
	public char[] getVetorpalavrasIngles(){
		return desafio.getVetorpalavrasIngles();
	}

	/**
	 * Método para verificar se o jogador acertou a palavra.
	 * 
	 * @param palavraParaVerificar A palavra a ser verificada.
	 * 
	 * @return Retorna true se acertou a palavra e false caso contrário.
	 * 
	 */
	public boolean verificarPalavra(String palavraParaVerificar) {
		return this.desafio.verificarPalavra(palavraParaVerificar);
	}

	/**
	 * Método que retorna os dados do ranking.
	 * 
	 * @return Retorna os dados do ranking.
	 * 
	 */
	public String getDadosDoRanking() {
		return ranking.getDadosDoRanking();
	}
	
	/**
	 * Método para pegar as letras que já foram chutadas.
	 * 
	 * @return Retorna uma lista com as letras que já foram chutadas.
	 * 
	 */
	public List<Character> getLetrasQueSairam(){
		return desafio.getLetrasQueSairam();
	}
	
	/**
	 * Método para pegar a palavra em inglês do desafio atual.
	 * 
	 * @return Retorna a palavra em inglês atual.
	 * 
	 */
	public String getPalavra(){
		return desafio.getPalavraIngles();
	}
	
	/**
	 * Método para pegar a frase do desafio atual.
	 * 
	 * @return Retorna a frase atual do deafio.
	 * 
	 */
	public String getFrase(){
		return desafio.getFrase();
	}
	
	/**
	 * Método para pegar a palavra em português do desafio atual.
	 * 
	 * @return Retorna a palavra em português atual.
	 * 
	 */
	public String getDica(){
		return desafio.getDica();
	}
	
	/**
	 * Método para pegar o nome do arquivo de audio do desafio atual.
	 * 
	 * @return Retorna o nome do arquivo de audio.
	 * 
	 */
	public String getAudioDaFrase(){
		return desafio.getAudioDaFrase();
	}
	
	/**
	 * Método para pegar o nome do jogador atual.
	 * 
	 * @return Retorna o nome do jogador.
	 * 
	 */
	public String getNomeDoJogador(){
		return jogador.getNome();
	}
	
	/**
	 * Método para configurar o nome do jogador atual.
	 * 
	 * @param nome O nome do jogador.
	 * 
	 */
	public void setNomeDoJogador(String nome){
		this.jogador.setNome(nome);
	}
	
	/**
	 * Método para configurar a pontuação do jogador atual.
	 * 
	 * @param pontuacao A pontuaçao do jogador.
	 * 
	 */
	public void setPontuacao(int pontuacao){
		jogador.setPontuacao(pontuacao);
	}
	
	/**
	 * Método para pegar a pontuação do jogador atual.
	 * 
	 * @return Retorna a pontuação do jogador.
	 * 
	 */
	public int getPontuacaoDoJogador(){
		return jogador.getPontuacao();
	}
	
	/**
	 * Método para pegar a quantidade de letras acertadas do jogador atual.
	 * 
	 * @return Retorna A quantidade de letras acertadas pelo jogador.
	 * 
	 */
	public int getQtdDeLetrasAcertdas(){
		return this.jogador.getQtdDeLetrasAcertdas();
	}
	
	/**
	 * Método para pegar a quantidade de espaços da palavra a ser mostrada na tela.
	 * 
	 * @return Retorna a quantidade de espaços da palavra a ser mostrada.
	 * 
	 */
	public int getQuantidadeDeEspacos(){
		return desafio.getPalavraIngles().length();
	}

	/**
	 * Método para configurar o nivel do jogador atual.
	 * 
	 * @param nivel O nível do jogador atual.
	 * 
	 */
	public void selecionarNivel(String nivel){
		if(nivel.equals("1")){
			this.nivel = Nivel.FACIL;
		}else{
			this.nivel = Nivel.DIFICIL;
		}
	}
	
	/**
	 * Método para executar o audio da dica do jogador atual.
	 * 
	 */
	public void executarAudioDaDica(){
		gerenteAudio.play("./Palavras/"+getDica()+".mp3");
	}
	
	/**
	 * Método para executar o audio da frase do jogador atual.
	 * 
	 */
	public void executarAudioDaFrase(){
		gerenteAudio.play("./Frases/"+getAudioDaFrase()+".mp3");
	}
	
	/**
	 * Método para aumentar pontuação caso o jogador acerte uma palavra.
	 * 
	 */
	public void aumentarPontuacaoPalavra(){
		jogador.aumentarPontuacaoPalavra();
	}
	
	/**
	 * Método para aumentar pontuação caso o jogador acerte uma letra.
	 * 
	 * * @param qtsDeLetra A quantidade de letras que acertou.
	 */
	public void aumentarPontuacaoLetra(int qtsDeLetra){
		jogador.aumentarPontuacaoLetra(qtsDeLetra);
	}

	/**
	 * Método para configurar a pontuação do jogador.
	 * 
	 * * @param pontuacao A pontuação do jogador.
	 */
	public void setPontuacao(int pontuacao){
		jogador.setPontuacao(pontuacao);
	}
	
	/**
	 * Método para pegar a o nivel do jogador atual.
	 * 
	 * @return Retorna o nível do jogador.
	 * 
	 */
	public Nivel getNivel() {
		return nivel;
	}

	/**
	 * Método para checar se a pontuação pode ir para o ranking.
	 *
	 */
	public void compararRanking() {
		ranking.compararJogadorComRanking(jogador);
	}
	
	/**
	 * Método para zerar o ranking.
	 * 
	 */
	public void zerarRanking(){
		this.ranking.zerarRanking();
	}
	
	/**
	 * Método para cadastrar um novo desafio.
	 * 
	 */
	public void cadastrarNovoDesafio(){
		gerente.cadastrarDesafio();
	}
	
	/**
	 * Método remover um desafio.
	 * 
	 */
	public void removerDesafio(){
		gerente.removerDesafio();
	}
	
	/**
	 * Método para carregar o ranking do arquivo.
	 * 
	 */
	public void carregarRanking(){
		ranking.carregarRanking(gerente.carregarNomesDosJogadores(),gerente.carregarPontuacoesDosJogadores());
	}
	
	/**
	 * Método para salvar o ranking no arquivo.
	 * 
	 */
	public void salvarRanking(){
		gerente.salvarRanking(ranking.getNomesDosJogadores(),ranking.getPontuacoesDosJogadores());
	}
	
	/**
	 * Método para fechar conexão com banco de dados.
	 * 
	 */
	public void close(){
		gerente.fecharConexao();
	}

}
