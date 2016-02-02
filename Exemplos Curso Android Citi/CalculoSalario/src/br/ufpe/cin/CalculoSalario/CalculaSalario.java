package br.ufpe.cin.CalculoSalario;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CalculaSalario extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button bt = (Button) findViewById(R.id.button1);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
bt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				//cria alert
				AlertDialog.Builder dialogo = new Builder(CalculaSalario.this);
				dialogo.setTitle("Total");
				dialogo.setNeutralButton("Ok",null);
					
			
				EditText senha = (EditText) findViewById(R.id.editText2);
			if(senha.getText().toString().equals("12345")){//salario está em branco
					
					
				
				
			
			//valores
			double result,porcent=0,salario=0;
			double porcento[] = {40,45,50}; 
		
			
			int total = rg.getChildCount();
			
			
			EditText ed = (EditText) findViewById(R.id.editText1);
			
			if(ed.getText().toString().equals("")){//salario está em branco
				
				dialogo.setMessage("Informe o valor do salário");	
			}
			else{//salario não está em branco
			
			//pega porcentagem
			for(int i=0;i<total;i++){
					if(((RadioButton)rg.getChildAt(i)).isChecked()){
					porcent = porcento[i]; 	
						
					}
					
			}
			//pega salario
			salario = Double.parseDouble(ed.getText().toString());
			
			//calcula total
			result = salario + (salario * (porcent/100)); 
			
			//seta resultado
			dialogo.setMessage("total"+result);
			
			
			
			}
			
			}
			else{
				
				dialogo.setMessage("senha inválida");
			}
			//mostra
			dialogo.show();
			EditText ed = (EditText) findViewById(R.id.editText1);
			RadioButton rb = (RadioButton) findViewById(R.id.radio0);
			ed.setText("");
			rb.setChecked(true);
			}
        });
    }
}