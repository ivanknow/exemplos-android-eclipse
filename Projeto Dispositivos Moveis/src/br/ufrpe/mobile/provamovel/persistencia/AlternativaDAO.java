package br.ufrpe.mobile.provamovel.persistencia;

import android.database.sqlite.SQLiteDatabase;
import br.ufrpe.mobile.provamovel.modelo.Alternativa;
import br.ufrpe.mobile.provamovel.modelo.QuestaoFechada;

public class AlternativaDAO extends AbstratctDAO<Alternativa> {

	public AlternativaDAO(SQLiteDatabase banco) {
		super("tb_anternativa",banco);
		String[] colunas = { "id INTEGER PRIMARY KEY AUTOINCREMENT",
				"titulo VARCHAR(255) not null", "id_questao int(4) not null",
				"marcada smallint(1) not null default 0" };
		this.setColumns(colunas);
	}

	@Override
	public void inserir(Alternativa item) {
		String cmd = "INSERT INTO " + getTableName()
				+ " (titulo,id_questao,marcada) values ('" + item.getTitulo()
				+ "','" + item.getQuestao().getId() + "','" + item.getMarcada()
				+ "'); ";
		System.out.println(cmd);
		getBanco().execSQL(cmd);
	}

	@Override
	public void editar(Alternativa item) {
		throw new RuntimeException("Error");

	}

	@Override
	public Alternativa buscarPorId(int id) {
		throw new RuntimeException("Error");
	}

	@Override
	public Alternativa traducao() {
		Alternativa a = new Alternativa();
		a.setId(getDados().getInt(0));
		a.setTitulo(getDados().getString(1));
		a.setQuestao(new QuestaoFechada());
		a.getQuestao().setId(getDados().getInt(2));
		a.setMarcada(getDados().getShort(3));
		return a;
	}

	@Override
	public void createTable() {
		String syso = CreateDatabaseSQLiteUtils.CreateTable(getTableName(),
				getConstreint(), getColumns());
		System.out.println(syso);
		getBanco().execSQL(syso);

	}

}
