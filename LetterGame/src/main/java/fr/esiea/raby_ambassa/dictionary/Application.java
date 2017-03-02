package fr.esiea.raby_ambassa.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

	public static String LOG_LVL = "debug";
	private static PlayerList players;
	private static int nbPlayers;

	public static void main(String[] args) throws IOException{
		Dictionnary dico = Dictionnary.getInstance();
		players = new PlayerList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number of players: ");
		try{
			nbPlayers = Integer.parseInt(br.readLine());
		}catch(NumberFormatException nfe){
			System.err.println("Invalid Format!");
		}
		for(int i=0; i<nbPlayers; i++) {
			System.out.print("Enter name for player "+ (i+1)+": ");
			players.addPlayer(new Player(br.readLine()));
		}

        Log.debug(players.toString());
	}
}
