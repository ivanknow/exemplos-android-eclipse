package br.ufrpe.mobile.provamovel.modelo;

public class QuestaoAberta extends Questao {
	
	private String resposta="";

	public QuestaoAberta(String enunciado, Prova prova) {
		super(enunciado, prova);
		
	}
	
	public QuestaoAberta(String enunciado) {
		super(enunciado);
		
	}

	@Override
	public TipoQuestao getTipo() {
		
		return TipoQuestao.Aberta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return super.toString()+"QuestaoAberta [resposta=" + resposta + "]";
	}
	
	

}
