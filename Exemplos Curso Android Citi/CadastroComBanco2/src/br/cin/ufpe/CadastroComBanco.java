package br.cin.ufpe;

import org.w3c.dom.Text;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroComBanco extends Activity {
	
	SQLiteDatabase banco;
	Cursor dados;
	Button btnTelaCadastro,btnTelaListar,
	btnCadastroSalvar,btnCadastroCancelar,
	btnListarCancelar;
	TextView tvnome,tvidade,tvprof;
	EditText ETnome,ETidade,ETprof;
	
	int id=0;
	
	TextView numRegistros;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
       
        try{
        banco = getApplicationContext().openOrCreateDatabase("bancoCadastro",MODE_PRIVATE,null);
        //banco.execSQL("DROP TABLE tb_pessoa2");
        banco.execSQL("CREATE TABLE if not exists tb_pessoa2 (id INTEGER PRIMARY KEY NOT NULL, nome VARCHAR(255),profissao VARCHAR(255),idade NUMERIC NOT NULL) ");
	        carregaTelaPrincipal();
        }catch (Exception e){
        	e.printStackTrace();
        }
    }
    
    
    //INICIO
    public void carregaTelaPrincipal(){
    	setContentView(R.layout.main);
    	
    	btnTelaCadastro = (Button) findViewById(R.main.abrirTelaCadastro);
    	btnTelaListar = (Button) findViewById(R.main.abrirTelaListar);
    	
    	
    	
    	btnTelaCadastro.setOnClickListener(new OnClickListener() {
			
				public void onClick(View v) {
				
					carregaTelaCadastro();
				}
        });
    	
    	btnTelaListar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
				carregaTelaListar();
			}
    });
    }
    //FIM
    
    //INICIO
    public void carregaTelaCadastro(){
    	setContentView(R.layout.tela_cadastro);
    	
    	btnCadastroSalvar = (Button) findViewById(R.cadastro.btnSalvar);
    	btnCadastroCancelar = (Button) findViewById(R.cadastro.btnCancelar);
    	
    	ETnome = (EditText) findViewById(R.cadastro.editTextNome);
    	ETidade= (EditText) findViewById(R.cadastro.editTextIdade);
    	ETprof =  (EditText) findViewById(R.cadastro.editTextProf);
    	
    	
    	
    	btnCadastroSalvar.setOnClickListener(new OnClickListener() {
			
				public void onClick(View v) {
					
					String nome,idade,prof;
					try{
			    		dados = banco.query("tb_pessoa2",new String[]{"nome"}, null,null,null,null,null);
			    		//isso vai da merda qdo excluir
			    		//tem q pegar o max
			    		id = dados.getCount()+1;
			    	}
			    	catch(Exception e){
			    		
			    		
			    	}
					
					
					nome = ETnome.getText().toString();
					idade = ETidade.getText().toString();
					prof = ETprof.getText().toString();
				
					banco.execSQL("INSERT INTO tb_pessoa2 values ("+id+",'"+nome+"','"+prof+"',"+idade+"); ");
					
				}
        });
    	
    	btnCadastroCancelar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
				carregaTelaPrincipal();
			}
    });
    }
    //FIM
    
  //INICIO
    public void carregaTelaListar(){
    	setContentView(R.layout.tela_listar);
    	numRegistros = (TextView) findViewById(R.listar.tvCount);
    	numRegistros.setText("foda");
    	btnListarCancelar = (Button) findViewById(R.listar.btnCancelar);
    	
    	
    	try{
    		dados = banco.query("tb_pessoa2",new String[]{"id","nome","idade","profissao"}, null,null,null,null,null);
    		numRegistros.setText(dados.getCount()+"");
    		
    		
    		dados = banco.query("tb_pessoa2",new String[]{"id","nome","idade","profissao"}, null,null,null,null,null);
    		dados.moveToFirst();
    		tvnome = (TextView) findViewById(R.listar.tvnome);
    		tvidade = (TextView) findViewById(R.listar.tvidade);
    		tvprof = (TextView) findViewById(R.listar.tvprof);
    		
    		tvnome.setText(dados.getString(dados.getColumnIndex("nome")));
    		tvidade.setText(dados.getString(dados.getColumnIndex("idade")));
    		tvprof.setText(dados.getString(dados.getColumnIndex("profissao")));
    		
    		
    	}
    	catch(Exception e){
    		  
    		
    	}
    	
    	btnListarCancelar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
				carregaTelaPrincipal();
			}
    });
    	
    }
    //FIM
    
    
}