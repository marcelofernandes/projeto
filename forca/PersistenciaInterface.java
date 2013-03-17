import java.util.List;



public interface PersistenciaInterface{

	public String getPalavraPortugues()throws PalavrasAcabaramException;
	public String getPalavraIngles()throws PalavrasAcabaramException;
	public String getFrase() throws PalavrasAcabaramException;
	public String getAudioDaPalavra()throws PalavrasAcabaramException;
	public String getAudioDaFrase()throws PalavrasAcabaramException;
	public void fecharConexao();
	public void cadastrarDesafio();
	public void removerDesafio();
	public List<String> carregarNomesDosJogadores();
	public List<Integer> carregarPontuacoesDosJogadores();
	public void salvarRanking(List<String> nomes, List<Integer> pontuacoes);
}
