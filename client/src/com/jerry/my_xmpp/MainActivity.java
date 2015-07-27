package com.jerry.my_xmpp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params)
			{
				try
				{
					Socket socket = new Socket("192.168.1.161", 9090);
				}
				catch (UnknownHostException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				return null;
			}};*/
			
			new Thread(){
				public void run() {
					
					try
					{
						Socket socket = new Socket("192.168.1.161", 9090);
					}
					catch (UnknownHostException e)
					{
						e.printStackTrace();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				};
			}.start();
	}
}
