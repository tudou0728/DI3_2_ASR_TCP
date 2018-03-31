package tcptime;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TCPClientBuilder  extends TCPMsg 
{
	Socket sBuilder;
	InetSocketAddress isA;
	
	TCPClientBuilder() 
	{
		sBuilder = null;
		isA = null;
	}
	protected void setSocket() throws IOException 
	{
		isA = new InetSocketAddress("localhost",8080);
		sBuilder = new Socket(isA.getHostName(), isA.getPort());
		//s = new Socket();
		//isA = new InetSocketAddress("localhost",8085);
		/** we can include more setting, later бн */
	}
	
	void setSocket(String lA, int lP) throws IOException 
	  {
		isA = new InetSocketAddress("localhost",8089);
		sBuilder = new Socket(isA.getHostName(), isA.getPort());
		setStreamBuffer(sBuilder.getSendBufferSize());
	  }
}
