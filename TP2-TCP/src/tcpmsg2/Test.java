package tcpmsg2;

public class Test //1.�е������ connect reset �쳣   2.�����Ѿ�û��������
{
	public static void main(String[] args)
	{		
		new Thread(new TCPServerMsg()).start();
		new Thread(new TCPClientMsg()).start();
	}
}
