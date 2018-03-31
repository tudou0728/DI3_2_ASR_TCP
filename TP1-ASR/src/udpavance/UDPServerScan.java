package udpavance;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Random;

public class UDPServerScan extends UDPClientBuilder implements Runnable 
{ 
	public void run() 
	{		 
		try 
		{
			setServerConnection();
			req = new DatagramPacket(new byte[size],0,size,isA.getAddress(),isA.getPort());				
			sClient.send(req);
			//System.out.println("hacking client sent:"+"\t"+"send:"+sClient.getLocalPort()+"\t"+"receive:"+req.getPort());
			
			rep = new DatagramPacket(new byte[size],size);
			sClient.receive(rep);
			//System.out.println("hancking client receive:"+"\t"+"send:"+rep.getPort()+"\t"+"receive:"+sClient.getLocalPort()); 
					
			Random random2 = new Random();
			InetSocketAddress isB=new InetSocketAddress("172.168.2.2",random2.nextInt(65535));
			req = new DatagramPacket(new byte[size],0,size,isB.getAddress(),isB.getPort());	
			sServer.send(req);	
			System.out.println("hacking server sent:"+"\t"+"send:"+sServer.getLocalPort()+"\t"+"receive:"+req.getPort());
			
			rep = new DatagramPacket(new byte[size],size);
			sServer.receive(rep);
			System.out.println("hancking server receive:"+"\t"+"send:"+rep.getPort()+"\t"+"receive:"+sServer.getLocalPort()); 
			
			sServer.close();
			sClient.close();
			Thread.sleep(5000);
		}
		catch(IOException | InterruptedException e)
		{ 		
			System.out.println("host-hacking machine:"+"client port "+req.getPort()+" is closed.");
			sServer.close();
			sClient.close();
			e.getStackTrace();
		}		
	}

}
