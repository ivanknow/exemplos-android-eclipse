package br.ufpe.cin;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AppDadosRemotos extends Activity {
	Button btnSinc;
	EditText etRetorno;
	ProgressDialog p;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnSinc = (Button) findViewById(R.id.button1);

		btnSinc.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				p = ProgressDialog.show(AppDadosRemotos.this, "baixando", "aguarde");
				try{
					
					URL url = new URL("http://www.lfliborio.com.br/android/php/qtde_pessoas.php");
					InputStream is = url.openStream();
					int i;
					String conteudo = "";
					String conteudo2 = "";
					String conteudo3 = "";
					while((i = is.read())!=-1){
						conteudo += ((char)i);
					}

					int qtd = Integer.parseInt(conteudo);



									int j = 0;
									while(j<qtd){
									url = new URL("http://www.lfliborio.com.br/android/php/get_pessoa.php?id="+j);
									is = url.openStream();
									while((i = is.read())!=-1){
										conteudo3 += ((char)i);
									}
									conteudo2 += "["+conteudo3+"]";
									j++;
									}

					etRetorno = (EditText)findViewById(R.id.editText1);
					etRetorno.setText(conteudo2);

					
				}
				catch(Exception e){


					etRetorno = (EditText)findViewById(R.id.editText1);
					etRetorno.setText(e.getMessage());
				}
				p.cancel();
			}
		});


	}
}