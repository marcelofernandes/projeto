package br.com.ufpb.projetoPoo3a;

public class Arquivo implements PersistenciaInterface{
	private static final Arquivo arquivos = new Arquivo();
	//arquivo de palavras pro desafio inicializando palavras
	private String[] arquivopalavraIngles = {"ball","cat","house","flower"};
	private String[] arquivopalavraPortugues = {"bola","gato","casa","flor"};
	private String[] arquivofrase = {"bola blá blá blá","gato blá blá blá","casa blá blá blá","flor blá blá blá"};
	private int controladorDedesafios = 0;
	
	private Arquivo(){
		
	}
	public static Arquivo getInstancia(){
		return arquivos;
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