package br.com.ivan;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EnviandoInfoActivity extends Activity {
	
	EditText ednome,edidade;
	Button bt1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ednome = (EditText) findViewById(R.id.editText1);
        edidade = (EditText) findViewById(R.id.editText2);
        
        bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				String nome,idade;
				nome = ednome.getText().toString();
				nome = URLEncoder.encode(nome);
				idade = edidade.getText().toString();
				
				try{
				URL url = new URL("http://10.0.2.2/android/escrever.php?nome="+nome+"&idade="+idade);
					
				InputStream is = url.openStream();
				int i;
				String conteudo = "";
				
				while((i = is.read())!=-1){
					conteudo += ((char)i);
				}
				
				AlertDialog.Builder dialogo = new AlertDialog.Builder(EnviandoInfoActivity.this);
				dialogo.setTitle("Resultado");
				dialogo.setMessage(conteudo);
				dialogo.setNeutralButton("Ok",null);
				dialogo.show();
				}
				catch(Exception e){
					
					AlertDialog.Builder dialogo = new AlertDialog.Builder(EnviandoInfoActivity.this);
					dialogo.setTitle("Erro");
					dialogo.setMessage(e.getMessage());
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();
					
				}
			
			}
        });
        
        
    }
}