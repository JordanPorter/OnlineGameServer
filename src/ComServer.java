import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


public class ComServer {

	LinkedList<Client> clients = new LinkedList<Client>();
	
	public ComServer() throws Exception	{
		//create welcoming socket at port 6789
        ServerSocket welcomeSocket = null;

		welcomeSocket = new ServerSocket(6789);

		//block on welcoming socket for contact by a client
        Socket connectionSocket = welcomeSocket.accept();
        // create thread for client
        clients.add(new Client(connectionSocket));
        broadcast("User Connected");
	}
	
	public void broadcast(String message)	{
		for(Client c : clients)	{
			c.sendMessage(message);
		}
	}
	
	
	public static void main(String[] args) throws Exception	{
		new ComServer();
	}
	
}
