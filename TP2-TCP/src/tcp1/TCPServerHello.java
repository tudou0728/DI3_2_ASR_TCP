package tcp1;

public class TCPServerHello extends TCPServerBuilder implements Runnable	
{
	public void run() 
	{
		try 
		{
			while(true)
			{
				System.out.println("TCPServer launched ...");
				setSocket();
				System.out.println("Hello, the server accepts");//������ȷ���Ѿ��յ�����Ϣ
				s.close(); 
				ss.close();
			}
		}
		
		catch(Exception e)
		{ System.out.println("Exception TCPServerHello"); }
	}

}
