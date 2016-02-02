package br.ufrpe.mobile.provamovel.modelo;

public abstract class Questao extends ObjetoPersistente {

	private int id;
	private String enunciado;
	private Prova prova;

	public Questao() {
		
	}
	public Questao(String enunciado) {
		this.enunciado = enunciado;
		
	}
	public Questao(String enunciado,Prova prova) {
		this.enunciado = enunciado;
		this.prova = prova;
	}
	
	public abstract TipoQuestao getTipo();

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
	@Override
	public String toString() {
		return "Questao [id=" + id + ", enunciado=" + enunciado + "]";
	}
	
	
	
	
	
}