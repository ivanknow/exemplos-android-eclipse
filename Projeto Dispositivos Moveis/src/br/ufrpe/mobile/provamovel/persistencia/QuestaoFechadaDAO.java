package br.ufrpe.mobile.provamovel.persistencia;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import br.ufrpe.mobile.provamovel.modelo.Alternativa;
import br.ufrpe.mobile.provamovel.modelo.Prova;
import br.ufrpe.mobile.provamovel.modelo.QuestaoFechada;

public class QuestaoFechadaDAO extends AbstratctDAO<QuestaoFechada>{

	private AlternativaDAO alternativaDAO;
	
	public QuestaoFechadaDAO(SQLiteDatabase banco ) {
		
		super("tb_questao_fechada",banco);
		String[] colunas = { "id INTEGER PRIMARY KEY AUTOINCREMENT",
				"enunciado VARCHAR(255) not null", "id_prova int(4) not null"
				};
		this.setColumns(colunas);
		alternativaDAO = new AlternativaDAO(banco);
	}

	@Override
	public void inserir(QuestaoFechada item) {
		String cmd = "INSERT INTO " + getTableName()
				+ " (enunciado,id_prova) values ('"
				+ item.getEnunciado() + "','" + item.getProva().getId() + "'); ";
		
		getBanco().execSQL(cmd);
		item.setId((int)getLastId());
		
		for(Alternativa a:item.getAlternativas()){
			a.setQuestao(item);
			alternativaDAO.inserir(a);
		}
		
	}

	@Override
	public void editar(QuestaoFechada item) {
		String cmd = "UPDATE " + getTableName() + " set enunciado='"
				+ item.getEnunciado() + "',id_prova='"
				+ item.getProva().getId() + "' where id = '" + item.getId() + "'; ";
		System.out.println(cmd);
		getBanco().execSQL(cmd);
		
		//busca todos os antigos
		List<Alternativa> result = alternativaDAO.buscarTodos("id_questao = "+item.getId());
		//Apaga antigos
		for(Alternativa a:result){
			
			alternativaDAO.apagar(a);
		}
		//insere novos
		for(Alternativa a:item.getAlternativas()){
			a.setQuestao(item);
			alternativaDAO.inserir(a);
		}
		
	}

	@Override
	public QuestaoFechada traducao() {
		QuestaoFechada qf = new QuestaoFechada();
		qf.setId(getDados().getInt(0));
		qf.setProva(new Prova());
		qf.getProva().setId(getDados().getInt(2));
		
		qf.setAlternativas(alternativaDAO.buscarTodos("id_questao = "+qf.getId()));
		
		return qf;
	}

	public AlternativaDAO getAlternativaDAO() {
		return alternativaDAO;
	}

	public void setAlternativaDAO(AlternativaDAO alternativaDAO) {
		this.alternativaDAO = alternativaDAO;
	}
	
	

}
