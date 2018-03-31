package tcp1;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer implements Runnable 
{
	private ServerSocket ss; 
	private Socket s; // the passive and active sockets
	private InetSocketAddress isA; // the address
	
	/** The main method for threading. */
	TCPServer() 
	{
		ss = null; 
		s = null;
		isA = new InetSocketAddress("localhost",8085);
	}
	/** The main method for threading. */
	public void run( ) 
	{
		try {
			System.out.println("TCPServer launched ...");
			ss = new ServerSocket(isA.getPort());//绑定要监听的端口
			s = ss.accept();//接受serversocket端口监听到的信息
			System.out.println("Hello, the server accepts");//服务器确定已经收到了信息
			s.close(); 
			ss.close();
		}
		catch(Exception e)
		{ System.out.println("Exception TCPServer"); }
	}
}
