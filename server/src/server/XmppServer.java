package server;

public class XmppServer
{

	/**
	 * 功能:TODO
	 * @param args 
	 */
	public static void main(String[] args)
	{
		
		YQServer server = new YQServer(9090);
		//启动服务器
		server.start();
	}

}
