package tcpmsgl;

import java.io.IOException;
import java.io.InputStream;

public class TCPServerLMsg extends TCPServerBuilder implements Runnable 
{
	private int nombre;

	public TCPServerLMsg(int nombre) 
	{
		this.nombre=nombre;
	}

	public void run() 
	{
		
		try 
		{
				String server=null;
				setSocket(server,size);
				sBuilder=ssBuilder.accept();
				InputStream in=sBuilder.getInputStream();
				int i=0;
				while(i<nombre)
				{
					server=readMsg(in);
					int serverSize=sBuilder.getReceiveBufferSize();
					System.out.println("server receives message-"+i+":");
					//System.out.println("\n");
					System.out.println(server);
					//System.out.println("\n");
					i++;
				}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
