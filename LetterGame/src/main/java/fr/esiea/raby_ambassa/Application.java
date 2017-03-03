package fr.esiea.raby_ambassa;

import fr.esiea.raby_ambassa.dictionary.CommonPot;
import fr.esiea.raby_ambassa.dictionary.Dictionnary;
import fr.esiea.raby_ambassa.player.Player;
import fr.esiea.raby_ambassa.player.PlayerList;
import fr.esiea.raby_ambassa.utils.LetterGenerator;
import fr.esiea.raby_ambassa.utils.Log;
import fr.esiea.raby_ambassa.word.Word;
import fr.esiea.raby_ambassa.word.WordList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

	public static String LOG_LVL = "silent";

	private static PlayerList players;
	private static int nbPlayers;
	private static CommonPot commonPot;
	private static Dictionnary dictionnary;
	private static WordList words;

	private static BufferedReader br;
	private static char[] orderArray;
	private static boolean endOfGame = false;
	private static boolean retry = false;

	public static void main(String[] args) {

		dictionnary = Dictionnary.getInstance();
		words = WordList.getInstance();
		players = new PlayerList();
		commonPot = CommonPot.getInstance();
		br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to play Letter Game !");
		try {
			initGame();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.debug(commonPot.print());
		Log.debug(players.toString());

		int turn = 0;
		while(!endOfGame) {
            try {
                playATurn(turn);
            } catch (IOException e) {
                e.printStackTrace();
            }
            turn++;
        }

        System.out.println("Thanks to play Letter Game !");
	}
	
	private static void initGame() throws IOException{

		System.out.print("Enter number of players: ");
		try{
			nbPlayers = Integer.parseInt(br.readLine());
		}catch(NumberFormatException nfe){
			System.err.println("Invalid Format!");
		}

		orderArray = new char[nbPlayers];
		for(int i=0; i<nbPlayers; i++) {
			System.out.print("\nEnter name for player "+ (i+1)+": ");
			players.addPlayer(new Player(br.readLine()));
			char letter = LetterGenerator.getRandomLetter();
			orderArray[i] = letter;
			commonPot.addLetter(letter);
		}

		players.setPlayerOrder(orderArray);

	}

    private static void playATurn(int turn) throws IOException{
	    Player player =  players.getPlayerAt(turn%nbPlayers);
        System.out.println("It is the turn of " + player.getName() + "\n");
        for (Player Iplayer : players.getPlayers()) {
            System.out.print(words.getWordsOf(Iplayer));
        }
        commonPot.addLetter(LetterGenerator.getRandomLetter());
        commonPot.addLetter(LetterGenerator.getRandomLetter());
        do {
            retry = false;
            System.out.println(commonPot.print());
            System.out.println("Type your word (if you complete an existing word put a '-' between existing word and your added letter(s) or press 'Enter' to pass");
            String currentWord = br.readLine().toUpperCase();
            if (!currentWord.equals("")) {
                if (currentWord.contains("-")) {
                    String existingWord = currentWord.substring(0, currentWord.indexOf("-"));
                    if (words.contains(existingWord)) {
                        String newWord = existingWord.concat(currentWord.substring(currentWord.indexOf("-")+1, currentWord.length()));
                        if(finalWordTest(newWord) && commonPot.isWordAvailable(currentWord.substring(currentWord.indexOf("-")+1, currentWord.length()))) {
                            commonPot.removeLetters(currentWord.substring(currentWord.indexOf("-")+1, currentWord.length()));
                            registerNewWordForPlayer(currentWord, player);
                        } else
                            System.out.println("You don't have all required letters in the common pot... Get out !");
                    } else {
                        System.out.println("Sorry but this word isn't on the board... Get out !");
                    }
                } else {
                    if(commonPot.isWordAvailable(currentWord)) {
                        if(finalWordTest(currentWord)) {
                            commonPot.removeLetters(currentWord);
                            registerNewWordForPlayer(currentWord, player);
                        }
                    }

                    else
                        System.out.println("You don't have all required letters in the common pot... Get out !");
                }
            } else {
                System.out.println("Noob!");
            }
            System.out.println("\n");
        }while(retry);
    }

    private static void registerNewWordForPlayer(String word, Player player) {
        if(!word.contains("-")) {
            words.addWord(new Word(word, player));
        } else {
            String existingWord = word.substring(0, word.indexOf("-"));
            words.removeWord(existingWord);
            String newWord = existingWord.concat(word.substring(word.indexOf("-")+1, word.length()));
            words.addWord(new Word(newWord, player));
        }
    }

    private static boolean finalWordTest(String word) {
        if (dictionnary.isWord(word) ) {
            System.out.println("\nCongrats !");
            retry = true;
            return true;
        } else {
            System.out.println("Sorry but this word doesn't exist... Get out !");
            return false;
        }
    }


}
