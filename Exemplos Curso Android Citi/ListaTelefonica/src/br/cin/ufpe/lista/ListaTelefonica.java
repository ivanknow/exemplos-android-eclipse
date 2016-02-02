package br.cin.ufpe.lista;



import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ListaTelefonica extends Activity {
    /** Called when the activity is first created. */
	private static ArrayList<String> contatos = new ArrayList<String>(); ;
	
	
	
	ArrayAdapter<String> aContatos;
	ListView lv;
	Button btAdd,btRmv;
	EditText edNome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btAdd = (Button) findViewById(R.id.button1);
       
        edNome = (EditText) findViewById(R.id.editText1);
        
        contatos.add("João");
        contatos.add("José");
        contatos.add("Pedro");
        contatos.add("Paulo");
        
        
        aContatos = new ArrayAdapter<String>(ListaTelefonica.this,android.R.layout.simple_list_item_1,contatos );
        
        lv = (ListView) findViewById(R.id.listView1);
        
        lv.setAdapter(aContatos);
        
        lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
					long arg3) {
				final AlertDialog.Builder dialogo = new Builder(ListaTelefonica.this);
				dialogo.setTitle("Aviso");
				dialogo.setMessage("Tem ceteza que deseja remover o contato?");
				dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						contatos.remove(arg2);
						lv.setAdapter(aContatos);
						final AlertDialog.Builder dialogo2 = new Builder(ListaTelefonica.this);
						dialogo2.setTitle("Aviso");
						dialogo2.setMessage("Removido com sucesso");
						dialogo2.setNeutralButton("OK",null);
						dialogo2.show();
					}
				});
				dialogo.setNeutralButton("Não",null);
	        	dialogo.show();
				
			}
		});
        
btAdd.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(edNome.getText().toString().equals("")){
					AlertDialog.Builder dialogo = new Builder(ListaTelefonica.this);
					dialogo.setTitle("erro");
					dialogo.setMessage("nome vazio");
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();	
				}else{
					contatos.add(edNome.getText().toString());
					lv.setAdapter(aContatos);
					
				}
			
			/*AlertDialog.Builder dialogo = new Builder(ListaTelefonica.this);
			dialogo.setTitle("Subtração");
			dialogo.setMessage(""+result);
			dialogo.setNeutralButton("Ok",null);
			dialogo.show();*/
			
			
			}
        });

    }
}