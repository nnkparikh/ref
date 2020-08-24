import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class ServeRequest implements Runnable {
	private Socket connection = null;
	public ServeRequest(Socket connection){
		this.connection = connection;
	}

	public void run(){
		try {
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
		} catch (IOException ex){
			System.err.println(ex);
			System.exit(1);
		}
	}
}