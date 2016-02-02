package br.ufrpe.mobile.provamovel.modelo;

public class ObjetoPersistente {

	private int id=0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ObjetoPersistente(int id) {
		super();
		this.id = id;
	}
	
	public ObjetoPersistente() {
		super();
	}
	
}
