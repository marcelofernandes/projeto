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
	public void verificaLetraTest(){
		int num = f.verificarLetra('l'); // retorna um inteiro
		assertTrue(2==num);
		assertEquals("ball",f.getPalavra());
						    
	}
		
	@Test
	public void nivelTest(){
		f.selecionarNivel("1");
		assertEquals(Nivel.FACIL, f.getNivel());
				
	}
		
	@Test
	public void rankingTest(){
		f.criarJogador("lucas");
		f.comparaRanking();
		f.criarJogador("ana");
		f.comparaRanking();
		List<Jogador> l= f.getDadosDoRanking();
		assertTrue( l.get(0).getNome().equals("ana")&& l.get(1).getNome().equals("lucas"));
	}	
}


