package br.ufpe.android;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import br.ufpe.modelo.ImageAdapter;


import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;

public class GaleriaOnline extends Activity {
	String conteudo="";
	AlertDialog.Builder dialogo;
	Gallery g;
	ImageAdapter ia = new ImageAdapter(GaleriaOnline.this);
	 ArrayList<Bitmap> bm = new ArrayList<Bitmap>();
	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        g = (Gallery) findViewById(R.id.gallery1);
        Button btAdd = (Button) findViewById(R.id.button1);
        
        btAdd.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			EditText ed = (EditText) findViewById(R.id.editText1);
				String str = ed.getText().toString();
			
				if(!str.equals("")){
					try{
					URL url2 = new URL(str);
					InputStream  is = url2.openStream();
					  Bitmap bmp = BitmapFactory.decodeStream(is);
					  bm.add(bmp);
					  ia.setMinhasImagens(bm);
						 
						 
						 g.setAdapter(ia);
					  }
					catch(Exception e){
						dialogo = new AlertDialog.Builder(GaleriaOnline.this);
						dialogo.setTitle("Erro");
						dialogo.setMessage(e.getMessage());
						dialogo.setNeutralButton("Ok",null);
						dialogo.show();	
						
					}
					
				}
			}
        });
        try{
			URL url = new URL("http://www.lfliborio.com.br/android/php/lista_imagens.php");
				
			InputStream is = url.openStream();
			int i;
			String conteudo = "";
			
			while((i = is.read())!=-1){
				conteudo += ((char)i);
			}
			
			
			
			 
				 
				 String nomes[] = conteudo.split(",");
				
				 
				 for(String nome : nomes){
					
					 try{
						  url = new URL("http://www.lfliborio.com.br/android/php/"+nome);
						  is = url.openStream();
						  Bitmap bmp = BitmapFactory.decodeStream(is);
						  bm.add(bmp);
						  
						}
						catch(Exception e){
							
							dialogo = new AlertDialog.Builder(GaleriaOnline.this);
							dialogo.setTitle("Erro");
							dialogo.setMessage(e.getMessage());
							dialogo.setNeutralButton("Ok",null);
							dialogo.show();
							
						}
					 
				 }
				 
				 ia.setMinhasImagens(bm);
				 
				 
				 g.setAdapter(ia);
				
					
					
				 
			
			
			}
			catch(Exception e){
				
				dialogo = new AlertDialog.Builder(GaleriaOnline.this);
				dialogo.setTitle("Erro");
				dialogo.setMessage(e.getMessage());
				dialogo.setNeutralButton("Ok",null);
				dialogo.show();
				
			}
        
				
    }
}