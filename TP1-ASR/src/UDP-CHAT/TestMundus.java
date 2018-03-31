import java.util.*;
import java.io.*;
import java.net.*;

public class TestMundus 
{
	public static void main(String[] args)
	{
		//new Thread(new UDPServer()).start();
		//new Thread(new UDPClient()).start();
		//new Thread(new UDPSeverHello()).start(); 
		//new Thread(new UDPClientHello()).start();		
		new Thread(new UDPServerTchat()).start();  
		new Thread(new UDPClientTchat()).start();	
	}
}
