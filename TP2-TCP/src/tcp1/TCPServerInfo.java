package tcp1;

class TCPServerInfo extends TCPServerBuilder implements Runnable 
{
	public void run( ) 
	{
		try 
		{
			while(true)
			{
				setSocket(); 
				ssInfo("The server sets the passive socket", ss);
				s = ss.accept(); 
				sInfo("The server accepts the connexion",s);
				s.close(); 
				sInfo("The server closes a connexion",s);
				ss.close(); 
				ssInfo("The server closes the passive socket", ss);
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{ System.out.println("Exception TCPServerInfo"); }
	}
}
