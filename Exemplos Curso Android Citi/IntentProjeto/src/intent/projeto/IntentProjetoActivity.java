package intent.projeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class IntentProjetoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button botao = (Button) findViewById(R.id.button1);
        final EditText caixa = (EditText) findViewById(R.id.editText1);
        
        botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("AtividadeTela2");
				String nome = caixa.getText().toString();
				intent.putExtra("nome", nome);
				startActivity(intent);
				
			}
		});
    }
}