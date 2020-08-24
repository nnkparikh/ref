import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

class ThreadedServerExample {
	public static void main(String[] args){
		try {
			ServerSocket server = new ServerSocket(12071);
			System.out.println("waiting for connection..");
			for(;;){
				Socket connection = server.accept();
				Runnable r = new ServeRequest(connection);
				(new Thread(r)).start();
			}
		} catch (IOException ex){
			System.err.println(ex);
			System.exit(1);
		}
	}
}