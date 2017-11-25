package chat;


import java.io.IOException;
import java.net.UnknownHostException;

public class RodaCliente {
	public static void main(String[] args) 
			throws UnknownHostException,	IOException {
		new Cliente("172.16.1.244", 12345).executa();
	}
}