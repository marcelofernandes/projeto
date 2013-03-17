import java.util.List;


public interface InterfaceComUsuario{
	
	public OpcoesDoJogo mostrarMenu();
	public String escolherNivel();
	public String nomeDoJogador();
	public String chutarPalavra();
	public char chutarLetra();
	public void imprimirRanking(String dadosDoRanking);
	public void mostrarDica(String dica);
	public void mostrarLetrasQueSairam(List<Character> lista);
	public String alterarNome();
	public OpcoesDoJogo telaDoJogo(String nomeDoJogador, int pontuacaoDoJogador,
			char[] vetorpalavrasIngles, Nivel nivel);
	public void iniciarCronometro(Nivel nivel);
	public void pararCronometro();
	void mostrarInstrucoes(String inst);
	public void mensagemFimDeJogo();
	public void mensagemDeAcertoupalavra(String frase);
	public void mensagemTempoEncerrado();
	public void instrucoes(String instrucoes);
}