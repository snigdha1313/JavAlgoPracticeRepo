// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.*;
import java.text.*;
import java.util.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import java.net.*;
import java.security.NoSuchAlgorithmException;

// Server class
public class Server {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

		FileOutputStream fos = new FileOutputStream(new File("log.txt"));
		PrintStream myconsole = new PrintStream(fos);

		ServerSocket ss = new ServerSocket(1904);
		SecretKey AESKey = EncryptDecrypt.generateRandomKey("AES", 128);
		SecretKey DESKey = EncryptDecrypt.generateRandomKey("DES", 56);
		IvParameterSpec AESIV = EncryptDecrypt.generateRandomIV(128);
		IvParameterSpec DESIV = EncryptDecrypt.generateRandomIV(64);
		ArrayList<Socket> users = new ArrayList<Socket>();

		/*
		 * System.out.println("AES KEY " + EncryptDecrypt.base64EncodedKey(AESKey));
		 * System.out.println("DES KEY " + EncryptDecrypt.base64EncodedKey(DESKey));
		 * System.out.println("DES IV " + EncryptDecrypt.base64EncodeIV(DESIV));
		 * System.out.println("AES IV " + EncryptDecrypt.base64EncodeIV(AESIV));
		 */
		EncryptDecrypt.output("AES KEY " + EncryptDecrypt.base64EncodedKey(AESKey), System.out, myconsole);
		EncryptDecrypt.output("DES KEY " + EncryptDecrypt.base64EncodedKey(DESKey), System.out, myconsole);
		EncryptDecrypt.output("DES IV " + EncryptDecrypt.base64EncodeIV(DESIV), System.out, myconsole);
		EncryptDecrypt.output("AES IV " + EncryptDecrypt.base64EncodeIV(AESIV), System.out, myconsole);

		while (true) {
			Socket s = null;

			try {
				s = ss.accept();
				users.add(s);

				System.out.println("A new client is connected : " + s);
				System.out.println("Assigning new thread for this client");

				// create a new thread object
				Thread t = new ClientHandler(s, AESKey, DESKey, AESIV, DESIV, myconsole, users);

				// Invoking the start() method
				t.start();

			} catch (Exception e) {
				s.close();
				e.printStackTrace();
			}
		}
	}
}

// ClientHandler class
class ClientHandler extends Thread {

	final Socket s;
	final SecretKey AESkey, DESkey;
	final IvParameterSpec AESIV, DESIV;
	final PrintStream myconsole;
	final ArrayList<Socket> users;

	// Constructor
	public ClientHandler(Socket s, SecretKey AESkey, SecretKey DESkey, IvParameterSpec AESIV, IvParameterSpec DESIV,
			PrintStream myconsole, ArrayList<Socket> users) {
		this.s = s;
		this.AESkey = AESkey;
		this.DESkey = DESkey;
		this.AESIV = AESIV;
		this.DESIV = DESIV;
		this.myconsole = myconsole;
		this.users = users;
	}

	@Override
	public void run() {

		// obtaining input and out streams
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			dos.writeUTF(EncryptDecrypt.base64EncodedKey(AESkey));
			dos.flush();
			dos.writeUTF(EncryptDecrypt.base64EncodedKey(DESkey));
			dos.flush();
			dos.writeUTF(EncryptDecrypt.base64EncodeIV(DESIV));
			dos.flush();
			dos.writeUTF(EncryptDecrypt.base64EncodeIV(AESIV));
			dos.flush();

		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String received = null;

		while (true) {

			try {
				received = dis.readUTF();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (received.equals("Disconnect")) {
				System.out.println("Client " + this.s + " sends exit...");
				System.out.println("Closing this connection.");
				try {
					this.s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Connection closed");
				break;
			}

			if (received.matches("[a-zA-Z]+")) {

				/* USERNAMES ACCEPTED BY SERVER */
				EncryptDecrypt.output(received, System.out, myconsole);

			} else {

				/* ENCRYPTED CYPHER TEXT FROM ALL CLIENTS ACCEPTED BY SERVER */
				EncryptDecrypt.output(received, System.out, myconsole);

				try {
					System.out.println("Users :"+users);
					sendMessage(received, users);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * try { dos.writeUTF(received); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); } //sendMessage(received,
				 * users);
				 */

			}

		}

		try {
			// closing resources

			dis.close();
			dos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage(String message, ArrayList<Socket> users2) throws IOException {
		// TODO Auto-generated method stub
		for (Socket s : users2) {
			System.out.println("meeessage "+message);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(message);
			dos.flush();
			//dos.close();
		}
	}
}
