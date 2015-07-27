package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class YQServer
{
	int port = 9090;//定义一个接口 
	
	public YQServer(int serverPort) {
		port = serverPort;
	}
	
	private ServerSocket serverSocket = null;//创建ServerSocket程序

	public void start(){
		
		try
		{
			//创建ServerSocket程序,并且设置端口
			serverSocket = new ServerSocket(port);
			//System.out.println("服务器已经启动"+new Date());
			//等待连接
			while (true)
			{
				//获取客户端连接
				final Socket socket = serverSocket.accept();
				//开启一个线程,避免多个连接时,信息处理不过来,所以给每一个连接new以个线程
				new Thread() {
					public void run()
					{
						System.out.println(socket + "连接成功");
						//BufferedReader buffer;
						try {
							/*buffer = new BufferedReader(  
							        new InputStreamReader(socket.getInputStream()));
							 // 读取数据  
			                String msg = buffer.readLine();  
			                System.out.println("msg:" + msg);  */
							
							//建立一个双向通道
							DataInputStream readStream =  new DataInputStream(socket.getInputStream());
							DataOutputStream writerStream = new DataOutputStream(socket.getOutputStream());
							//读取服务器返回的数据
							/*String dataString=null;
							while ((dataString =readStream.readUTF()) !=null)
							{
								System.out.println("server"+dataString);
							}*/
							String mAccount = readStream.readUTF();
							String mPwd = readStream.readUTF();
							System.out.println("server"+mAccount);
							System.out.println("server"+mPwd);
							//writerStream.writeUTF("我是服务器");
							if ("123456".equals(mAccount) && "abc".equals(mPwd))
							{
								writerStream.writeBoolean(true);
							}else {
								writerStream.writeBoolean(false);
							}
							
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
