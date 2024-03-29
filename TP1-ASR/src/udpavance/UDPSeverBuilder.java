package udpavance;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UDPSeverBuilder  
{
	InetSocketAddress isA; // the address
	DatagramSocket s; // the socket object
	DatagramPacket req, rep; // to prepare the request and reply message
    final int size = 2048;
	
	UDPSeverBuilder()
	{ isA = null; s = null; req = rep = null; }
	
	private int times=3000;
	protected void setConnection() throws IOException 
	{
		
		//isA = new InetSocketAddress("172.20.10.6",8085);//"172.20.10.6",8090
		isA = new InetSocketAddress("localhost",8085);
		s = new DatagramSocket(isA.getPort());
		/** we can include more setting, later �� */
		//s.setSoTimeout(times);
	}
}
