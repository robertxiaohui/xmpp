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
		
		//��checkbox����״̬�ı�����¼�
		mRemember.setOnCheckedChangeListener(this);
		//����Ӧ�İ�ť���õ���¼�
		mLogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);
	}

	//����ť�������ʱ��,�����������
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn_login://����˵�½
			login();
			Toast.makeText(this, "��½", Toast.LENGTH_SHORT).show();
			break;

		case R.id.login_btn_register://����˵�½
			Toast.makeText(this, "ע��", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
	}

	//��checkboxѡ���״̬�ı��ʱ��,�����������
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			Toast.makeText(this, "ѡ����", Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(this, "ûѡ��", Toast.LENGTH_SHORT).show();
			
		}
		
	}
	
	public void login(){
		new Thread(){
			public void run() {
				
				try
				{
					Socket socket = new Socket("192.168.1.161", 9090);
					
					 // ��ȡ Client �˵������  
		            PrintWriter out = new PrintWriter(new BufferedWriter(  
		                    new OutputStreamWriter(socket.getOutputStream())), true);  
		            // �����Ϣ  
		            out.println(mAccount.getText());  
		            System.out.println("msg=" + mAccount.getText());  
		            // �ر�  
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
		
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}
	
	

}
