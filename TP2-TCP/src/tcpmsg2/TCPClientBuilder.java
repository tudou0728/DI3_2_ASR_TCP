package tcpmsg2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClientBuilder  extends TCPMsg
{
	Socket s;
	InetSocketAddress isA;
	
	TCPClientBuilder() 
	{
		s = null;
		isA = null;
	}
	protected void setSocket() throws IOException 
	{
		isA = new InetSocketAddress("localhost",8080);
		s = new Socket(isA.getHostName(), isA.getPort());
		//s = new Socket();
		//isA = new InetSocketAddress("localhost",8085);
		/** we can include more setting, later �� */
	}
	
	void setSocket(String lA, int lP) throws IOException 
	  {
		isA = new InetSocketAddress("localhost",8080);
		s = new Socket(isA.getHostName(), isA.getPort());
		setStreamBuffer(s.getSendBufferSize());
	  }
}
