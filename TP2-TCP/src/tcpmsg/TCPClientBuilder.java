package tcpmsg;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

class TCPClientBuilder  
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
		isA = new InetSocketAddress("localhost",8085);
		s = new Socket(isA.getHostName(), isA.getPort());
		//s = new Socket();
		//isA = new InetSocketAddress("localhost",8085);
		/** we can include more setting, later �� */
	}
}
