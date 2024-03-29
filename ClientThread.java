package exercice2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.IOException;
import java.net.*;

public class ClientThread {
	public static void main(String[] args) throws IOException {
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String commande = "", serverMessage = "";
			
			while (!commande.equals("exit")) {
				System.out.println("Entrez une commande :");
				commande = br.readLine();
				outStream.writeUTF(commande);
				outStream.flush();
				serverMessage = inStream.readUTF();
				System.out.println(serverMessage);
			}
			outStream.close();
			outStream.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}