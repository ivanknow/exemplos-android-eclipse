package br.ufrpe.mobile.provamovel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import br.ufrpe.mobile.provamovel.modelo.Alternativa;
import br.ufrpe.mobile.provamovel.modelo.Questao;
import br.ufrpe.mobile.provamovel.modelo.QuestaoFechada;

public class QuestaoFechadaFragment extends Fragment {
	Questao questao;
	View v;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.questao_fechada, parent, false);

		RadioGroup rg = (RadioGroup) v.findViewById(R.id.grupo);

		QuestaoFechada qf = (QuestaoFechada) questao;
		TextView tvenun = (TextView) v.findViewById(R.id.enunciadoFechado);
		System.out.println("enunciado:" + questao.getEnunciado());
		tvenun.setText(qf.getEnunciado());

		for (int i = 0; i < qf.getAlternativas().size(); i++) {
			Alternativa a = qf.getAlternativas().get(i);
			if (a.getMarcada() != 0) {
				
				RadioButton rb = (RadioButton)rg.getChildAt(i);
				rb.setChecked(true);
			}

		}

		RadioButton opt = (RadioButton) v.findViewById(R.id.opt1);
		opt.setText(qf.getAlternativas().get(0).getTitulo());
		if (qf.getAlternativas().size() > 1) {
			 opt = (RadioButton) v.findViewById(R.id.opt2);
			 opt.setText(qf.getAlternativas().get(1).getTitulo());
		}
		if (qf.getAlternativas().size() > 2) {
			opt = (RadioButton) v.findViewById(R.id.opt3);
			opt.setText(qf.getAlternativas().get(2).getTitulo());
		}
		if (qf.getAlternativas().size() > 3) {
			 opt = (RadioButton) v.findViewById(R.id.opt4);
			 opt.setText(qf.getAlternativas().get(3).getTitulo());
		}
		if (qf.getAlternativas().size() > 4) {
			 opt = (RadioButton) v.findViewById(R.id.opt5);
			 opt.setText(qf.getAlternativas().get(4).getTitulo());
		}

		return v;
	}

	public void loadQuestaoNaTela(Questao questao) {

		this.questao = questao;

	}

	public void atualizarQuestao() {
		TextView tvenun = (TextView) v.findViewById(R.id.enunciadoFechado);

		RadioGroup rg = (RadioGroup) v.findViewById(R.id.grupo);

		QuestaoFechada qf = (QuestaoFechada) questao;
		
		int radioButtonID = rg.getCheckedRadioButtonId();
		View radioButton = rg.findViewById(radioButtonID);
		int idx = rg.indexOfChild(radioButton);
		qf.getAlternativas().get(idx).setMarcada((short) 1);

	}

}
