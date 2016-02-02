package br.cin.ufpe.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
private Context myContext;
private int[] minhaImagens = {
		R.drawable.desert,
		R.drawable.koala,
		R.drawable.lighthouse,
		R.drawable.penguins,
		R.drawable.tulips};
	public ImageAdapter(Context c){
		myContext = c;
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return minhaImagens.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		
		return minhaImagens[position];
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return minhaImagens[position];
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView i = new ImageView(myContext);
		i.setImageResource(minhaImagens[position]);
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		i.setLayoutParams( new Gallery.LayoutParams(180,150));
		return i;
	}
	
	public float getScale(boolean focused,int offset){
		return Math.max(0,1f/(float)Math.pow(2, Math.abs(offset)));
	}

}
