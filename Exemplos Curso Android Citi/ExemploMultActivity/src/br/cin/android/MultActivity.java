package br.cin.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MultActivity extends Activity {
	
	Button b1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1 = (Button) findViewById(R.id.button1);
        
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
				Intent intent = new Intent("atividadeMult2");
				intent.addCategory("categoriaMult2");
				intent.putExtra("nome", "cynthia");
				startActivity(intent);
				
			
			}
        });
        
    }
}