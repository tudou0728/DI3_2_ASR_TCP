package tcp1;

public class Test //û��������
{
	public static void main(String[] args)
	{		
		//new Thread(new TCPServer()).start();
		//new Thread(new TCPClient()).start();
		//new Thread(new TCPServerHello()).start();
		//new Thread(new TCPClientHello()).start();
		 new Thread(new TCPServerInfo()).start();
		 new Thread(new TCPClientInfo()).start();
	}
}
