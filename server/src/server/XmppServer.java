package server;

public class XmppServer
{

	/**
	 * ����:TODO
	 * @param args 
	 */
	public static void main(String[] args)
	{
		
		YQServer server = new YQServer(9090);
		//����������
		server.start();
	}

}
