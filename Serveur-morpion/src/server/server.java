package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


 
public class server implements Runnable
{
	private int id_joueur=1;
	protected static ServerSocket sockserv;
	
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		sockserv = new ServerSocket(1234);
		server serv = new server();
		serv.run();
		
	}
	@Override
	public void run() 
	{
		while(true)
		{	
			Socket sockcli;
			try 
			{
				sockcli = sockserv.accept();
				System.out.println("Connecté");
				Route route = new Route(new Requete(sockcli),id_joueur);
				route.start();
				id_joueur++;
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
