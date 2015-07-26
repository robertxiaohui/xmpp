package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class YQServer
{
	int port = 9090;//定义一个接口 
	private ServerSocket serverSocket = null;//创建ServerSocket程序

	public YQServer(int serverPort) {
		port = serverPort;
	}
	
	public void start(){
		
		try
		{
			//创建ServerSocket程序,并且设置端口
			serverSocket = new ServerSocket(port);
			System.out.println("服务器已经启动"+new Date());
			//等待连接
			while (true)
			{
				//获取客户端连接
				final Socket socket = serverSocket.accept();
				//开启一个线程,避免多个连接时,信息处理不过来,所以给每一个连接new以个线程
				new Thread(new Runnable() {
					
					@Override
					public void run()
					{
						System.out.println(socket + "连接成功");
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
