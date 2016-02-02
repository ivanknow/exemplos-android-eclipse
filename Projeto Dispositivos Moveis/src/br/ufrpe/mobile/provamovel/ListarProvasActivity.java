package br.ufrpe.mobile.provamovel;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.ufrpe.mobile.provamovel.modelo.Prova;
import br.ufrpe.mobile.provamovel.persistencia.ProvaDAO;

public class ListarProvasActivity extends Activity {
	private List<Prova> provas;
	ListView lstProvas;
	ArrayAdapter<Prova> aProvas;
	int indiceProvaAtual=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar_provas);
		
		try{
			
			SQLiteDatabase banco = getApplicationContext().openOrCreateDatabase("bancoProvas",MODE_PRIVATE,null);
			
			provas = new ProvaDAO(banco).buscarTodos();
			
			banco.close();
			

		}catch (Exception e){
			new AlertDialog.Builder(this).setTitle("Erro").setMessage(e.getMessage()).setNeutralButton("Fechar", null).show();
			e.printStackTrace();
	    	
	    }
		
		carregaListaProvas();
		
		Intent intent2 = getIntent();
		String matricula = intent2.getStringExtra("matricula");
		//new AlertDialog.Builder(this).setTitle("OK").setMessage(matricula).setNeutralButton("OK", null).show();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listar_provas, menu);
		return true;
	}
	
	public void carregaListaProvas() {

		lstProvas = (ListView) findViewById(R.id.listView1);

		aProvas = new ArrayAdapter<Prova>(ListarProvasActivity.this,
				android.R.layout.simple_list_item_1, provas);

		lstProvas.setAdapter(aProvas);

		lstProvas.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(getApplicationContext(),DetalheProvaActivity.class);
				int provaId = provas.get(arg2).getId();
				indiceProvaAtual = arg2;
				intent.putExtra("idProva", provaId);
				startActivity(intent);
			}
		});

	}
	
	
}
