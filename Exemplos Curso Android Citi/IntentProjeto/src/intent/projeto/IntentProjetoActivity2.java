package intent.projeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntentProjetoActivity2 extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		
		TextView texto = (TextView) findViewById(R.id.textViewNome);
		Button tbn = (Button) findViewById(R.id.button1);
		
		tbn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				finish();
			}
		});
		Intent intent2 = getIntent();
		String nome = intent2.getStringExtra("nome");
		Log.v("nome", nome);
		texto.setText(nome);
		
	}

}
