package udptime;

public class Test {
	public static void main(String[] args)
	{
		//new Thread(new UDPServerTime()).start(); //�ȴ򿪷�����
		//new Thread(new UDPClientTime()).start();
		new Thread(new UDPServerNTP()).start(); //�ȴ򿪷�����
		new Thread(new UDPClientNTP()).start();
	}

}