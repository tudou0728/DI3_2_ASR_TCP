package tcpmsg;

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
				setSocket();
				InputStream in = s.getInputStream();		
				byte[] buffer2 = new byte[8192];
				int count = in.read(buffer2);
				String msIn = new String(buffer2,0,count) ;
				System.out.println(msIn);//可以打印出来
				in.close();
			
				s=ss.accept();
				String msOut = "Aujourd'hui, TP ASR Java-server." ;
				OutputStream out = s.getOutputStream();
				byte[] buffer1 = msOut.getBytes();
				out.write(buffer1);
				out.flush();
				out.close();
				s.close();
				ss.close();
				Thread.sleep(3000);
			}
		} 
		catch (IOException | InterruptedException e) 
		{ 
			System.out.println("Exception TCPServerMsg");
			e.printStackTrace();
		}
	}

}
