package br.com.ufpb.projetoPoo3a;

public class GerenteDePersistencia{
	
	PersistenciaInterface persistencia;
	
	public GerenteDePersistencia(){
		persistencia = new Arquivo();
	}
	
	public String getDica(Nivel nivel)throws PalavrasAcabaramException{
		if( nivel == Nivel.FACIL){
			
				return persistencia.getPalavraPortugues();
			
		}else{			
				return persistencia.getPalavraPortugues();
		}
		
	}
	
	public String getPalavraIngles()throws PalavrasAcabaramException {
	
			return persistencia.getPalavraIngles();
	
	}
	
	public String getFrase() throws PalavrasAcabaramException{
		
			return persistencia.getFrase();
		
		}
	
}
