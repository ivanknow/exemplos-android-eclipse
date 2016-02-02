package br.ufpe.citi.android;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {
	Button btnTelaCadastrar,btnTelaBuscar,
	btnCancelCadastrar,btnCadastrarGo,
	btnBuscaCalcel,btnBuscaGo;
	
	EditText edNome,edIdade,edProf,edBusca;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telaPrincipal();
    }
    
    public void telaPrincipal(){
    	setContentView(R.layout.main);
    	btnTelaCadastrar = (Button) findViewById(R.id.btnTelaCadastrar);
    	btnTelaBuscar = (Button) findViewById(R.id.btnTelaBuscar);
    	btnTelaCadastrar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				telaCadastro();
			
			}
        });
    	
    	btnTelaBuscar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				telaBuscar();
			
			}
        });
    	
    	
    	
    }
    
    public void telaCadastro(){
    	setContentView(R.layout.cadastro);
    	btnCadastrarGo = (Button) findViewById(R.id.btnCadastrar);
    	btnCancelCadastrar = (Button) findViewById(R.id.btnCancelarCadastrar);
    	btnCancelCadastrar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				telaPrincipal();
			
			}
        });
    	btnCadastrarGo.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String nome,idade,prof;
				edNome = (EditText)findViewById(R.id.etNome);
				edIdade = (EditText)findViewById(R.id.etIdade);
				edProf = (EditText)findViewById(R.id.etProf);
				
				nome = edNome.getText().toString();
				idade = edIdade.getText().toString();
				prof = edProf.getText().toString();
				try{
					URL url = new URL("http://www.lfliborio.com.br/android/php/cadastrar_dados.php?nome="+nome+"&idade="+idade+"&profissao="+prof);
						
					InputStream is = url.openStream();
					int i;
					String conteudo = "";
					
					while((i = is.read())!=-1){
						conteudo += ((char)i);
					}
					
					AlertDialog.Builder dialogo = new AlertDialog.Builder(Main.this);
					dialogo.setTitle("Resultado");
					dialogo.setMessage(conteudo);
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();
					}
					catch(Exception e){
						
						AlertDialog.Builder dialogo = new AlertDialog.Builder(Main.this);
						dialogo.setTitle("Erro");
						dialogo.setMessage(e.getMessage());
						dialogo.setNeutralButton("Ok",null);
						dialogo.show();
						
					}
			
			}
        });
    	
    }
    public void telaBuscar(){
    	setContentView(R.layout.listar);
    	btnBuscaGo = (Button) findViewById(R.id.btnBuscarGo);
    	btnBuscaCalcel = (Button) findViewById(R.id.btnBuscarCalcelar);
    	btnBuscaCalcel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				telaPrincipal();
			
			}
        });
    	
    	btnBuscaGo.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				edBusca = (EditText) findViewById(R.id.etId);
				String s = edBusca.getText().toString();
				
				String conteudo = "";
				try{
					for(int j=0;j<30;j++){
					
					URL url = new URL("http://www.lfliborio.com.br/android/php/get_pessoa.php?id="+j);
						
					InputStream is = url.openStream();
					int i;
					
					
					while((i = is.read())!=-1){
						conteudo += ((char)i);
					}
					
					
					
					/*AlertDialog.Builder dialogo = new AlertDialog.Builder(Main.this);
					dialogo.setTitle("Resultado");
					dialogo.setMessage(conteudo);
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();*/
					conteudo += "\n";
					}
					EditText et = (EditText) findViewById(R.id.editText1);
					et.setText(conteudo);
					}
					catch(Exception e){
						
						AlertDialog.Builder dialogo = new AlertDialog.Builder(Main.this);
						dialogo.setTitle("Erro");
						dialogo.setMessage(e.getMessage());
						dialogo.setNeutralButton("Ok",null);
						dialogo.show();
						
					}
				
			
			}
        });
    	
    }
}