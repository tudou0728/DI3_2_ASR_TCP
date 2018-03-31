package tcpmsg2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerBuilder  extends TCPMsg  
{
	  ServerSocket ss; 
	  Socket s; // the passive and active sockets
	  InetSocketAddress isA; // the address
	  
	  TCPServerBuilder()
	  {
		  ss = null; 
		  s = null;
		  isA = null;
	  }
	  
	  protected void setSocket() throws IOException 
	 {
			isA = new InetSocketAddress("localhost",8080);
			ss = new ServerSocket(isA.getPort());//��Ҫ�����Ķ˿�
			s = ss.accept();//����serversocket�˿ڼ���������Ϣ
			/** we can include more setting, later �� */		
     }
	  
	  
	  void setSocket(String lA, int lP) throws IOException 
	  {
		isA = new InetSocketAddress("localhost",8080);
		ss = new ServerSocket(isA.getPort());
		setStreamBuffer(ss.getReceiveBufferSize());
	  }
}
