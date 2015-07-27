package com.jerry.my_xmpp;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnCheckedChangeListener, OnClickListener {

	private EditText mAccount;
	private EditText mPwd;
	private CheckBox mRemember;
	private Button mLogin;
	private Button mRegister;
	private boolean	mIsTrue = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		initView();
	}

	
	private void initView() {
	
		mAccount = (EditText) findViewById(R.id.login_et_account);
		mPwd = (EditText) findViewById(R.id.login_et_password);
		
		mRemember = (CheckBox) findViewById(R.id.login_remember);
		
		mLogin = (Button) findViewById(R.id.login_btn_login);
		mRegister = (Button) findViewById(R.id.login_btn_register);
		
		//给checkbox设置状态改变监听事件
		mRemember.setOnCheckedChangeListener(this);
		//给对应的按钮设置点击事件
		mLogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);
	}

	//当按钮被点击的时候,调用这个方法
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn_login://点击了登陆
			if ("".equals(mAccount.getText().toString()))//输入账号为空
			{
				Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
				return;
			}else if ("".equals(mPwd.getText().toString())) {
				
				Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
				return;
			}
			if (!login())
			{
				Toast.makeText(this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
				return;
			}
			
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			
			
			break;

		case R.id.login_btn_register://点击了登陆
			Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
	}

	//当checkbox选择的状态改变得时候,调用这个方法
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			Toast.makeText(this, "选中了", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(this, "没选中", Toast.LENGTH_SHORT).show();
			
		}
		
	}
	
	public boolean login(){
		new Thread(){
			

			public void run() {
				
				try
				{
					Socket socket = new Socket("192.168.8.17", 9090);
					
					/* // 获取 Client 端的输出流  
		            PrintWriter out = new PrintWriter(new BufferedWriter(  
		                    new OutputStreamWriter(socket.getOutputStream())), true);  
		            // 填充信息  
		            out.println(mAccount.getText());  
	  	            System.out.println("msg=" + mAccount.getText());  */
					
					//建立一个双向通道
					DataInputStream readStream =  new DataInputStream(socket.getInputStream());
					DataOutputStream writerStream = new DataOutputStream(socket.getOutputStream());
					writerStream.writeUTF(mAccount.getText().toString());
					writerStream.writeUTF(mPwd.getText().toString());
					mIsTrue = readStream.readBoolean();
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
		
		return mIsTrue;
	}
	
	

}
