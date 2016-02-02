package br.cin.ufpe.android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;




import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AppCliente extends Activity {
	
	Button btSoma;
	EditText et1,et2;
	double num1,num2;
	String images[] = {"+","-","*","/"};
	Spinner spn;
    /** Called when the activity is first created. */
    
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btSoma = (Button) findViewById(R.id.button1);
        spn = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapterOperacoes = new ArrayAdapter<String>(AppCliente.this,android.R.layout.simple_spinner_item,images );
		spn.setAdapter(adapterOperacoes);
        
        
        btSoma.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			try{
				Socket s = new Socket("10.0.2.2",62);
				DataInputStream in = new DataInputStream(s.getInputStream());
				DataOutputStream out=  new DataOutputStream(s.getOutputStream());
				et1 = (EditText) findViewById(R.id.editText1);
				et2 = (EditText) findViewById(R.id.editText2);
				
				num1 = Double.parseDouble(et1.getText().toString());
				num2 = Double.parseDouble(et2.getText().toString());
				int posicao = spn.getSelectedItemPosition();
				
				out.writeDouble(num1);
				out.writeDouble(num2);
				out.writeInt(posicao);
				
				AlertDialog.Builder dialogo = new AlertDialog.Builder(AppCliente.this);
				dialogo.setTitle("Resultado");
				dialogo.setMessage(in.readDouble()+"");
				dialogo.setNeutralButton("Ok",null);
				dialogo.show();
			}
			catch(IOException e){
				
				
			}
			}
        });
    }
}