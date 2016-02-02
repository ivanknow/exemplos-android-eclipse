package br.ufrpe.mobile.provamovel.modelo;

import java.util.ArrayList;
import java.util.List;

public class Prova extends ObjetoPersistente{

	private String titulo;
	private String nomeProfessor;
	private String matriculaAluno;
	private List<Questao> questoes;

	public Prova() {

		questoes = new ArrayList<Questao>();

	}

	public Prova(String titulo, String nomeProfessor, String nomeAluno) {
		this();

		this.titulo = titulo;
		this.nomeProfessor = nomeProfessor;
		this.matriculaAluno = nomeAluno;

	}

	public Prova(String titulo, String nomeProfessor, String nomeAluno,
			List<Questao> questoes) {
		super();
		this.titulo = titulo;
		this.nomeProfessor = nomeProfessor;
		this.matriculaAluno = nomeAluno;
		this.questoes = questoes;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {

		return getNomeProfessor() + ":" + getTitulo();
	}

}
