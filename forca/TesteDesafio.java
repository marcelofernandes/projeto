package br.com.ufpb.projetoPoo;

import static org.junit.Assert.*;
import org.junit.Test;

public class TesteDesafio {
	
	@Test
	public void testaDesafio(){
		Desafio desafio = new Desafio("ingles","dica","frase");
		assertTrue(desafio.getFrase()=="frase");
		assertTrue(desafio.getDica().equals("dica"));
		assertEquals(desafio.getPalavraIngles(),"ingles");
		desafio.setFrase("frase2");
		desafio.setDica("dica2");
		desafio.setPalavraIngles("ingles2");
		assertTrue(desafio.getFrase()=="frase2");
		assertTrue(desafio.getDica().equals("dica2"));
		assertEquals(desafio.getPalavraIngles(),"ingles2");
	}
}
