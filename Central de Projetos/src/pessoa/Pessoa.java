package pessoa;

public class Pessoa {
	private String cpf;
	private String nome;
	private String email;
	
	public Pessoa(String cpf, String nome, String email) throws Exception {
		if(cpf == null || cpf.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de pessoa. CPF nulo ou vazio");
		}
		
		if(nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de pessoa. ");
		}
		
		if(email == null || email.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de pessoa.");
		}
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	
	
}