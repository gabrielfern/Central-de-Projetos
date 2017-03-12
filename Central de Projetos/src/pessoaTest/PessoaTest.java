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
			assertEquals("Erro no cadastro de pessoa: CPF invalido",e.getMessage());
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
			assertEquals("Erro no cadastro de pessoa: Email nulo ou vazio",e.getMessage());
		}
	}	
	
	@Test
	public void settersTest() throws ValidacaoException {
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
	}
	
	@Test
	public void toStringTest() {
		final String FIM_DE_LINHA = System.lineSeparator();
		String string = "Cpf: 222.333.444-55"   + FIM_DE_LINHA +
		        "Nome: Natasha"                 + FIM_DE_LINHA +
		        "Email: natasha@ccc.ufcg.edu.br"+ FIM_DE_LINHA;
		assertEquals(string, p.toString());
	}
}
