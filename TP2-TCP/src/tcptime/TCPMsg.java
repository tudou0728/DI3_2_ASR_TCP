package tcptime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TCPMsg 
{
	  protected byte[] buffer;
	  
	  protected final int size = 8192;//ԭ����private ���Ҹĳ���protected
	  
	  /** The set method for the buffer. */
	  void setStreamBuffer(int size) 
	  {
		  if(size>0)
			  buffer = new byte[size];
		  else
			  buffer = new byte[this.size];
	  }
	  
	/** The (simple) text write method. */
	void writeMsg(OutputStream out, String msOut) throws IOException 
	{
		if((out!=null)&(msOut!=null)) 
		{
			fillChar(msOut);
			out.write(buffer);
			out.flush();
			clearBuffer();
		}
	}
	
	private void fillChar(String msOut) //�ڲ�������
	{
		if(msOut!=null)
		{
			if(msOut.length() < buffer.length)
			{
				for(int i=0;i<msOut.length();i++)
				{
					buffer[i] = (byte)msOut.charAt(i);
				}
			}
		}
	}
	
	void clearBuffer() //���ڲ�������
	{
		for(int i=0;i<buffer.length;i++)
		{
			buffer[i] = 0;
		}
	}
	
	/** The (simple) text read method. */
	String readMsg(InputStream in) throws IOException 
	{
		if(in != null) 
		{
			in.read(buffer); 
			count = count();
			if(count>0)
			{
				return new String(buffer,0,count);
			}
		}
		return null;
	}
	
	private int count;
	
	protected int count() //���ڲ�������
	{
		for(int i=0;i<buffer.length;i++)
			if(buffer[i] == 0)
				return i;		
			return buffer.length;
		
	}
}
