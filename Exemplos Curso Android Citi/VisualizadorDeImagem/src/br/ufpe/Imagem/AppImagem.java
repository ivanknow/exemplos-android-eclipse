package br.ufpe.Imagem;





import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class AppImagem extends Activity {
	String images[] = {"Imagem1","Imagem2","Imagem3","Imagem4","Imagem5"};
	Spinner spnImg;
	ImageView img;
	TextView ed;
	EditText edit;
	Button rename;
	
	ArrayAdapter<String> aImage;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
       
        edit = (EditText) findViewById(R.id.editText1);
        spnImg = (Spinner) findViewById(R.id.spinner1);
        img = (ImageView) findViewById(R.id.imageView1);
        ed = (TextView) findViewById(R.id.textView1);
        aImage = new ArrayAdapter<String>(AppImagem.this,android.R.layout.simple_spinner_item,images );
        spnImg.setAdapter(aImage);
        ed.setText(images[0]);
        
        rename = (Button) findViewById(R.id.button1);
        spnImg.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				ed.setText(images[arg2]);
				switch(arg2){
				case 0:
					img.setImageResource(R.drawable.coala);
					
					break;
				case 1:
					img.setImageResource(R.drawable.farol);
					
					break;
				case 2:
					img.setImageResource(R.drawable.penguins);
					
					break;
				case 3:
					
					img.setImageResource(R.drawable.tulips);
					break;
				case 4:
					
					img.setImageResource(R.drawable.desert);
					break;
				}
				
				
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
rename.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				AlertDialog.Builder dialogo = new Builder(AppImagem.this);
				
				dialogo.setNeutralButton("Ok",null);
				
				if(edit.getText().toString().equals("")){
					dialogo.setTitle("Erro");
					dialogo.setMessage("Nome em branco");
				}
				else{
					images[spnImg.getSelectedItemPosition()] = edit.getText().toString();
					 aImage = new ArrayAdapter<String>(AppImagem.this,android.R.layout.simple_spinner_item,images );
				     spnImg.setAdapter(aImage);
					dialogo.setTitle("Editando");
					dialogo.setMessage("Editado com sucesso!");
					
				}
				dialogo.show();
			}
        });
      
    }
}