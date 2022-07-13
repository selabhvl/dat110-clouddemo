package no.hvl.dat110.echo.tcpserver;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {
	
	public static void main(String[] args) {
		
		int serverport = Configuration.SERVERPORT;
		
		if (args.length > 0) {			
			
			serverport = Integer.parseInt(args[0]);
		}
		
		System.out.println("TCP server starting # " + serverport);
		
		try (ServerSocket welcomeSocket = new ServerSocket(serverport)) {
				
			TCPEchoServer server = new TCPEchoServer(welcomeSocket);

			while (true) {
				
				server.process();
				
			}
			
		} catch (IOException ex) {
			System.out.println("TCP server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
