package br.ufpe.ivan;

import java.io.*;
import java.net.*;





import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AppContent extends Activity {
    /** Called when the activity is first created. */
	Button b1;
	EditText et1,et2;
	int i;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        et1 = (EditText) findViewById(R.id.editText1);
        et1.setText("http://www.lfliborio.com.br/android/php/conteudo.php");
        et2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button1);
        
        	b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				try{
				String strurl = et1.getText().toString();
				
				AlertDialog.Builder dialogo = new AlertDialog.Builder(AppContent.this);
				dialogo.setTitle("Resultado");
				dialogo.setMessage(strurl);
				dialogo.setNeutralButton("Ok",null);
				dialogo.show();
				
				URL url = new URL(strurl);
				
				InputStream is = url.openStream();
				
				
				String conteudo = "";
				
				while((i = is.read())!=-1)
					conteudo += ((char)i);
					
				et2.setText(conteudo);
				
				}
				catch(Exception e){
					et2.setText(e.getMessage());
				}
				
			}});
    }
}