package udpavance;

import java.util.Random;

public class Test 
{
	public static void main(String[] args)
	{
		new Thread(new UDPServer()).start();
		new Thread(new ThreadPoolServer()).start();  
		new Thread(new ThreadPoolClient()).start();
	}

}
