import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class Client extends Thread{

	private Socket s;
	private String name;
	private BufferedReader br;
	private PrintWriter pw;
	
	public Client(Socket connectionSocket) throws IOException	{
		s = connectionSocket;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(s.getOutputStream());
		this.start();
	}
	
	public void run()	{
		try {
			while(!s.isClosed()){
				String incoming = br.readLine();
				System.out.println(incoming);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message)	{
		pw.write(message + "\r\n");
		pw.flush();
	}
	
	public void close()	{
	}
	
	public OutputStream getOutputStream() throws IOException	{
		return s.getOutputStream();
	}
}
