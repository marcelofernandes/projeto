public class Facade{
  private GerenteDePersistencia gerente;
  
  public Facade(){
    gerente = new GerenteDePersistencia();
  }
  public Desafio ObterDesafio(){
    return new Desafio(gerente.getPalavraIngles(), gerente.getPalavraPortugues(), gerente.getFrase());
  }
}
