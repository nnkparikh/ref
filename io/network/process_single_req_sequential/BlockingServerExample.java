import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class BlockingServerExample {
	public static void main(String[] args){
		try {
			ServerSocket server = new ServerSocket(12071);
			System.out.println("waiting for connection..");
			for(;;){
				Socket connection = server.accept();
				System.out.println("connection received..");
				InputStream is = connection.getInputStream();
				BufferedReader isr = new BufferedReader(
					new InputStreamReader(is));
				String inputLine = null;
				while((inputLine = isr.readLine()) != null){
					System.out.print(inputLine);
				}
				
				System.out.println("closing connection...");
				isr.close();
				connection.close();
			}
		} catch (IOException ex){
			System.err.println(ex);
			System.exit(1);
		}
	}
}