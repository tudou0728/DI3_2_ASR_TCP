package tcpmsgl;

public class Test  
{
	public static void main(String[] args)
	{		
		int nombre=5;
		new Thread(new TCPServerLMsg(nombre)).start();
		new Thread(new TCPClientLMsg(nombre)).start();
	}
}
