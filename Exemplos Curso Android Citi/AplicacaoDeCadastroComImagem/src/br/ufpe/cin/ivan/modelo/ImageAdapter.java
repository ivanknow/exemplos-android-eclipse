package br.ufpe.cin.ivan.modelo;

import java.util.ArrayList;

import br.ufpe.cin.ivan.android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
private Context myContext;
private ArrayList<Integer> minhasImagens;

	public ImageAdapter(Context c){
		myContext = c;
		minhasImagens = new ArrayList<Integer>();
		minhasImagens.add((Integer)R.drawable.desert);
		minhasImagens.add((Integer)R.drawable.koala);
		minhasImagens.add((Integer)R.drawable.lighthouse);
		minhasImagens.add((Integer)R.drawable.penguins);
		minhasImagens.add((Integer)R.drawable.tulips);
		
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return minhasImagens.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		
		return minhasImagens.get(position).intValue();
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return minhasImagens.get(position).intValue();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView i = new ImageView(myContext);
		i.setImageResource(minhasImagens.get(position).intValue());
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		i.setLayoutParams( new Gallery.LayoutParams(180,150));
		return i;
	}
	
	public float getScale(boolean focused,int offset){
		return Math.max(0,1f/(float)Math.pow(2, Math.abs(offset)));
	}

}
