package tcp1;

import java.net.InetSocketAddress;
import java.net.Socket;

class TCPClient implements Runnable 
{
	private Socket s; // 指明要连接的地址与端口号
	private InetSocketAddress isA; // the remote address
	
	/** The builder. */
	TCPClient() 
	{
		s = null;
		isA = new InetSocketAddress("localhost",8085);
	}
	
	/** The main method for threading. */
	public void run() 
	{
		try {
			System.out.println("TCPClient launched ...");
			s = new Socket(isA.getHostName(), isA.getPort());
			System.out.println("Hello, the client is connected");
			s.close();
		}
		catch(Exception e)
		{ System.out.println("Exception TCPClient"); }
	}
}
