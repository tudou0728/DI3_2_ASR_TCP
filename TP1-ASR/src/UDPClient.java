import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

class UDPClient implements Runnable 
{
	InetSocketAddress isA; // the remote address
	DatagramSocket s; // the socket object
	DatagramPacket req, rep; // to prepare the request and reply message
	private final int size = 2048; // the default size for the buffer array
	
	/** The builder. */
	UDPClient() 
	{
		isA = new InetSocketAddress("localhost",8080);//如果把这里 改成对方的ip 和端口 就可以互相接受信息；
		s = null; req = rep = null;
	}
	
	/** The main run method for thread. */
	public void run( ) 
	{
		try {
			s = new DatagramSocket();
			req = new DatagramPacket(new byte[size],0,size,isA.getAddress(),isA.getPort());
			s.send(req);
			System.out.println("request sent");
			rep = new DatagramPacket(new byte[size],size);
			s.receive(rep);
			System.out.println("reply received");
			s.close();
		}
		catch(IOException e)
		{ System.out.println("IOException UDPClient"); }
	}
}