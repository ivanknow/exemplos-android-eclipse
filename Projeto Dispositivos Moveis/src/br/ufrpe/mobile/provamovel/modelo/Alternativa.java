package br.ufrpe.mobile.provamovel.modelo;


public class Alternativa extends ObjetoPersistente{

	private short marcada;
	private String titulo;
	private QuestaoFechada questao;
	
	public Alternativa() {
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public QuestaoFechada getQuestao() {
		return questao;
	}
	public void setQuestao(QuestaoFechada questao) {
		this.questao = questao;
	}

	public short getMarcada() {
		return marcada;
	}

	public void setMarcada(short marcada) {
		this.marcada = marcada;
	}

	@Override
	public String toString() {
		return "Alternativa [marcada=" + marcada + ", titulo=" + titulo
				+ "]";
	}
	
	
	
	
}
