package br.ufpe.cin.modelo;

public class ItemLista {
int id;
String titulo;


public ItemLista(int id, String titulo) {
	super();
	this.id = id;
	this.titulo = titulo;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getTitulo() {
	return titulo;
}



public void setTitulo(String titulo) {
	this.titulo = titulo;
}



@Override

public String toString() {
	return "" + titulo + "";
}


	
}
