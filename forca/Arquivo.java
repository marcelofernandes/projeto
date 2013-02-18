package br.com.ufpb.projetoPoo3a;

public class Arquivo implements PersistenciaInterface{

	//arquivo de palavras pro desafio inicializando palavras
	private String[] arquivopalavraIngles = {"ball","cat","house","flower"};
	private String[] arquivopalavraPortugues = {"bola","gato","casa","flor"};
	private String[] arquivofrase = {"The ball is small","The cat is smart","The house is big","The flower is yellow"};
	private int controladorDedesafios = 0;
	
	public Arquivo(){
		
	}
	
	public String getPalavraPortugues()throws PalavrasAcabaramException{
		if(controladorDedesafios>=arquivopalavraPortugues.length){
			throw new PalavrasAcabaramException();
		}
		return arquivopalavraPortugues[controladorDedesafios];
		
	}
	
	public String getPalavraIngles()throws PalavrasAcabaramException{
		if(controladorDedesafios>=arquivopalavraIngles.length){
			throw new PalavrasAcabaramException();
		}
		return arquivopalavraIngles [controladorDedesafios];
				
	}

	public String getFrase() throws PalavrasAcabaramException{
		if(controladorDedesafios>=arquivofrase.length){
			throw new PalavrasAcabaramException();
		}
		return  arquivofrase[controladorDedesafios++];
	}

	public String getAudioDaPalavra(){
		return null;
	}

	public String getAudioDaFrase(){
		return null;
	}

}
