import java.io.IOException;
import java.net.DatagramPacket;


class UDPSeverHello extends UDPSeverBuilder implements Runnable 
{
	private final int size = 2048;
	
	public void run() 
	{
		try {
			setConnection();
			req = new DatagramPacket(new byte[size],size);
			s.receive(req);
			System.out.println("request received:"+s.getLocalPort());
			rep = new DatagramPacket(new byte[size],0,size,req.getSocketAddress());
			s.send(rep);
			System.out.println("reply sent");
			s.close();
		}
		catch(IOException e)
		{ System.out.println("IOException UDPServer"); }
	}
}
