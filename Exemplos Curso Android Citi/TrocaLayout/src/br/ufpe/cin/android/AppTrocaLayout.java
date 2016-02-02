package br.ufpe.cin.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AppTrocaLayout extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }
    
    public void carregaTelaPrincipal(){
    	setContentView(R.layout.main);
    	Button btnTela1 = (Button) findViewById(R.id.button1);
    	btnTela1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				carregaTelaSecundaria();
			}
        });
    }
    public void carregaTelaSecundaria(){
    	setContentView(R.layout.tela2);
    	Button btnTela2 = (Button) findViewById(R.id.button1);
    		btnTela2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				carregaTelaPrincipal();
			}
        });
    }
}