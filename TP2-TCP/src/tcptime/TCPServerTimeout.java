package tcptime;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class TCPServerTimeout extends TCPServerBuilder implements Runnable 
{
	private ServerSocket ss;	
	private Socket s;
	
	public void run() 
	{
		try 
		{
			ss = new ServerSocket(8085); 
			ss.setSoTimeout(10000);
			int i=0;			
			while(i<2) 
			{			
				s = ss.accept();
				new Thread(new ServerTimeout(s)).start();
				i++;

			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace(); 
			
		}
	}
}

class ServerTimeout  extends TCPServerBuilder implements Runnable 
{
	ServerTimeout(Socket s) 
	{this.sBuilder = s;}
	
	public void run() 
	{
		try 
		{
			sBuilder.setSoTimeout(1000);
			
			/** read operation, to do … */
			String server=null;
			setSocket(server,size);
			sBuilder=ssBuilder.accept();
			InputStream in=sBuilder.getInputStream();
			server=readMsg(in);		
			in.close();
			//ssBuilder.close();
			sBuilder.close();//子进程要关闭socket 但不要关闭serversocket
			System.out.println("server receive:"+sBuilder);//打印了一次
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
	}
}