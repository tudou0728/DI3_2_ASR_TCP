package tcpmsg2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TCPClientMsg extends TCPClientBuilder implements Runnable 
{
	public void run() 
	{
		 try 
		 {			 
			 while(true)
			{								
				String client="bonjour, je suis client.";
				setSocket(client,size);
				OutputStream out = s.getOutputStream();//应该是对应的socket的输出流
				writeMsg(out,client);
				out.close();
				System.out.println("client sends message:"+client);
				s.close();
			
				setSocket();
				setStreamBuffer(s.getReceiveBufferSize());
				InputStream in=s.getInputStream();
				client=readMsg(in);		
				in.close();
				System.out.println("client receive:"+client);
				s.close();
				Thread.sleep(3000);
				//s.close();
				//System.out.println("client close");
			}
		 } 
		 catch (IOException | InterruptedException e) 
		 {
			 e.printStackTrace();
		 }
	}

}
