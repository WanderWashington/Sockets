package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	private String host;
	private int porta;
	private String nome;

	public Cliente(String host, int porta) {
		this.host = host;
		this.porta = porta;
	
		
	}

	public void executa() throws UnknownHostException, IOException {
		Scanner nick= new Scanner(System.in);
		System.out.print("Digite o nome de usuário :");
		nome= nick.nextLine();
		try(Socket cliente = new Socket(this.host, this.porta); 
				Scanner teclado = new Scanner(System.in); 
				PrintStream saida = new PrintStream(cliente.getOutputStream())) {
			System.out.println("O cliente se conectou ao servidor!");
	
			MsgServidor r = new MsgServidor(cliente.getInputStream());
			new Thread(r).start();
	
			while (teclado.hasNextLine()) {
				saida.println(nome+" diz:"+teclado.nextLine());
			}
		}
	}
}