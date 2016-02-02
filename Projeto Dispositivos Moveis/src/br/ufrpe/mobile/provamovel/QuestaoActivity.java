package br.ufrpe.mobile.provamovel;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import br.ufrpe.mobile.provamovel.modelo.Prova;
import br.ufrpe.mobile.provamovel.modelo.Questao;
import br.ufrpe.mobile.provamovel.modelo.QuestaoAberta;
import br.ufrpe.mobile.provamovel.modelo.QuestaoFechada;
import br.ufrpe.mobile.provamovel.persistencia.ProvaDAO;
import br.ufrpe.mobile.provamovel.persistencia.QuestaoAbertaDAO;
import br.ufrpe.mobile.provamovel.persistencia.QuestaoFechadaDAO;

public class QuestaoActivity extends FragmentActivity {
private Prova prova;
private int indiceQuestao = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questao);
		
		Intent intent = getIntent();
		int idProva = intent.getIntExtra("idProva",0);
		

		try{
			
			SQLiteDatabase banco = getApplicationContext().openOrCreateDatabase("bancoProvas",MODE_PRIVATE,null);
			System.out.println(idProva);
			prova = new ProvaDAO(banco).buscarPorId(idProva);
			
			banco.close();

			loadQuestao(prova.getQuestoes().get(indiceQuestao));

		}catch (Exception e){
			new AlertDialog.Builder(this).setTitle("Erro").setMessage(e.getMessage()).setNeutralButton("Fechar", null).show();
			e.printStackTrace();
	    	
	    }

		/*
		 * FragmentManager manager = getSupportFragmentManager(); Fragment
		 * fragment = manager.findFragmentById(R.id.frame_conteiner);
		 * 
		 * if (fragment == null) { fragment = new QuestaoAbertaFragment();
		 * manager.beginTransaction().add(R.id.frame_conteiner, fragment)
		 * .commit(); }
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questao, menu);
		return true;
	}

	public void loadQuestao(Questao q) {

		FragmentManager manager = getSupportFragmentManager();
		Fragment fragment = manager.findFragmentById(R.id.frame_conteiner);
		if(fragment!=null){
		manager.beginTransaction().remove(fragment).commit();
		}
		if (q instanceof QuestaoAberta) {
			
			fragment = new QuestaoAbertaFragment();
			QuestaoAbertaFragment qfragment = (QuestaoAbertaFragment) fragment;
			
			qfragment.loadQuestaoNaTela(prova.getQuestoes().get(indiceQuestao));
			
			manager.beginTransaction().add(R.id.frame_conteiner, fragment)
					.commit();
		} else {
			fragment = new QuestaoFechadaFragment();
			
			QuestaoFechadaFragment qfragment = (QuestaoFechadaFragment) fragment;
			
			qfragment.loadQuestaoNaTela(prova.getQuestoes().get(indiceQuestao));
			
			manager.beginTransaction().add(R.id.frame_conteiner, fragment)
					.commit();
		}

	}
	
	public void anterior(View v){
		
		if(indiceQuestao>0){
			salvaEstadoAtualQuestao(prova.getQuestoes().get(indiceQuestao));
			
			indiceQuestao--;
			
			loadQuestao(prova.getQuestoes().get(indiceQuestao));
		}
		
	}
	public void proximo(View v){
		
		if(indiceQuestao<prova.getQuestoes().size()){
			
			salvaEstadoAtualQuestao(prova.getQuestoes().get(indiceQuestao));
			if(indiceQuestao<prova.getQuestoes().size()-1){
			indiceQuestao++;
			}
			loadQuestao(prova.getQuestoes().get(indiceQuestao));
		}
	}
	
	private void salvaEstadoAtualQuestao(Questao q){
		
		FragmentManager manager = getSupportFragmentManager();
		Fragment fragment = manager.findFragmentById(R.id.frame_conteiner);
		if(fragment!=null){
		manager.beginTransaction().remove(fragment).commit();
		}
		if (q instanceof QuestaoAberta) {
			QuestaoAbertaFragment qfragment = (QuestaoAbertaFragment) fragment;
			qfragment.atualizarQuestao();
		}else{
			QuestaoFechadaFragment qfragment = (QuestaoFechadaFragment) fragment;
			qfragment.atualizarQuestao();
		}
		
		SQLiteDatabase banco = getApplicationContext().openOrCreateDatabase("bancoProvas",MODE_PRIVATE,null);
		if (q instanceof QuestaoAberta) {
			new QuestaoAbertaDAO(banco).editar((QuestaoAberta)q);
		}
		else{
			new QuestaoFechadaDAO(banco).editar((QuestaoFechada)q);
		}
		banco.close();
	}

}
