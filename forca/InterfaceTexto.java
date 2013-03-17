import java.util.List;
import java.util.Scanner;

public class InterfaceTexto implements InterfaceComUsuario{
	private Scanner entrada = new Scanner(System.in);

	@Override
	public OpcoesDoJogo mostrarMenu(){
		return null;
	}
	
	@Override
	public String escolherNivel(){
		System.out.println("Digite\n 1 p/ Fácil,\n 2 p/ Difícil");
		return entrada.nextLine();
	}

	@Override
	public String nomeDoJogador(){
		System.out.println("Digite o seu nome");
		return entrada.nextLine();
	}

	public String iniciarJogo(){
		System.out.println("Digite\n 1 p/ dica,\n 2 p/ chutar palavra, \n 3 p/ chutar letra, " +
				"\n 4 p/ próximo desafio, \n 5 p/ sair do jogo");
		return entrada.nextLine();
	}
	
	@Override
	public String chutarPalavra(){
		System.out.println("Digite a palavra");
		return entrada.nextLine();
	}

	@Override
	public char chutarLetra() {
		System.out.println("Digite a letra");
		return entrada.nextLine().charAt(0);
	}

	@Override
	public void imprimirRanking(String dadosDoRanking){
		System.out.println(dadosDoRanking);
		
	}

	@Override
	public void mostrarDica(String dica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarLetrasQueSairam(List<Character> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String alterarNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpcoesDoJogo telaDoJogo(String nomeDoJogador, int pontuacaoDoJogador,
			char[] vetorpalavrasIngles, Nivel nivel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void iniciarCronometro(Nivel nivel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pararCronometro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarInstrucoes(String inst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mensagemFimDeJogo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mensagemDeAcertoupalavra(String frase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mensagemTempoEncerrado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void instrucoes(String instrucoes) {
		// TODO Auto-generated method stub
		
	}

}