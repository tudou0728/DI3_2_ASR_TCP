package udpavance;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Random;

public class UDPClientBuilder  
{
	InetSocketAddress isA;
	DatagramSocket sClient,sServer;
	DatagramPacket req, rep;
	final int size = 2048;
	Random random = new Random();
	int port=random.nextInt(65535);
	
	UDPClientBuilder()
	{ isA = null; sClient = null; req = rep = null; sServer=null;random=null;}
		
	int times=3000;
	protected void setClientConnection() throws IOException 
	{		
		//isA = new InetSocketAddress("172.16.254.1",8085);
		isA = new InetSocketAddress("localhost",8085);
		sClient = new DatagramSocket();	
		sClient.setSoTimeout(times);
	}
	
	protected void setServerConnection()throws IOException
	{		
		isA = new InetSocketAddress("localhost",8085);
		sClient = new DatagramSocket();
		sServer = new DatagramSocket(port);	
		sServer.setSoTimeout(times);
		//sServer.setSoTimeout(times);
	}
}
