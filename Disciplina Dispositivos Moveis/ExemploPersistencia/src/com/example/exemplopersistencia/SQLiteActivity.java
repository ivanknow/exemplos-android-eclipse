package com.example.exemplopersistencia;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteActivity extends Activity {

	private SQLiteDatabase banco;
	private Cursor dados;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);
		
		try{
	        banco = getApplicationContext().openOrCreateDatabase("bancoNomes",MODE_PRIVATE,null);
	       
	        banco.execSQL("CREATE TABLE if not exists tb_nome (nome VARCHAR(255))");
		       
	        }catch (Exception e){
	        	Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
	        }
		
		Button salvar = (Button) findViewById(R.id.button1);
		Button mostrar = (Button) findViewById(R.id.button2);

		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				EditText et = (EditText) findViewById(R.id.editText1);

				String s = et.getText().toString();
				try{
				banco.execSQL("INSERT INTO tb_nome values ('"+s+"'); ");
				Toast.makeText(getApplicationContext(), "Inserido com sucesso", Toast.LENGTH_SHORT).show();
				}catch(Exception e){
					Toast.makeText(getApplicationContext(), "Deu erro", Toast.LENGTH_SHORT).show();
				}
				
				et.setText("");
			}
		});

		mostrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				dados = banco.query("tb_nome",new String[]{"nome"}, null,null,null,null,null);
	    		
				dados.moveToFirst();
				  		
				String result = dados.getString(dados.getColumnIndex("nome"));
				
				Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sqlite, menu);
		return true;
	}

}
