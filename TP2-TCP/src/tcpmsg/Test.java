package tcpmsg;

public class Test //û��������
{
	public static void main(String[] args)
	{		
		new Thread(new TCPServerMsg()).start();
		new Thread(new TCPClientMsg()).start();
	}
}
