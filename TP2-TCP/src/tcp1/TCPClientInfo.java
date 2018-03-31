package tcp1;

import java.net.SocketAddress;

class TCPClientInfo extends TCPClientBuilder implements Runnable
{
	public void run() 
	{
		try 
		{
			while(true)
			{
				setSocket(); 
				sInfo("The client sets the passive socket",s);
				setSocket();
				sInfo("The client sets the connexion",s);
				s.close(); 
				sInfo("The client closes a connexion",s);
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{ System.out.println("Exception TCPServerInfo"); }
	}

}
