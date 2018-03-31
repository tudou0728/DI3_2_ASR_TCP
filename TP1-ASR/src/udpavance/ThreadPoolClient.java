package udpavance;

public class ThreadPoolClient implements Runnable 
{
	public void run() {
		try {
			while(true) {
				new Thread(new UDPClientSpot()).start();
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{ 
			e.getStackTrace();
		}
	}
}