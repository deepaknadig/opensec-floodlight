import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EventListener {
	public EventListener(Implementer implementer) {
			//This guy listens on port 8000 to messages sent by the processing units
	        Runnable serverTask = new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    ServerSocket serverSocket = new ServerSocket(8000);
	                    System.out.println("Waiting for clients to connect...");
	                    while (true) {
	                    	String inputLine;
	                        Socket clientSocket = serverSocket.accept();
	                        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
	                        while ( (inputLine = input.readLine()) != null) {
	                        	implementer.dealWith(inputLine);
	                        }
	                    }
	                } catch (IOException e) {
	                    System.err.println("Unable to process client request");
	                    e.printStackTrace();
	                }
	            }
	        };
	        Thread serverThread = new Thread(serverTask);
	        serverThread.start();
	}
}
