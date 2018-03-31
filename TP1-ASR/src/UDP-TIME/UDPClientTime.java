package udptime;

import java.io.IOException;
import java.util.Scanner;

public class UDPClientTime extends UDPClientBuilder implements Runnable
{
	private Scanner sc;
	public void run()
	{
		try
		{
			setConnection();
			while(!s.isClosed())
			{				
				//client envoie "timestamp"
				req = getTimeSendingPacket(isA,size);
				s.send(req);	
				Long send=getTimeStamp();
				System.out.println("client time sent t1:"+send);
				
				//client recoit "timestamp"
				rep = getTimeReceivingPacket(size);
				s.receive(rep);
				Long receivetime=getTimeStamp(rep);
				System.out.println("client reveive time t3:"+receivetime); 
				
				//calcule le decalage entre client et server
				Long t4=getTimeStamp();
				System.out.println("client time t4:"+t4);
				Long difference=t4-receivetime;
				System.out.println("difference:"+difference);
				System.out.println("\n");
				Thread.sleep(3000);
			}
		}
		catch(IOException | InterruptedException e)
		{ 
			s.close();
			System.out.println("IOException UDPClient"); 
		}
	}
}
