package br.ufpe.cin.androidappcompra;

import java.util.ArrayList;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class AppSistemaCompras extends Activity {
	CheckBox cb1,cb2,cb3,cb4;
	 ArrayList<CheckBox> cbs = new ArrayList<CheckBox>();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
       
        cbs.add((CheckBox) findViewById(R.id.checkBox1));
        cbs.add((CheckBox) findViewById(R.id.checkBox2));
        cbs.add((CheckBox) findViewById(R.id.checkBox3));
        cbs.add((CheckBox) findViewById(R.id.checkBox4));
        Button bt = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);
        
bt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
					double total = 0;
					String stotal="";
				 for(CheckBox cb:cbs){
					 	if(cb.isChecked()){
					 		String s = cb.getText().toString();
					 		
					 		s = s.replace("(R$","");
					 		s = s.replace(")","");
					 		s = s.replace(",",".");
					 		// stotal += s;
					 		total += Double.parseDouble(s);
					 	}
			        }
		        	AlertDialog.Builder dialogo = new Builder(AppSistemaCompras.this);
					dialogo.setTitle("Soma");
					dialogo.setMessage(""+total);
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();
			}
        });

bt2.setOnClickListener(new OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
			double total = 0;
			String stotal="";
		 for(CheckBox cb:cbs){
			 	if(cb.isChecked()){
			 		String s = cb.getText().toString();
			 		
			 		s = s.replace("(R$","");
			 		s = s.replace(")","");
			 		s = s.replace(",",".");
			 		// stotal += s;
			 		total += Double.parseDouble(s);
			 	}
	        }
		 TextView tv = (TextView) findViewById(R.id.textView1);
		 tv.setText(""+total);
        	
	}
});
        
       
        
    }
}