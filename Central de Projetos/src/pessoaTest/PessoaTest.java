package pessoaTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecoes.ValidacaoException;
import pessoa.Pessoa;

public class PessoaTest {
	Pessoa p;
	
	@Before
	public void setUp() throws Exception {
		p = new Pessoa("222.333.444-55","Natasha","natasha@ccc.ufcg.edu.br");
	}

	@Test
	public void contructorTest() {
		assertEquals("222.333.444-55",p.getCpf());
		assertEquals("Natasha",p.getNome());
		assertEquals("natasha@ccc.ufcg.edu.br",p.getEmail());
	}
	
	@Test
	public void contructorFailTest() {
		try {
			new Pessoa("222.333.444.555","Natasha","natasha@ccc.ufcg.edu.br");
			fail();
		}
		catch(ValidacaoException e) {
			assertEquals("Erro no cadastro de pessoa: CPF nulo ou vazio",e.getMessage());
		}
		try {
			new Pessoa("222.333.444-55","     ","natasha@ccc.ufcg.edu.br");
			fail();
		}
		catch(ValidacaoException e) {
			assertEquals("Erro no cadastro de pessoa.",e.getMessage());
		}
		try {
			new Pessoa("222.333.444-55","natasha",null);
			fail();
		}
		catch(ValidacaoException e) {
			assertEquals("Erro no cadastro de pessoa.",e.getMessage());
		}
	}	
	
	@Test
	public void settersTest() {
		assertEquals("Natasha",p.getNome());
		p.setNome("Naty");
		assertEquals("Naty",p.getNome());
		
		assertEquals("natasha@ccc.ufcg.edu.br",p.getEmail());
		p.setEmail("naty@ccc.ufcg.edu.br");
		assertEquals("naty@ccc.ufcg.edu.br",p.getEmail());
	}
	
	@Test
	public void hashEqualsTest() throws ValidacaoException {
		Pessoa p2 = new Pessoa("222.333.444-55","Naty","naty@ccc.ufcg.edu.br");
		assertTrue(p.equals(p2));
		
		Pessoa p3 = new Pessoa("222.333.444-56","Natasha","natasha@ccc.ufcg.edu.br");
		assertFalse(p.equals(p3));
		System.out.println(p);
	}	
}