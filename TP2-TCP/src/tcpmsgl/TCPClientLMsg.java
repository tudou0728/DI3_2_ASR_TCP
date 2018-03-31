package tcpmsgl;

import java.io.IOException;
import java.io.OutputStream;

public class TCPClientLMsg extends TCPClientBuilder implements Runnable 
{
	private int nombre;
	
	public TCPClientLMsg(int nombre) 
	{
		this.nombre=nombre;
	}

	public void run() 
	{	
		try 
		{
			String client="je suis client.";
			setSocket(client,size);
			OutputStream out=sBuilder.getOutputStream();
			loopWriteMsg(out,nombre);
			out.close();
			sBuilder.close();
			System.out.println("client sends message:"+sBuilder);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
