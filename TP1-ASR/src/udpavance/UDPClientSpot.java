package udpavance;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.util.Scanner;

public class UDPClientSpot extends UDPClientBuilder implements Runnable
{	
	public void run() 
	{
		try 
		{
			setClientConnection();	
			req = new DatagramPacket(new byte[size],0,size,isA.getAddress(),isA.getPort());		
			sClient.send(req);
			System.out.println("client sent request:"+"\t"+"send:"+sClient.getLocalPort()+"\t"+"receive:"+req.getPort());
			Thread.sleep(5000);
			
			rep = new DatagramPacket(new byte[size],size);
			sClient.receive(rep);
			System.out.println("client receive reply:"+"\t"+"send:"+rep.getPort()+"\t"+"receive:"+sClient.getLocalPort() ); 
			sClient.close();
		}
		catch(IOException | InterruptedException  e)
		{ 
			System.out.println("host-client machine- "+"client port "+sClient.getLocalPort()+":"+req.getAddress()+"\t"+req.getPort()+" is closed.");
			sClient.close();
			e.getStackTrace();
		}
	}

}
