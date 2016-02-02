package br.ufpe.cin.ivan.modelo;

public class Pessoa {

	private String nome;
	private String profissao;
	private String idade;
	int idImagem;
	
	
	
	public Pessoa(String nome, String profissao, String idade) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.idade = idade;
		this.idImagem = 0;
	}
	
	public Pessoa(String nome, String profissao, String idade,int idImagem) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.idade = idade;
		this.idImagem = idImagem;
	}
	
	public Pessoa() {
		super();
		
	}
	
	
	public int getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(int idImagem) {
		this.idImagem = idImagem;
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
