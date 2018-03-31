package tcpmsg2;

public class Test //1.有点儿问题 connect reset 异常   2.现在已经没有问题了
{
	public static void main(String[] args)
	{		
		new Thread(new TCPServerMsg()).start();
		new Thread(new TCPClientMsg()).start();
	}
}
