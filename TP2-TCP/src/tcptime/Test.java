package tcptime;

public class Test //������ client�ڶ���ȥ���ӵ�ʱ�� ���ӱ��ܾ����ѽ�� ��Ҫ�ر�serversocket�� ���ԲŻ���accept timed out 
{
	public static void main(String[] args)
	{		
		new Thread(new TCPServerTimeout()).start();
		new Thread(new TCPClientTimeout()).start();
	}
}
