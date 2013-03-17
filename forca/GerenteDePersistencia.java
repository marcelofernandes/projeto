import java.util.List;



public class GerenteDePersistencia{
	
	PersistenciaInterface persistencia;
	
	public GerenteDePersistencia(){
		persistencia = new Arquivo();
	}
	
	public void cadastrarDesafio(){
		persistencia.cadastrarDesafio();
	}
	public void removerDesafio() {
		persistencia.removerDesafio();
		
	}
	public List<String> carregarNomesDosJogadores(){
		return persistencia.carregarNomesDosJogadores();
	}
	public List<Integer> carregarPontuacoesDosJogadores(){
		return persistencia.carregarPontuacoesDosJogadores();
	}
	
	public void salvarRanking(List<String> nomes, List<Integer> pontuacoes){
		persistencia.salvarRanking(nomes, pontuacoes);
	}

	public void fecharConexao(){
		persistencia.fecharConexao();
	}
	
	public String getDica(Nivel nivel)throws PalavrasAcabaramException{
		if( nivel == Nivel.FACIL){
			
				return persistencia.getPalavraPortugues();
			
		}else{			
				return persistencia.getAudioDaPalavra();
		}
		
	}
	
	public String getPalavraIngles()throws PalavrasAcabaramException {
	
			return persistencia.getPalavraIngles();
	
	}
	
	public String getFrase() throws PalavrasAcabaramException{
		
			return persistencia.getFrase();
		
	}
	
	
public String getAudioDaFrase() throws PalavrasAcabaramException{
		
		return persistencia.getAudioDaFrase();
	
	}
	
}
