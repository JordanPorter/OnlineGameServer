/*import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

class GameServer {
	
	LinkedList clients = new LinkedList();
	
    public static void main (String args[]) throws Exception{
        new GameServer();
    }
    GameServer() throws Exception{
        //create welcoming socket at port 6789
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            //block on welcoming socket for contact by a client
            Socket connectionSocket = welcomeSocket.accept();
            // create thread for client
            Connection c = new Connection(connectionSocket);
        }
    }
    class Connection extends Thread{
        Socket connectionSocket;
        Connection(Socket _connectionSocket){
            connectionSocket = _connectionSocket;
            this.start();
        }
        public void run(){
            try{
                //create input stream attached to socket
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));

                Scanner clientSentence = new Scanner(inFromClient.readLine());
                clientSentence.useDelimiter(" ");
               	Client c = new Client(clientSentence.next(), connectionSocket);
               	System.out.println("Added: " + c.getName());
               	c.sendMessage("YOU SUCK");
               	clientSentence.close();
            }catch(Exception e){}
        }
    }
}*/