package udpavance;

public class ThreadPoolServer implements Runnable 
{
	public void run() {
		try {
			while(true) {
				new Thread(new UDPServerScan()).start();
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
}
