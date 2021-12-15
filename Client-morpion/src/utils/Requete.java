package utils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Requete
{
	private Socket socketcli;
	private DataInputStream in;
	private DataOutputStream out;
	public boolean waitResponse = false;
	public Requete(Socket socketcli)
	{
		this.socketcli = socketcli;
		
		try
		{
			this.out = new DataOutputStream(socketcli.getOutputStream());
			this.in= new DataInputStream(socketcli.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Socket getSocket() {return this.socketcli;}
	public void Write(String query)
	{
		try 
		{
			waitResponse = true;
			this.out.write(query.getBytes());
			
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String read()
	{
		byte[]b = new byte[80];
		try 
		{
			this.in.read(b,0,80);
			String regExp="\u0000*$";
			String reponse = new String(b, StandardCharsets.UTF_8);
			String[] reponse_a_trier= reponse.split(regExp);
			reponse = reponse_a_trier[0];
			return reponse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
