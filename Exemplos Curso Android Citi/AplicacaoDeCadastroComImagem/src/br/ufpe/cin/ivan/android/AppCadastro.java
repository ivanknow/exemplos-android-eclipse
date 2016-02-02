package br.ufpe.cin.ivan.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import br.ufpe.cin.ivan.modelo.ImageAdapter;
import br.ufpe.cin.ivan.modelo.Pessoa;
import br.ufpe.cin.ivan.modelo.PessoaRepositorio;

public class AppCadastro extends Activity {
    /** Called when the activity is first created. */
	
	Button btnTelaCadastrar,btnTelaListar,btnCancelarCadastro,
	btnVoltaListar,btnCadastrar,btnProx,btnAnt,btnInserirImagem,btnInserirImagemGo,btnCancelaInserirImagem;
	PessoaRepositorio bd;
	TextView tvCountareg,tvNome,tvIdade,result,tvProffisao;
	EditText edNome,edIdade,edProfissao;
	Gallery galeria;
	ImageView imagem;
	int pos;
	int idImagem = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bd = new PessoaRepositorio();
        carregaTelaPrincipal();
    }
    
    public void carregaPessoaNaTela(Pessoa p){
    	tvNome.setText(p.getNome());
    	tvIdade.setText(p.getIdade());
    	tvProffisao.setText(p.getProfissao());
    	
    }
    public void carregaGaleria(){
    	idImagem = 0;
    	setContentView(R.layout.galeria);
    	btnCancelaInserirImagem = (Button) findViewById(R.galeria.cancelar);
    	btnInserirImagemGo = (Button) findViewById(R.galeria.Inserir);
    	galeria = (Gallery) findViewById(R.galeria.galeria);
    	galeria.setAdapter(new ImageAdapter(AppCadastro.this));
    	btnCancelaInserirImagem.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				carregaTelaCadastro();
			
			}
        });
    	btnInserirImagemGo.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				ImageAdapter ia = (ImageAdapter)galeria.getAdapter();
				int x = galeria.getSelectedItemPosition();
				
				idImagem =  (Integer)ia.getItem(x);
				
				carregaTelaCadastro();
			
			}
        });
    	
    	
    	
    }
    
    public void carregaTelaPrincipal(){
    	setContentView(R.layout.main);
    	btnTelaCadastrar = (Button) findViewById(R.id.btnTelaCadastrar);
    	btnTelaListar = (Button) findViewById(R.id.btnTelaListar);
    	
    	btnTelaCadastrar.setOnClickListener(new OnClickListener() {
			
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
    //A��o de carregar form de cadastro
    public void carregaTelaCadastro(){
    	setContentView(R.layout.telacadastro);
    	
    	btnCancelarCadastro = (Button) findViewById(R.id.btnCancelarCadastro);
    	btnInserirImagem = (Button) findViewById(R.id.inserirImagem);
    	btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
    	result = (TextView) findViewById(R.id.retornoCadastroFoto);
    	result.setText(""+idImagem);
    	
    	btnCadastrar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				edNome = (EditText) findViewById(R.id.etnome);
				edProfissao = (EditText) findViewById(R.id.etprof);
				edIdade = (EditText) findViewById(R.id.etidade);
				
				if((edNome.getText().toString().equals(""))||
					(edProfissao.getText().toString().equals(""))||
					(edIdade.getText().toString().equals(""))){
					//da um alerta dizendo que ta incompleto
					AlertDialog.Builder dialogo = new AlertDialog.Builder(AppCadastro.this);
					dialogo.setTitle("Resultado");
					dialogo.setMessage("Campos n�o preenchidos");
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();
					
				}else{
					
					
					
					/*ImageAdapter ia = (ImageAdapter)galeria.getAdapter();
					int x = galeria.getSelectedItemPosition();
					Integer i =(Integer) ia.getItem(x);*/
					/*bd.add(new Pessoa(edNome.getText().toString(),
							edProfissao.getText().toString(),
							edIdade.getText().toString(),
							Integer.valueOf(i)));*/
					
					bd.add(new Pessoa(edNome.getText().toString(),
							edProfissao.getText().toString(),
							edIdade.getText().toString()));
					//alerta sucesso
					AlertDialog.Builder dialogo = new AlertDialog.Builder(AppCadastro.this);
					dialogo.setTitle("Resultado");
					dialogo.setMessage("Cadastrado com sucesso");
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();
					carregaTelaPrincipal();
				}
			
			}
        });
    	
    	btnCancelarCadastro.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				carregaTelaPrincipal();
			
			}
        });
    	
    	btnInserirImagem.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				carregaGaleria();
			
			}
        });
    	
    }
    //A��o de carregar listar
    public void carregaTelaListar(){
    	
    	if(bd.contaReg()==0){
    		AlertDialog.Builder dialogo = new AlertDialog.Builder(AppCadastro.this);
			dialogo.setTitle("Nenhum cadastro");
			dialogo.setMessage("Nenhum cadastro foi encontrado");
			dialogo.setNeutralButton("Ok",null);
			dialogo.show();
    	}
    	else{
    	//inicio do else(caso haja registros)
    	
    	 pos = 0;
    	setContentView(R.layout.telalistar);
    	tvCountareg = (TextView) findViewById(R.id.tvNumReg);
    	tvCountareg.setText("N�mero de registros:"+bd.contaReg());
    	tvNome = (TextView) findViewById(R.id.tvNome);
    	tvIdade = (TextView) findViewById(R.id.tvIdade);
    	tvProffisao = (TextView) findViewById(R.id.tvProf);
    	imagem = (ImageView) findViewById(R.id.imagem);
    	carregaPessoaNaTela(bd.getPessoas().get(pos));
    	
    	btnProx = (Button) findViewById(R.id.btnAvanca);
    	btnAnt = (Button) findViewById(R.id.btnVolta);
    	
    	btnProx.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				pos++;
				if(pos>bd.contaReg()-1){
					pos = 0;
				}
				carregaPessoaNaTela(bd.getPessoas().get(pos));
			
			}
        });
    	
    	btnAnt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				pos--;
				if(pos<0){
					pos = bd.contaReg()-1;
				}
				carregaPessoaNaTela(bd.getPessoas().get(pos));
			
			}
        });
    	
    	
    	btnVoltaListar = (Button) findViewById(R.id.btnListarVoltarMain);
    	
    	btnVoltaListar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				carregaTelaPrincipal();
			
			}
        });
    	
    	
    	}//Fim do else(caso haja registros)
    	
    }
}