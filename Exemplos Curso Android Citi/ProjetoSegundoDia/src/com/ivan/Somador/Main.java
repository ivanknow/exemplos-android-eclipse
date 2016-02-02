package com.ivan.Somador;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {
	EditText e1,e2;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button somar = (Button) findViewById(R.id.button1);
        Button sub = (Button) findViewById(R.id.button2);
        Button mult = (Button) findViewById(R.id.button3);
        Button div = (Button) findViewById(R.id.button4);
        
        e1 =(EditText) findViewById(R.id.editText1);
        e2 =(EditText) findViewById(R.id.editText2);
        somar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			double result,ve1,ve2;
			ve1 = Double.parseDouble(e1.getText().toString());
			ve2 = Double.parseDouble(e2.getText().toString());
			result = ve1+ve2;
			
			AlertDialog.Builder dialogo = new Builder(Main.this);
			dialogo.setTitle("Soma");
			dialogo.setMessage(""+result);
			dialogo.setNeutralButton("Ok",null);
			dialogo.show();
			
			
			}
        });
        
sub.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			double result,ve1,ve2;
			ve1 = Double.parseDouble(e1.getText().toString());
			ve2 = Double.parseDouble(e2.getText().toString());
			result = ve1-ve2;
			
			AlertDialog.Builder dialogo = new Builder(Main.this);
			dialogo.setTitle("Subtração");
			dialogo.setMessage(""+result);
			dialogo.setNeutralButton("Ok",null);
			dialogo.show();
			
			
			}
        });

mult.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
	double result,ve1,ve2;
	ve1 = Double.parseDouble(e1.getText().toString());
	ve2 = Double.parseDouble(e2.getText().toString());
	result = ve1*ve2;
	
	AlertDialog.Builder dialogo = new Builder(Main.this);
	dialogo.setTitle("Multiplicação");
	dialogo.setMessage(""+result);
	dialogo.setNeutralButton("Ok",null);
	dialogo.show();
	
	
	}
});

div.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
	double result,ve1,ve2;
	ve1 = Double.parseDouble(e1.getText().toString());
	ve2 = Double.parseDouble(e2.getText().toString());
	AlertDialog.Builder dialogo = new Builder(Main.this);
	dialogo.setTitle("Divisão");
	
	if(ve2!=0){
	result = ve1/ve2;
	dialogo.setMessage(""+result);
	}else{
		dialogo.setMessage("Divisão por zero");
		
	}
	
	
	
	
	dialogo.setNeutralButton("Ok",null);
	dialogo.show();
	
	
	}
});
        
    }
}