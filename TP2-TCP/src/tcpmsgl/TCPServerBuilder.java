package tcpmsgl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerBuilder  extends TCPMsg
{
	  ServerSocket ssBuilder; 
	  Socket sBuilder; // the passive and active sockets
	  InetSocketAddress isA; // the address
	  
	  TCPServerBuilder()
	  {
		  ssBuilder = null; 
		  sBuilder = null;
		  isA = null;
	  }
	  
	  protected void setSocket() throws IOException 
	 {
			isA = new InetSocketAddress("localhost",8080);
			ssBuilder = new ServerSocket(isA.getPort());//��Ҫ�����Ķ˿�
			sBuilder = ssBuilder.accept();//����serversocket�˿ڼ���������Ϣ
			/** we can include more setting, later �� */		
     }
	  
	  void setSocket(String lA, int lP) throws IOException 
	  {
		isA = new InetSocketAddress("localhost",8089);
		ssBuilder = new ServerSocket(isA.getPort());	
		setStreamBuffer(ssBuilder.getReceiveBufferSize());
	  }
}
