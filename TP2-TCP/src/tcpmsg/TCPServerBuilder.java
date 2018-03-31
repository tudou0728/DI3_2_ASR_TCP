package tcpmsg;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerBuilder  
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
			isA = new InetSocketAddress("localhost",8085);
			ss = new ServerSocket(isA.getPort());//��Ҫ�����Ķ˿�
			s = ss.accept();//����serversocket�˿ڼ���������Ϣ
			/** we can include more setting, later �� */		
     }
}
