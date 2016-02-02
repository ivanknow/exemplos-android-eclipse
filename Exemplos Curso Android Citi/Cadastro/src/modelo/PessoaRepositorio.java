package modelo;

import java.util.ArrayList;

public class PessoaRepositorio {

	private ArrayList<Pessoa> pessoas;

	public PessoaRepositorio() {
		super();
		this.pessoas = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public void add(Pessoa p){
		this.pessoas.add(p);
		
	}
	public void remove(int pos){
		this.pessoas.remove(pos);
		
	}
	
	public int contaReg(){
		
		return pessoas.size();
	}
}
