package br.cin.ufpe.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;

public class AppGaleria extends Activity {
	Gallery g,g2;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        g = (Gallery) findViewById(R.id.gallery1);
        g.setAdapter(new ImageAdapter(AppGaleria.this));
        g2 = (Gallery) findViewById(R.id.gallery2);
        g2.setAdapter(new ImageAdapter(AppGaleria.this));
       
    }
}