package com.example.controleremoto;

import org.alexd.jsonrpc.JSONRPCClient;
import org.alexd.jsonrpc.JSONRPCException;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void goTop(View v) {
		executeOperation("goTop");
	}

	public void goBottom(View v) {
		executeOperation("goBottom");
	}

	public void goLeft(View v) {
		executeOperation("goLeft");
	}

	public void goRight(View v) {
		executeOperation("goRight");
	}
	
	public void pressA(View v) {
		executeOperation("pressA");
	}

	public void pressB(View v) {
		executeOperation("pressB");
	}

	public void pressX(View v) {
		executeOperation("pressX");
	}

	public void pressZ(View v) {
		executeOperation("pressZ");
	}
	
	private void executeOperation(String op) {
		String stringUrl = "http://10.0.2.2/jsonrpc3/server.php";
        ConnectivityManager connMgr = (ConnectivityManager) 
            getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadWebpageTask(op).execute(stringUrl);
        } else {
        	 Toast.makeText(getApplicationContext(),"Não há rede disponível", Toast.LENGTH_LONG).show();
        }
	}
	
	
	
	private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
		String operacao;
		public DownloadWebpageTask(String operacao) {
			this.operacao = operacao;
		}
		 protected String doInBackground(String... urls) {
            
	            try {
	            	
	            	JSONRPCClient client = JSONRPCClient.create(urls[0]);
	    			client.setConnectionTimeout(2000);
	    			client.setSoTimeout(2000);
	    			try 
	    			{
	    			  
	    			  int i = client.callInt(operacao);
	    			  return ""+i;
	    			  
	    			}
	    			catch (JSONRPCException e)
	    			{
	    			  return e.getMessage();
	    			}
	            } catch (Exception e) {
	                return "Pagina Offline.";
	            }
				
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(String result) {
	        	 Toast.makeText(getApplicationContext(),""+result, Toast.LENGTH_LONG).show();
	       }

		
	}

}
