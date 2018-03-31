package tcp1;

class TCPClientHello extends TCPClientBuilder implements Runnable 
{
	public void run() 
	{
		try 
		{
			while(true)
			{
				System.out.println("TCPClientHello launched ...");
				setSocket();
				System.out.println("Hello, the client is connected");
				s.close();
			}
		}
		
		catch(Exception e)
		{ System.out.println("Exception TCPClientHello"); }
	}
}
