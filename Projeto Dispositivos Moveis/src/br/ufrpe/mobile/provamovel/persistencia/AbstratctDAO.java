package br.ufrpe.mobile.provamovel.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.mobile.provamovel.modelo.ObjetoPersistente;
import br.ufrpe.mobile.provamovel.modelo.QuestaoAberta;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class AbstratctDAO<E extends ObjetoPersistente> {

	private SQLiteDatabase banco;
	private Cursor dados;
	private String tableName;
	private String constreint = "";
	private String[] columns;

	public AbstratctDAO(String tableName,SQLiteDatabase banco) {
		this.tableName = tableName;
		this.banco = banco;
	}

	public SQLiteDatabase getBanco() {
		return banco;
	}

	public void setBanco(SQLiteDatabase banco) {
		this.banco = banco;
	}

	public Cursor getDados() {
		return dados;
	}

	public void setDados(Cursor dados) {
		this.dados = dados;
	}

	public String getConstreint() {
		return constreint;
	}

	public void setConstreint(String constreint) {
		this.constreint = constreint;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public abstract void inserir(E item);

	public abstract void editar(E item);

	public void apagar(E item) {
		String cmd = "DELETE from " + getTableName() + " where id = "
				+ item.getId();
		System.out.println(cmd);
		getBanco().execSQL(cmd);

	}

	public List<E> buscarTodos() {
		return buscarTodos(null);
	}

	public List<E> buscarTodos(String Selecao) {
		List<E> resultado = new ArrayList<E>();

		setDados(getBanco().query(tableName, null, Selecao, null, null, null,
				null));

		getDados().moveToFirst();

		int count = getDados().getCount();
		for (int i = 0; i < count; i++) {

			resultado.add(traducao());

			getDados().moveToNext();
		}

		return resultado;
	}

	public E buscarPorId(int id) {
		List<E> lista = buscarTodos("id = " + id);
		if (lista.size() > 0) {
			return lista.get(0);
		}
		return null;
	}

	public abstract E traducao();

	public void createTable() {
		String syso = CreateDatabaseSQLiteUtils.CreateTable(getTableName(),
				getConstreint(), getColumns());
		System.out.println(syso);
		getBanco().execSQL(syso);
		
	}

	public void dropTable() {
		getBanco().execSQL("DROP TABLE IF EXISTS " + getTableName());
	}
	
	public long getLastId(){
		long lastId = 0;
		String query = "SELECT ROWID from "+tableName+" order by ROWID DESC limit 1";
		Cursor c = banco.rawQuery(query, null);
		if (c != null && c.moveToFirst()) {
		    lastId = c.getLong(0);
		}
		
		return lastId;
	}

}
