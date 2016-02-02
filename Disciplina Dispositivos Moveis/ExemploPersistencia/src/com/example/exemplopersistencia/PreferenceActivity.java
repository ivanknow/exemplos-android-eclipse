package com.example.exemplopersistencia;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);

		Button salvar = (Button) findViewById(R.id.button1);
		Button mostrar = (Button) findViewById(R.id.button2);

		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				EditText et = (EditText) findViewById(R.id.editText1);

				SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

				SharedPreferences.Editor editor = sharedPref.edit();

				editor.putString(getString(R.string.valor_preference),et.getText().toString());
				
				editor.commit();
				
				et.setText("");
			}
		});

		mostrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
				
				String result = sharedPref.getString(getString(R.string.valor_preference),"");
				
				Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preference, menu);
		return true;
	}

}
