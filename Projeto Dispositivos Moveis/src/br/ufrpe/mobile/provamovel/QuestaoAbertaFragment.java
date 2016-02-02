package br.ufrpe.mobile.provamovel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import br.ufrpe.mobile.provamovel.modelo.Questao;
import br.ufrpe.mobile.provamovel.modelo.QuestaoAberta;


public class QuestaoAbertaFragment extends Fragment {
	Questao questao;
	View v;

    public void loadQuestaoNaTela(Questao questao) {
		this.questao = questao;
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.questao_aberta, parent, false);

        TextView tvenun = (TextView) v.findViewById(R.id.enunciadoAberto);
		EditText etrespAbert = (EditText) v.findViewById(R.id.respostaAberta);
		QuestaoAberta qa = (QuestaoAberta) questao;
		tvenun.setText(qa.getEnunciado());
		
		etrespAbert.setText(qa.getResposta()); 
		return v; 
    }
    
    public void atualizarQuestao(){
    	TextView tvenun = (TextView) v.findViewById(R.id.enunciadoAberto);
		EditText etrespAbert = (EditText) v.findViewById(R.id.respostaAberta);
		
		QuestaoAberta qa = (QuestaoAberta) questao;
		qa.setResposta(etrespAbert.getText().toString());
		
    }

	
    

    
}
