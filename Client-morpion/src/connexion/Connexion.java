package connexion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import utils.Requete;

public final class Connexion 
{
	private static Socket socket;
	public static Requete requete;
	public static void initialiseSocket() throws UnknownHostException, IOException
	{
		try 
		{
			socket = new Socket("127.0.0.1",1234);
			requete = new Requete(socket);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
