package br.com.ufpb.projetoPoo3a;

public interface PersistenciaInterface{

	public String getPalavraPortugues()throws PalavrasAcabaramException;
	public String getPalavraIngles()throws PalavrasAcabaramException;
	public String getFrase() throws PalavrasAcabaramException;
	public String getAudioDaPalavra();
	public String getAudioDaFrase();

}
