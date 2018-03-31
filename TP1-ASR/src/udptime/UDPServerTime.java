package udptime;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPServerTime extends UDPSeverBuilder implements Runnable
{
	private Scanner sc;
	public void run()
	{
		try
		{
			setConnection();
			while(!s.isClosed())
			{
				//server recoit "timestamp"
				req = getTimeReceivingPacket(size);
				s.receive(req);
				Long receivetime=getTimeStamp(req);	
				System.out.println("server receive time t2:"+receivetime); 			
				
				//server envoie "timestamp"
				rep = getTimeSendingPacket((InetSocketAddress) req.getSocketAddress(),size);
				s.send(rep);
				Long t3=getTimeStamp();
				System.out.println("server time sent t3:"+t3);
			}
		}
		catch(IOException e)
		{ 
			s.close();
			System.out.println("IOException UDPServer"); 
		}
	}
}
