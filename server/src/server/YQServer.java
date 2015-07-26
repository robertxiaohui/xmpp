package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class YQServer
{
	int port = 9090;//����һ���ӿ� 
	private ServerSocket serverSocket = null;//����ServerSocket����

	public YQServer(int serverPort) {
		port = serverPort;
	}
	
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
				new Thread(new Runnable() {
					
					@Override
					public void run()
					{
						System.out.println(socket + "���ӳɹ�");
					}
				}).start();
				
			}
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
