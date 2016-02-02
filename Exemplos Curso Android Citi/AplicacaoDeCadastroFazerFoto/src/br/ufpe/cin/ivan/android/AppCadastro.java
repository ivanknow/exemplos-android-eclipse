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
	btnVoltaListar,btnCadastrar,
	btnProx,btnAnt,
	btnEditar,btnExcluir,
	btnTelaImagem,btnSalvaImagem,btnCancelaImagem;
	PessoaRepositorio bd;
	TextView tvCountareg,tvNome,tvIdade,tvProffisao;
	EditText edNome,edIdade,edProfissao;
	Gallery galeria;
	ImageAdapter ia;
	ImageView iv;
	
	int pos;//pos == -1 significa cadastrar else significa editar
	int imagem;
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
    
    public void carregarPessoaNaTelaEdicao(Pessoa p){
    	edNome.setText(p.getNome());
    	edIdade.setText(p.getIdade());
    	edProfissao.setText(p.getProfissao());
    	if(p.getIdImagem()!=0){
    	
    	iv.setImageResource(p.getIdImagem());
    	}
    }
  
    
    public void carregaTelaPrincipal(){
    	setContentView(R.layout.main);
    	btnTelaCadastrar = (Button) findViewById(R.id.btnTelaCadastrar);
    	btnTelaListar = (Button) findViewById(R.id.btnTelaListar);
    	
    	btnTelaCadastrar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				pos = -1;
				imagem = R.drawable.icon;
				carregaTelaCadastro();
			
			}
        });
    	
    	btnTelaListar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				pos = 0;
				carregaTelaListar();
			
			}
        });
    	
    	
    }
    //A��o de carregar form de cadastro
    public void carregaTelaCadastro(){
    	setContentView(R.layout.telacadastro);
    	iv = (ImageView) findViewById(R.id.imageCadastro);
    	
    	edNome = (EditText) findViewById(R.id.etnome);
		edProfissao = (EditText) findViewById(R.id.etprof);
		edIdade = (EditText) findViewById(R.id.etidade);
    	
    	btnCancelarCadastro = (Button) findViewById(R.id.btnCancelarCadastro);
    	btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
    	btnTelaImagem = (Button) findViewById(R.id.btnTelaInserirImagem);
    	
    	
    	if(pos!=-1){
    		carregarPessoaNaTelaEdicao(bd.getPessoas().get(pos));
    		
    	}
    	iv.setImageResource(imagem);
    	
    	btnCadastrar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
				if((edNome.getText().toString().equals(""))||
					(edProfissao.getText().toString().equals(""))||
					(edIdade.getText().toString().equals(""))){
					//da um alerta dizendo que ta incompleto
					AlertDialog.Builder dialogo = new AlertDialog.Builder(AppCadastro.this);
					dialogo.setTitle("Resultado");
					dialogo.setMessage("Campos n�o preenchidos");
					dialogo.setNeutralButton("Ok",null);
					dialogo.show();
					
				}
				else{
					
					if(pos!=-1){
						Pessoa p =bd.getPessoas().get(pos);
						p.setNome(edNome.getText().toString());
						p.setProfissao(edProfissao.getText().toString());
						p.setIdade(edIdade.getText().toString());
						p.setIdImagem(imagem);
					}else{
						bd.add(new Pessoa(edNome.getText().toString(),
								edProfissao.getText().toString(),
								edIdade.getText().toString(),imagem));
						
					}
					
					
					
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
    	
    	btnTelaImagem.setOnClickListener(new OnClickListener() {
			
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
    	
    	
    	setContentView(R.layout.telalistar);
    	tvCountareg = (TextView) findViewById(R.id.tvNumReg);
    	tvCountareg.setText("N�mero de registros:"+bd.contaReg());
    	tvNome = (TextView) findViewById(R.id.tvNome);
    	tvIdade = (TextView) findViewById(R.id.tvIdade);
    	tvProffisao = (TextView) findViewById(R.id.tvProf);
    	
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
    	
    	btnExcluir = (Button) findViewById(R.id.btnExcluirPessoa);
    	
    	btnExcluir.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				bd.remove(pos);
				AlertDialog.Builder dialogo = new AlertDialog.Builder(AppCadastro.this);
				dialogo.setTitle("Exclus�o");
				dialogo.setMessage("Excluido com sucesso");
				dialogo.setNeutralButton("Ok",null);
				dialogo.show();
				carregaTelaPrincipal();
			
			}
        });
    	
btnEditar = (Button) findViewById(R.id.btnEditarPessoa);
    	
    	btnEditar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				imagem = (bd.getPessoas().get(pos).getIdImagem());
				carregaTelaCadastro();
			
			}
        });
    	
    	
    	
    	
    	}//Fim do else(caso haja registros)
    	
    }

    public void carregaGaleria(){
    	setContentView(R.layout.gareria);
    	btnCancelaImagem = (Button) findViewById(R.galeria.cancelar);
    	btnSalvaImagem = (Button) findViewById(R.galeria.salvarImagem);
    	ia = new ImageAdapter(AppCadastro.this);
    	galeria = (Gallery) findViewById(R.galeria.g1);
    	galeria.setAdapter(ia);
    	
    	btnCancelaImagem.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				carregaTelaCadastro();
			
			}
        });
    	
    	btnSalvaImagem.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				Integer num =(Integer) ia.getItem(galeria.getSelectedItemPosition());
				
				imagem = num;
				
				carregaTelaCadastro();
			
			}
        });
    	
    	
    	
    	
    	
    	
    }
}