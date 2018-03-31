import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClientBuilder extends UDPRWText
{
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;
	
	UDPClientBuilder()
	{ 
		isA = null; 
		s = null; 
		req = rep = null; 
	}
		
	int times=3000;
	
	protected void setConnection() throws IOException 
	{
		s = new DatagramSocket();
		//isA = new InetSocketAddress("172.20.10.6",8094); 
		isA = new InetSocketAddress("localhost",8080);
		/** we can include more setting, later бн */	
		//s.setSoTimeout(times);//set time to out
	}
}
