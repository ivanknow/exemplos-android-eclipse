package br.citi.android;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculaSalario extends Activity {
    /** Called when the activity is first created. */
	private static final String[] cargo = {
		"Pião",
		"Gerente",
		"Chefe"
	    
    };
	private static final String[] percentual1 = {
		"De 10%",
		"De 16%",
		"De 20%"
	    
    };
	private static final String[] percentual2 = {
		"De 30%",
		"De 36%",
		"De 40%"
	    
    };
	private static final String[] percentual3 = {
		"De 50%",
		"De 56%",
		"De 60%"
	    
    };
	ArrayAdapter<String> aCargos;
	ArrayAdapter<String> aPercentual1;
	ArrayAdapter<String> aPercentual2;
	ArrayAdapter<String> aPercentual3;
	Spinner spnSal,spnCargo;
	@Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        aPercentual1 = new ArrayAdapter<String>(CalculaSalario.this,android.R.layout.simple_spinner_item,percentual1 );
        aPercentual2 = new ArrayAdapter<String>(CalculaSalario.this,android.R.layout.simple_spinner_item,percentual2 );
        aPercentual3 = new ArrayAdapter<String>(CalculaSalario.this,android.R.layout.simple_spinner_item,percentual3 );
        aCargos = new ArrayAdapter<String> (CalculaSalario.this,android.R.layout.simple_spinner_item,cargo );
        spnSal =(Spinner) findViewById(R.id.spinner1);
        spnCargo = (Spinner) findViewById(R.id.spinner2);
        spnCargo.setAdapter(aCargos);
        spnSal.setAdapter(aPercentual1);
        
        spnCargo.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				if(arg2==0){
					spnSal.setAdapter(aPercentual1);
				}
				if(arg2==1){
					spnSal.setAdapter(aPercentual2);
				}
				if(arg2==2){
					spnSal.setAdapter(aPercentual3);
				}
				
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        spnSal.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			String s = 	spnSal.getItemAtPosition(arg2).toString();
			//cria alert
			EditText t = (EditText) findViewById(R.id.editText1);	
				t.setText(s);
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }
}