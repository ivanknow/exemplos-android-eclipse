package modelo;

public class Pessoa {

	private String nome;
	private String profissao;
	private String idade;
	
	
	
	public Pessoa(String nome, String profissao, String idade) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.idade = idade;
		
	}
	
	public Pessoa() {
		super();
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	
}
