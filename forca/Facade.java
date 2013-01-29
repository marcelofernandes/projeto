public class Facade{
  private GerenteDePersistencia gerente;
  
  public Facade(){
    gerente = GerenteDePersistencia.getGerente();
  }
  public Desafio ObterDesafio(){
    return new Desafio(gerente.getPalavraIngles(), gerente.getPalavraPortugues(), gerente.getFrase());
  }
}
