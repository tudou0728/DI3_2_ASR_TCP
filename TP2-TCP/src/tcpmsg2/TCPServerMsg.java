package tcpmsg2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TCPServerMsg extends TCPServerBuilder implements Runnable 
{
	public void run() 
	{
		try 
		 {		
			while(true)
			{
				String server=null;
				setSocket(server,size);
				s=ss.accept();
				InputStream in=s.getInputStream();
				server=readMsg(in);		
				in.close();
				System.out.println("server receive:"+server);
				s.close();
				ss.close();
			
				setSocket();
				setStreamBuffer(s.getSendBufferSize());
				server="bonjour, je suis server.";
				OutputStream out = s.getOutputStream();//应该是对应的socket的输出流
				writeMsg(out,server);
				out.close();
				System.out.println("server sends message:"+server);
				s.close();
				ss.close();
				Thread.sleep(3000);	
			}
		 } 
		 catch (IOException | InterruptedException e) 
		 {
			e.printStackTrace();
		}
	}

}
