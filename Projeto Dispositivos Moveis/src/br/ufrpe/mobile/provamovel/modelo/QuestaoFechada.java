package br.ufrpe.mobile.provamovel.modelo;

import java.util.List;

public class QuestaoFechada extends Questao{
	
	private List<Alternativa> alternativas;

	public QuestaoFechada() {
		
	}
	public QuestaoFechada(String enunciado,List<Alternativa> alternativas, Prova prova) {
		super(enunciado, prova);
		
		setAlternativas(alternativas);
		
	}
	
	public QuestaoFechada(String enunciado,List<Alternativa> alternativas) {
		super(enunciado);
		
		setAlternativas(alternativas);
		
	}

	@Override
	public TipoQuestao getTipo() {
		
		return TipoQuestao.Fechada;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		if(alternativas.size()<2){
			new RuntimeException("Não é possivel criar uma pergunta com menos de 2 alternativas");
		}
		
		this.alternativas = alternativas;
	}
	@Override
	public String toString() {
		return super.toString()+"QuestaoFechada [alternativas=" + alternativas + "]";
	}

	
	
	

}
