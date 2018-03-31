package tcptime;

public class Test //有问题 client第二次去连接的时候 连接被拒绝（已解决 不要关闭serversocket） 所以才会有accept timed out 
{
	public static void main(String[] args)
	{		
		new Thread(new TCPServerTimeout()).start();
		new Thread(new TCPClientTimeout()).start();
	}
}
