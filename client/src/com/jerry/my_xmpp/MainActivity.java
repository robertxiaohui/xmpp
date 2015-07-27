package com.jerry.my_xmpp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
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
			
			
	}
}
