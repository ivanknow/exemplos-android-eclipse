package br.ufpe.cin.modelo;

import java.util.ArrayList;

import android.R;
import android.content.Context;
import android.text.NoCopySpan.Concrete;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	
	ArrayList<Integer> imagens;
	Context myContext;
	
	public ImageAdapter(Context c) {
		
		myContext = c;
		imagens = new ArrayList<Integer>();
		imagens.add((Integer)br.ufpe.cin.blog.R.drawable.desert);
		imagens.add((Integer)br.ufpe.cin.blog.R.drawable.koala);
		imagens.add((Integer)br.ufpe.cin.blog.R.drawable.lighthouse);
		imagens.add((Integer)br.ufpe.cin.blog.R.drawable.tulips);
		
		
	}

	@Override
	public int getCount() {
		
		return imagens.size();
	}

	@Override
	public Object getItem(int arg0) {
		
		return imagens.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		return imagens.get(position).intValue();
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView i = new ImageView(myContext);
		i.setImageResource(imagens.get(position).intValue());
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		i.setLayoutParams( new Gallery.LayoutParams(180,150));
		return i;
		
	}

}
