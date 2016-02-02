package br.ufrpe.mobile.provamovel.persistencia;

import android.database.sqlite.SQLiteDatabase;
import br.ufrpe.mobile.provamovel.modelo.Prova;
import br.ufrpe.mobile.provamovel.modelo.QuestaoAberta;

public class QuestaoAbertaDAO extends AbstratctDAO<QuestaoAberta> {

	public QuestaoAbertaDAO(SQLiteDatabase banco ) {
		super("tb_questao_aberta",banco);
		String[] colunas = { "id INTEGER PRIMARY KEY AUTOINCREMENT",
				"enunciado VARCHAR(255) not null", "id_prova int(4) not null",
				"resposta varchar(255) not null default ''" };
		this.setColumns(colunas);
	}

	@Override
	public void inserir(QuestaoAberta item) {
		String cmd = "INSERT INTO " + getTableName()
				+ " (enunciado,id_prova,resposta) values ('"
				+ item.getEnunciado() + "','" + item.getProva().getId() + "','"
				+ item.getResposta() + "'); ";
		System.out.println(cmd);
		getBanco().execSQL(cmd);

	}

	@Override
	public void editar(QuestaoAberta item) {
		String cmd = "UPDATE " + getTableName() + " set enunciado='"
				+ item.getEnunciado() + "',id_prova='"
				+ item.getProva().getId() + "',resposta='" + item.getResposta()
				+ "' where id = '" + item.getId() + "'; ";
		System.out.println(cmd);
		getBanco().execSQL(cmd);

	}

	@Override
	public QuestaoAberta traducao() {
		QuestaoAberta qa = new QuestaoAberta(getDados().getString(1));
		qa.setId(getDados().getInt(0));
		qa.setProva(new Prova());
		qa.getProva().setId(getDados().getInt(2));
		qa.setResposta(getDados().getString(3));
		return qa;
	}

}
