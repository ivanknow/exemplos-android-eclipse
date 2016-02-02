package br.ufrpe.mobile.provamovel.persistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import br.ufrpe.mobile.provamovel.modelo.Prova;
import br.ufrpe.mobile.provamovel.modelo.Questao;
import br.ufrpe.mobile.provamovel.modelo.QuestaoAberta;
import br.ufrpe.mobile.provamovel.modelo.QuestaoFechada;

public class ProvaDAO extends AbstratctDAO<Prova> {
	private QuestaoAbertaDAO questaoAbertaDAO;
	private QuestaoFechadaDAO questaoFechadaDAO;

	public ProvaDAO(SQLiteDatabase banco ) {
		super("tb_prova",banco);
		String[] colunas = { "id INTEGER PRIMARY KEY AUTOINCREMENT",
				"titulo VARCHAR(255) not null",
				"nomeProfessor VARCHAR(255) null",
				"matriculaAluno VARCHAR(255) not null" };
		this.setColumns(colunas);
		questaoAbertaDAO = new QuestaoAbertaDAO(banco);
		questaoFechadaDAO = new QuestaoFechadaDAO(banco);

	}

	public QuestaoAbertaDAO getQuestaoAbertaDAO() {
		return questaoAbertaDAO;
	}

	// 480 peido china real

	public void setQuestaoAbertaDAO(QuestaoAbertaDAO questaoAbertaDAO) {
		this.questaoAbertaDAO = questaoAbertaDAO;
	}

	public QuestaoFechadaDAO getQuestaoFechadaDAO() {
		return questaoFechadaDAO;
	}

	public void setQuestaoFechadaDAO(QuestaoFechadaDAO questaoFechadaDAO) {
		this.questaoFechadaDAO = questaoFechadaDAO;
	}

	@Override
	public void inserir(Prova item) {
		String cmd = "INSERT INTO " + getTableName()
				+ " (titulo,nomeProfessor,matriculaAluno) values ('"
				+ item.getTitulo() + "','" + item.getNomeProfessor() + "','"
				+ item.getMatriculaAluno() + "'); ";

		getBanco().execSQL(cmd);
		
		item.setId((int)getLastId());

		
		for (Questao q : item.getQuestoes()) {
			q.setProva(item);
			if (q instanceof QuestaoFechada) {
				questaoFechadaDAO.inserir((QuestaoFechada) q);
			} else {
				questaoAbertaDAO.inserir((QuestaoAberta) q);
			}
		}

	}

	@Override
	public void editar(Prova item) {
		String cmd = "UPDATE " + getTableName() + " SET titulo='"
				+ item.getTitulo() + "',nomeProfessor='"
				+ item.getNomeProfessor() + "',matriculaAluno='"
				+ item.getMatriculaAluno() + "' where id=" + item.getId()
				+ "; ";

		System.out.println(cmd);
		getBanco().execSQL(cmd);

	}

	@Override
	public Prova traducao() {
		Prova p = new Prova();
		p.setId(getDados().getInt(0));
		p.setTitulo(getDados().getString(1));
		p.setNomeProfessor(getDados().getString(2));
		p.setMatriculaAluno(getDados().getString(3));
		
		List<QuestaoAberta> questoesAbertas = questaoAbertaDAO.buscarTodos("id_prova = "+p.getId());
		List<QuestaoFechada> questoesFechadas = questaoFechadaDAO.buscarTodos("id_prova = "+p.getId());
		
		List<Questao> questoes = new ArrayList<Questao>();
		
		questoes.addAll(questoesAbertas);
		questoes.addAll(questoesFechadas);
		Collections.shuffle(questoes);
		
		p.setQuestoes(questoes);
		
		return p;
	}

}
