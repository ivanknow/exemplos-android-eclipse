package br.ufpe.cin.android;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class AppDownload extends Activity {
	Button btPegaImg;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btPegaImg = (Button) findViewById(R.id.button1);
        btPegaImg.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				ImageView img =(ImageView) findViewById(R.id.imageView1);
		        
		        try{
		        	URL url = new URL("http://www.lfliborio.com.br/android/php/logo.png");
		        	InputStream is = url.openStream();
		        	Bitmap bmp = BitmapFactory.decodeStream(is);
		        	img.setImageBitmap(bmp);
		        	
		        }
		        catch(Exception e){
		        	AlertDialog.Builder dialogo = new Builder(AppDownload.this);
					dialogo.setTitle("Resultado");
					dialogo.setMessage("Campos não preenchidos");
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();
		        }
			
			}
        });
        
    }
}