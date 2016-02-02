package br.cin.ufpe.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Gallery;

public class AppGaleria extends Activity {
	Gallery g1,g2;
	Button bt1,bt2;
	ImageAdapter ia1,ia2;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        g1 = (Gallery) findViewById(R.id.gallery1);
        g2 = (Gallery) findViewById(R.id.gallery2);
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        
        g1.setAdapter(new ImageAdapter(AppGaleria.this));
       
        g2.setAdapter(new ImageAdapter(AppGaleria.this));
        
        ia1 = (ImageAdapter) g1.getAdapter();	
        ia2 = (ImageAdapter) g2.getAdapter();	
        
        bt1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			Integer num =(Integer) ia1.getItem(g1.getSelectedItemPosition());
			int idSelected = num.intValue();
			
			
			ia2.addImagem(idSelected);
			
			g2.setAdapter(ia2);
			
			ia1.removeImagem(g1.getSelectedItemPosition());
			
			g1.setAdapter(ia1);
			}
        });
        
bt2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			Integer num =(Integer) ia2.getItem(g2.getSelectedItemPosition());
			int idSelected = num.intValue();
			
			
			ia1.addImagem(idSelected);
			
			g1.setAdapter(ia1);
			
			ia2.removeImagem(g2.getSelectedItemPosition());
			
			g2.setAdapter(ia2);
			}
        });

       
    }
    
}