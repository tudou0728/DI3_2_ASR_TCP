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
			ss = new ServerSocket(isA.getPort());//��Ҫ�����Ķ˿�
			s = ss.accept();//����serversocket�˿ڼ���������Ϣ
			System.out.println("Hello, the server accepts");//������ȷ���Ѿ��յ�����Ϣ
			s.close(); 
			ss.close();
		}
		catch(Exception e)
		{ System.out.println("Exception TCPServer"); }
	}
}
