package br.ufrpe.mobile.provamovel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import br.ufrpe.mobile.provamovel.modelo.Prova;
import br.ufrpe.mobile.provamovel.persistencia.ProvaDAO;

public class DetalheProvaActivity extends Activity {

	Prova prova;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhe_prova);

		TextView titulo = (TextView) findViewById(R.id.resultTitulo);
		TextView contador = (TextView) findViewById(R.id.resultTamanho);
		
		Intent intent = getIntent();
		int idProva = intent.getIntExtra("idProva",0);
		

		try{
			
			SQLiteDatabase banco = getApplicationContext().openOrCreateDatabase("bancoProvas",MODE_PRIVATE,null);
			System.out.println(idProva);
			prova = new ProvaDAO(banco).buscarPorId(idProva);
			System.out.println(prova);
			banco.close();
			
			titulo.setText(prova.getTitulo());
			contador.setText(prova.getQuestoes().size()+"");
			

		}catch (Exception e){
			new AlertDialog.Builder(this).setTitle("Erro").setMessage(e.getMessage()).setNeutralButton("Fechar", null).show();
			e.printStackTrace();
	    	
	    }
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalhe_prova, menu);
		return true;
	}
	
	public void fazerProva(View v){
		Intent intent = new Intent(getApplicationContext(),QuestaoActivity.class);
		int provaId = prova.getId();
		
		intent.putExtra("idProva", provaId);
		startActivity(intent);
	}
	
	


}
