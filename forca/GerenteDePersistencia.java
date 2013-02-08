package br.com.ufpb.projetoPoo;

public class GerenteDePersistencia{
	
	PersistenciaInterface persistencia;
	
	public GerenteDePersistencia(){
		persistencia = BancoDeDados.getBanco();
	}
	
	public String getDica(Nivel nivel){
		if( nivel == Nivel.FACIL){
			return persistencia.getPalavraPortugues();
		}else{
			return persistencia.getAudioDaPalavra();
		}
	}
	
	public String getPalavraIngles(){
		return persistencia.getPalavraIngles();
	}
	
	public String getFrase(){
		return persistencia.getFrase();
	}
	
}
