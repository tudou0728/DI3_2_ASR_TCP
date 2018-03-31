import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPClientTchat extends UDPClientBuilder implements Runnable
{
	private Scanner sc;
	//private final int size = 2048;
	
	public void run()
	{
		try 
		{
			setConnection();
			while(!s.isClosed())
			{
				/**le client envoie le message*/
				sc = new Scanner(System.in);				
				String msg = sc.nextLine();
				req = getTextSendingPacket(isA,msg,size);
				s.send(req);			
				System.out.println("request sent");
			
				/**le client recoit le message*/
				rep = getTextReceivingPacket(size);
				s.receive(rep);
				String receive=getMsg(rep);
				System.out.println("server said:"+receive); 
			}	
		}
		
		catch(IOException e)
		{ 
			s.close();	
			System.out.println("IOException UDPClient"); 	
		}
	}
}
