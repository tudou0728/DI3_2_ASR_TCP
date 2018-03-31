package udpavance;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPServer extends UDPSeverBuilder implements Runnable
{
	private Scanner sc;
	public void run()
	{
		try 
		{
			setConnection();
			while(!s.isClosed())
			{
				rep =  new DatagramPacket(new byte[size],size);
				s.receive(rep);
				//System.out.println("serveur receive:"+"\t"+"send:"+rep.getPort()+"\t"+"receive:"+s.getLocalPort());
							 
				req = new DatagramPacket(new byte[size],0,size,rep.getSocketAddress());	
				s.send(req);
				//System.out.println("server sent:"+"\t"+"send:"+s.getLocalPort() +"\t"+"receive:"+req.getPort());
			}
			s.close();
		} 
		catch (IOException e) 
		{
			s.close();
			e.printStackTrace();
		}
	}

}
