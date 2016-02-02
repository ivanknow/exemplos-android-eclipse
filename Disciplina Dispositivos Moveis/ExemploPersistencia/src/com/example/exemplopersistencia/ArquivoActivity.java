package com.example.exemplopersistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ArquivoActivity extends Activity {

	static String filename = "myfile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arquivo);

		Button salvar = (Button) findViewById(R.id.button1);
		Button mostrar = (Button) findViewById(R.id.button2);

		salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				EditText et = (EditText) findViewById(R.id.editText1);

				String valor = et.getText().toString();

				FileOutputStream outputStream;

				try {
					outputStream = openFileOutput(filename,
							Context.MODE_PRIVATE);
					outputStream.write(valor.getBytes());
					outputStream.close();
					et.setText("");
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}
		});

		mostrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				try {

					FileInputStream fIn = openFileInput(filename);
					InputStreamReader isr = new InputStreamReader(fIn);
					char[] inputBuffer = new char[100];
					String s = "";
					int charRead;
					while ((charRead = isr.read(inputBuffer)) > 0) {

						String readString = String.copyValueOf(inputBuffer, 0,
								charRead);
						s += readString;
						inputBuffer = new char[100];
					}
					
					Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
					
				} catch (FileNotFoundException e) {
				
					Toast.makeText(getApplicationContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					Toast.makeText(getApplicationContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.arquivo, menu);
		return true;
	}

}
