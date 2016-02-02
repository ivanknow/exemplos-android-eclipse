package br.ufpe.modelo;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
private Context myContext;
private ArrayList<Bitmap> minhasImagens;

	public ImageAdapter(Context c){
		myContext = c;
		minhasImagens = new ArrayList<Bitmap>();
		
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return minhasImagens.size();
	}
	
	public void setMinhasImagens(ArrayList<Bitmap> minhasImagens) {
		this.minhasImagens = minhasImagens;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		
		return minhasImagens.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView i = new ImageView(myContext);
		i.setImageBitmap(minhasImagens.get(position));
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		i.setLayoutParams( new Gallery.LayoutParams(180,150));
		return i;
	}
	
	public float getScale(boolean focused,int offset){
		return Math.max(0,1f/(float)Math.pow(2, Math.abs(offset)));
	}

}
