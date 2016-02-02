package br.ufrpe.mobile.provamovel;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import br.ufrpe.mobile.provamovel.modelo.Alternativa;
import br.ufrpe.mobile.provamovel.modelo.Prova;
import br.ufrpe.mobile.provamovel.modelo.Questao;
import br.ufrpe.mobile.provamovel.modelo.QuestaoAberta;
import br.ufrpe.mobile.provamovel.modelo.QuestaoFechada;
import br.ufrpe.mobile.provamovel.persistencia.AlternativaDAO;
import br.ufrpe.mobile.provamovel.persistencia.ProvaDAO;
import br.ufrpe.mobile.provamovel.persistencia.QuestaoAbertaDAO;
import br.ufrpe.mobile.provamovel.persistencia.QuestaoFechadaDAO;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	try{
		apagarTabelas();
		criarTabelas();
		
		
		SQLiteDatabase banco = getApplicationContext().openOrCreateDatabase("bancoProvas",MODE_PRIVATE,null);
		
		Prova prova = carregarProvaFake();
		
		new ProvaDAO(banco).inserir(prova);
		
		banco.close();

	}catch (Exception e){
		new AlertDialog.Builder(this).setTitle("Erro").setMessage(e.getMessage()).setNeutralButton("Close", null).show();
		e.printStackTrace();
    	
    }
		
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void entrar(View v){
		//salva matricula na sessão
		String matricula = ((EditText) findViewById(R.id.etMatricula)).getText().toString();
		Intent intent = new Intent(getApplicationContext(),ListarProvasActivity.class);
	    intent.putExtra("matricula",matricula);
	    startActivity(intent);
		
	}
	
	public void criarTabelas(){
		SQLiteDatabase banco = getApplicationContext().openOrCreateDatabase("bancoProvas",MODE_PRIVATE,null);
		new ProvaDAO(banco).createTable();
		new QuestaoAbertaDAO(banco).createTable();
		new QuestaoFechadaDAO(banco).createTable();
		new AlternativaDAO(banco).createTable();
		banco.close();
		
	}
	
	public void apagarTabelas(){
		SQLiteDatabase banco = getApplicationContext().openOrCreateDatabase("bancoProvas",MODE_PRIVATE,null);
		new ProvaDAO(banco).dropTable();
		new QuestaoAbertaDAO(banco).dropTable();
		new QuestaoFechadaDAO(banco).dropTable();
		new AlternativaDAO(banco).dropTable();
		banco.close();
	}
	
	private Prova carregarProvaFake() {

		List<Questao> questoes = new ArrayList<Questao>();
		questoes.add(new QuestaoAberta("Descreva com suas palavras o que eh Android:"));
		questoes.add(new QuestaoAberta("Quais as desvantagens da plataforma?"));
		
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		Alternativa alt = new Alternativa();
		alt.setTitulo("Sim");

		alternativas.add(alt);
		
		Alternativa alt2 = new Alternativa();
		
		alt2.setTitulo("Nao");
		
		alternativas.add(alt2);
		
		questoes.add(new QuestaoFechada("Existe um componente chamado de Fragment?",alternativas));
		
		Prova prova = new Prova("Prova A","Gilberto","",questoes);
		
		return prova;
	}

}
