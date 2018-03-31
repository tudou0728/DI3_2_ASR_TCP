package udptime;

import java.io.IOException;
import java.util.Scanner;

public class UDPClientNTP extends UDPClientBuilder implements Runnable
{
	private Scanner sc;
	public void run() 
	{
		try
		{
			setConnection();
			while(!s.isClosed())
			{
				Long t1=getLocalTime();
				System.out.println("client nanotime t1:"+t1);						
				req = getTimeSendingPacket(isA,size);
				s.send(req);
				Long t11=getTimeStamp();
				System.out.println("client time sent timestamp t1-1:"+t11);
		
				rep = getTimeReceivingPacket(size);
				s.receive(rep);
				Long t3=getTimeStamp(rep);
				System.out.println("client receives time t3:"+t3); 
									
				Long t4= getLocalTime();
				System.out.println("client nanotime t4:"+t4);
				Long t41=getTimeStamp();
				System.out.println("client timestamp t4-1:"+t41);
				Long k=(t4-t1)/2;
				System.out.println("(client nanotime)k="+k);
				Long k1=(t41-t11)/2;
				System.out.println("(client timestamp)k="+k1);
				Long difference=t41-t3-k1;
				System.out.println("(timestamp)difference="+difference);
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
