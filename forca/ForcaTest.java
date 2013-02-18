package br.com.ufpb.projetoPoo3a;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ForcaTest {
ForcaIngles f;
	
	@Before
	public void inicializar() {
		try {
			f = new ForcaIngles();
			f.selecionarNivel("1");
			f.obterDesafio();
		} catch (PalavrasAcabaramException e) {
			fail("erro");
		}
	}    
	 
	@After
	public void terminou() {
		f = null;
	}
	 
	@Test
	public void jogadorTest(){
		f.criarJogador("lucas");
		assertEquals("lucas", f.getNomeDoJogador());
		assertTrue(f.getPontuacaoDoJogador()==0);
	}
		
	@Test
	public void getPalavraTest(){		
		assertEquals("ball",f.getPalavra());
	}
	
	@Test
	public void getDicaTest(){		
		assertEquals("bola",f.getDica());
	}
	
	@Test
	public void getFraseTest(){		
		assertEquals("The ball is small",f.getFrase());
	}
	
	@Test
	public void obterDesafioTest(){
		assertEquals("ball",f.getPalavra());
		try {
			f.obterDesafio();
		} catch (PalavrasAcabaramException e) {
			fail("erro");
		}
		assertEquals("cat",f.getPalavra());
	}
	
	@Test
	public void verificaLetraTest(){
		int num = f.verificarLetra('l');
		assertTrue(2==num);			    
	}
	
	@Test
	public void getVetorPalavraTest(){
		char [] aux = f.getVetorpalavrasIngles();
		for(int i = 0; i<aux.length;i++){
			assertEquals(aux[i],'*');
		}
	}
		
	@Test
	public void verificarPalavraTest(){
		assertEquals(f.verificarPalavra("ball"),true);
		assertFalse(f.verificarPalavra("book"));
		
	}
	@Test
	public void nivelTest(){
		f.selecionarNivel("1");
		assertEquals(Nivel.FACIL, f.getNivel());
				
	}
		
	@Test
	public void rankingTest(){
		f.criarJogador("lucas");
		f.setPontuacao(10);
		f.comparaRanking();
		f.criarJogador("ana");
		f.comparaRanking();
		List<Jogador> l= f.getDadosDoRanking();
		assertTrue( l.get(0).getNome().equals("lucas")&& l.get(1).getNome().equals("ana"));
		
	}	
	
	@Test
	public void getNomeDoJogadorTest(){
		f.criarJogador("lucas");
		assertEquals("lucas", f.getNomeDoJogador());	
	}
	
	@Test
	public void getQuantidadeDeEspacosTest(){
		f.criarJogador("lucas");
		assertEquals(4, f.getQuantidadeDeEspacos());	
		assertFalse(f.getQuantidadeDeEspacos()==5);
	}
	
	@Test
	public void getPontuacaoDoJogadorTest(){
		f.criarJogador("lucas");
		assertEquals(0, f.getPontuacaoDoJogador());
				
	}
	
	@Test
	public void selecionarNivelTest(){
		f.criarJogador("lucas");
		f.selecionarNivel("1");
		assertEquals(Nivel.FACIL, f.getNivel());
				
	}
	
	@Test
	public void pontuacaoPalavraTest(){
		f.criarJogador("lucas");
		f.pontuacaoPalavras();
		assertEquals(10, f.getPontuacaoDoJogador());
				
	}
	
	@Test
	public void pontuacaoLetraTest(){
		f.criarJogador("lucas");
		f.pontuacaoLetra(1);
		assertEquals(2, f.getPontuacaoDoJogador());		
	}
	
	@Test
	public void getNivelTest(){
		;
		assertEquals(Nivel.FACIL, f.getNivel());		
	}
}


