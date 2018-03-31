package tcpmsg;

public class Test //没有问题了
{
	public static void main(String[] args)
	{		
		new Thread(new TCPServerMsg()).start();
		new Thread(new TCPClientMsg()).start();
	}
}
