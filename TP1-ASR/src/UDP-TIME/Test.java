package udptime;

public class Test {
	public static void main(String[] args)
	{
		//new Thread(new UDPServerTime()).start(); //先打开服务器
		//new Thread(new UDPClientTime()).start();
		new Thread(new UDPServerNTP()).start(); //先打开服务器
		new Thread(new UDPClientNTP()).start();
	}

}