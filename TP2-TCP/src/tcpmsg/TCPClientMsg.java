package tcpmsg;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientMsg extends TCPClientBuilder implements Runnable 
{
	public void run() 
	{
		try {
			
			while(true)
			{
				setSocket();
				String msOut = "Aujourd'hui, TP ASR Java-client." ;
				OutputStream out = s.getOutputStream();
				byte[] buffer1 = msOut.getBytes();
				out.write(buffer1);
				out.flush();
				out.close();
			
				setSocket();
				InputStream in = s.getInputStream();
				byte[] buffer2 = new byte[8192];
				int count = in.read(buffer2);
				String msIn = new String(buffer2,0,count) ;
				System.out.println(msIn);
				in.close();
				s.close();
				Thread.sleep(3000);
			}
		} 
		catch (IOException | InterruptedException e) 
		{
			System.out.println("Exception TCPClientMsg");
			e.printStackTrace();
		}
	}
}
