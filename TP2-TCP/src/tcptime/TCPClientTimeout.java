package tcptime;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClientTimeout extends TCPClientBuilder implements Runnable 
{	
	private Socket s;

	public void run() 
	{
		try 
		{
			s = new Socket("localhost",8085); 
			s.setSoTimeout(10000);
			int i=0;
			while(i<2)  
			{
				new Thread(new ClientTimeout(s)).start();
				i++;
			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
	}
}

class ClientTimeout extends TCPClientBuilder implements Runnable 
{
	ClientTimeout(Socket s) 
	{this.sBuilder = s;}
	
	public void run() 
	{
		try 
		{
			sBuilder.setSoTimeout(1000);
			
			/** write operation, to do … */
			String client="bonjour, je suis client.";
			setSocket(client,size);
			OutputStream out = sBuilder.getOutputStream();//应该是对应的socket的输出流
			writeMsg(out,client);
			out.close();
			sBuilder.close();//子进程要关闭socket
			
			System.out.println("client sends:"+sBuilder);//打印了一次			
			
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
}