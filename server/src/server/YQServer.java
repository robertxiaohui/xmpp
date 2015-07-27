package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class YQServer
{
	int port = 9090;//����һ���ӿ� 
	
	public YQServer(int serverPort) {
		port = serverPort;
	}
	
	private ServerSocket serverSocket = null;//����ServerSocket����

	public void start(){
		
		try
		{
			//����ServerSocket����,�������ö˿�
			serverSocket = new ServerSocket(port);
			System.out.println("�������Ѿ�����"+new Date());
			//�ȴ�����
			while (true)
			{
				//��ȡ�ͻ�������
				final Socket socket = serverSocket.accept();
				//����һ���߳�,����������ʱ,��Ϣ��������,���Ը�ÿһ������new�Ը��߳�
				new Thread() {
					
					public void run()
					{
						System.out.println(socket + "���ӳɹ�");
						BufferedReader buffer;
						try {
							buffer = new BufferedReader(  
							        new InputStreamReader(socket.getInputStream()));
							 // ��ȡ����  
			                String msg = buffer.readLine();  
			                System.out.println("msg:" + msg);  
						} catch (IOException e) {
							e.printStackTrace();
						}  
		               
					}
				}.start();
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
