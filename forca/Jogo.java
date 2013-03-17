
public class Jogo{

	private ForcaIngles forca;
	private InterfaceComUsuario interfaceComUsuario;
	private OpcoesDoJogo opcao;
	private String instrucoes;
	private boolean continua = true;

	public Jogo(){
		forca = new ForcaIngles();
		interfaceComUsuario = new InterfaceGUI();
		instrucoes = "\n     No f�cil s�o 60 segundos para acertar a palavra.\n" +
			"     No dif�cil s�o 30 segundos para acertar a palavra.\n" +
			"     Se o cron�metro chegar a zero voc� perde o jogo.\n" +
			"     No f�cil a dica � a palavra correspondente em portugu�s.    \n" +
			"     No dificil � executado o audio da palavra.\n" +
			"     Cada letra acertada vale dois pontos.\n" +
			"     Cada palavra acertada vale 10 pontos.\n" +
			"     Voc� pode ver quais as letras j� sa�ram.\n" +
			"     Pode abandonar o desafio atual e ir para o pr�ximo.\n";
	}

	public static void main(String []args) {
		Jogo jogo = new Jogo();
		jogo.iniciarJogo();
	}
	
	public void iniciarJogo(){
		do{
			opcao = interfaceComUsuario.mostrarMenu();
			if(opcao == OpcoesDoJogo.JOGAR){ 
				String nivel = interfaceComUsuario.escolherNivel();
				forca.selecionarNivel(nivel);
				String nome = interfaceComUsuario.nomeDoJogador();
				forca.criarJogador(nome);
				try {
					forca.obterDesafio();
				} catch (PalavrasAcabaramException e) {
					interfaceComUsuario.mensagemFimDeJogo();
					forca.salvarRanking();
					forca.close();
					System.exit(0);
				}
				iniciarjogo();
				continua = true;	
			}
			else if(opcao == OpcoesDoJogo.INSTRUCOES){
				interfaceComUsuario.mostrarInstrucoes(instrucoes);
			}
			else if(opcao == OpcoesDoJogo.RANKING){
				interfaceComUsuario.imprimirRanking(forca.getDadosDoRanking());
			}
			else if(opcao == OpcoesDoJogo.SAIR){
				forca.close();
				continua = false;
			}
			else if(opcao == OpcoesDoJogo.ZERAR_RANKING){
				forca.zerarRanking();
			}
		}while(continua);
		System.exit(0);
	}
	
	public void iniciarjogo(){
		interfaceComUsuario.iniciarCronometro(forca.getNivel());
		do{
			opcao = interfaceComUsuario.telaDoJogo(forca.getNomeDoJogador(), forca.getPontuacaoDoJogador(), forca.getVetorpalavrasIngles(), forca.getNivel());
			if(opcao == OpcoesDoJogo.AJUDA){
				if(forca.getNivel()==Nivel.FACIL){
						interfaceComUsuario.mostrarDica(forca.getDica());
				}else{
						forca.executarAudioDaDica();
				}
			}
			else if(opcao == OpcoesDoJogo.CHUTAR_PALAVRA){
				String nomePalavra = interfaceComUsuario.chutarPalavra();
				boolean acertou = forca.verificarPalavra(nomePalavra);
				if(acertou){
					forca.executarAudioDaFrase();
					interfaceComUsuario.mensagemDeAcertoupalavra(forca.getFrase());
					forca.aumentarPontuacaoPalavra();
					try {
						forca.obterDesafio();
						interfaceComUsuario.iniciarCronometro(forca.getNivel());
					} catch (PalavrasAcabaramException e) {
						interfaceComUsuario.mensagemFimDeJogo();
						forca.salvarRanking();
						forca.close();
						System.exit(0);
					}
				}
			}
			else if(opcao == OpcoesDoJogo.CHUTAR_LETRA){
				char letraPalavra = interfaceComUsuario.chutarLetra();
				int pontuadorDeletras = forca.verificarLetra(letraPalavra);
				if(pontuadorDeletras>0){
					forca.aumentarPontuacaoLetra(pontuadorDeletras); //pontuando por letra
				}
				if(forca.getQtdDeLetrasAcertdas() == forca.getQuantidadeDeEspacos()){
					forca.executarAudioDaFrase();
					interfaceComUsuario.mensagemDeAcertoupalavra(forca.getFrase()); 
					try {
						forca.obterDesafio();
						interfaceComUsuario.iniciarCronometro(forca.getNivel());
					} catch (PalavrasAcabaramException e) {
						interfaceComUsuario.mensagemFimDeJogo();
						forca.salvarRanking();
						forca.close();
						System.exit(0);
					}
				}
			}
			else if(opcao == OpcoesDoJogo.PROXIMO_DESAFIO){
				try {
					forca.obterDesafio();
					interfaceComUsuario.iniciarCronometro(forca.getNivel());
				} catch (PalavrasAcabaramException e) {
					interfaceComUsuario.mensagemFimDeJogo();
					forca.salvarRanking();
					forca.close();
					System.exit(0);
				}
			}
			else if(opcao == OpcoesDoJogo.LETRAS_SAIDAS){
				interfaceComUsuario.mostrarLetrasQueSairam(forca.getLetrasQueSairam());
			}
			else if(opcao == OpcoesDoJogo.SAIR){
				interfaceComUsuario.pararCronometro();
				forca.compararRanking();
				forca.salvarRanking();
				forca.close();
				System.exit(0);
			}
			else if(opcao == OpcoesDoJogo.VOLTAR_PARA_MENU){
				forca.compararRanking();
				forca.salvarRanking();
				continua = false;
			}
			else if(opcao == OpcoesDoJogo.TEMPO_ENCERRADO){
				interfaceComUsuario.pararCronometro();
				interfaceComUsuario.mensagemTempoEncerrado();
				forca.compararRanking();
				forca.salvarRanking();
				continua = false;
			}
			else if(opcao == OpcoesDoJogo.ZERAR_RANKING){
				forca.zerarRanking();
			}
			else if(opcao == OpcoesDoJogo.CADASTRAR_DESAFIO){
				forca.cadastrarNovoDesafio();
			}
			else if(opcao == OpcoesDoJogo.REMOVER_DESAFIO){
				forca.removerDesafio();
			}
			else if(opcao == OpcoesDoJogo.MOSTRAR_INSTRUCOES){
				interfaceComUsuario.instrucoes(instrucoes);
			}
		}while(continua);
	}
}
	