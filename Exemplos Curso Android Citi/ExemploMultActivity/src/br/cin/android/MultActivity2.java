package br.cin.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MultActivity2 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		
		Intent intent = getIntent();
		String nome = intent.getStringExtra("nome");
		Log.v("nome", nome);
	}
}
