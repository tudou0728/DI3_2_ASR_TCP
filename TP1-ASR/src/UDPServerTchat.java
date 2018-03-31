import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPServerTchat extends UDPSeverBuilder implements Runnable
{	
	public void run()
	{
		try 
		{
			setConnection();
			String hello="hello,I'm server";
			while(!s.isClosed())
			{
				/**le serveur recoit le message*/
				req = getTextReceivingPacket(size);
				s.receive(req);
				String receive=getMsg(req);	
				System.out.println("client said:"+receive); 
			
				/**le serveur envoie le message*/
				//sc = new Scanner(System.in);//si le serveur voudrait envoie l'autre message par "scanner"
				//String msg = sc.nextLine();
				rep = getTextSendingPacket((InetSocketAddress) req.getSocketAddress(),hello,size);
				//rep = getTextSendingPacket((InetSocketAddress) req.getSocketAddress(),msg,size);
				s.send(rep);
				System.out.println("reply sent");
			}		
			
		}
		catch(IOException e)
		{ 
			s.close();
			System.out.println("IOException UDPServerchat"); 
		}
	}
}
