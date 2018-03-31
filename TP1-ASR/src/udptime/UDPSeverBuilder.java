package udptime;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UDPSeverBuilder extends UDPRWTime
{
	InetSocketAddress isA; // the address
	DatagramSocket s; // the socket object
	DatagramPacket req, rep; // to prepare the request and reply message
    final int size = 2048;
	
	UDPSeverBuilder()
	{ isA = null; s = null; req = rep = null; }
	
	int times=3000;
	protected void setConnection() throws IOException 
	{
		
		//isA = new InetSocketAddress("172.20.10.6",8085); 
		isA = new InetSocketAddress("localhost",8080);
		s = new DatagramSocket(isA.getPort());
		/** we can include more setting, later бн */
		//s.setSoTimeout(times);
	}
}
