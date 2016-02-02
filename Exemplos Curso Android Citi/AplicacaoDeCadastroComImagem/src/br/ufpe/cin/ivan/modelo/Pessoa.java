package br.ufpe.cin.ivan.modelo;

public class Pessoa {

	private String nome;
	private String profissao;
	private String idade;
	private int imageId;
	
	
	public Pessoa(String nome, String profissao, String idade) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.idade = idade;
		this.imageId = 0;
	}
	public Pessoa(String nome, String profissao, String idade,int imgId) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.idade = idade;
		this.imageId = imgId;
	}
	public Pessoa() {
		super();
		
	}
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
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
