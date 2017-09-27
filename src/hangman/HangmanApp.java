package hangman;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class HangmanApp {
	private static Scanner scanner = new Scanner(System.in);;
	public static void main(String[] args) {
	    //start with 6 lives, dead at 0
		int lives = 6;
		//Words randomly selected to be entered.
		String[] words = {"Classical",
		                  "Latin",
		                  "Trance",
		                  "Rap",
		                  "Country",
		                  "Rock",
		                  "Opera",
		                  "Pop",
		                  "Folk",
		                  "Dubstep"
						};
		//randomly select word from the array
		int rnd = new Random().nextInt(words.length);
	    String answer =  words[rnd]; 
	    answer = answer.toLowerCase();
	    
	    char[] letters = answer.toCharArray();
	    char[] guessboard = new char[answer.length()];
	    String blank = "_";
	    for(int i = 0; i <  guessboard.length; i++){
	    	guessboard[i] = blank.charAt(0);
	    }
	    char charGuess;
	    boolean win = false;
		String guess = "";
		Hangman man = new Hangman();
		do{
		
			boolean correct = false;
			man.gallows(lives);
			for(int i = 0; i < guessboard.length; i++){
				System.out.print(guessboard[i] + " ");
			}
			try{
				System.out.print("\nEnter a guess: ");
				guess = scanner.next();
			}catch(InputMismatchException exception)
			{
				System.out.println("Not what we are looking for input-wise.");
			}
			
			//check if guess is a letter.
			if (Character.isLetter(guess.charAt(0)) && guess.length() == 1){
				guess = guess.toLowerCase();
				charGuess = guess.charAt(0);
				for(int i = 0; i < letters.length; i++){
					if(letters[i] == charGuess){
						correct = true;
						guessboard[i] = charGuess;
					}
				}
				if(correct == false){
					lives--;
				}
			    for(int i = 0; i <  guessboard.length; i++){			    	
			    	if(guessboard[i] == blank.charAt(0)){
			    		win = false;
			    		break;
			    	}
			    	else{
			    		win = true;
			    	}
			    }
			}
			else{
			  System.out.println("That is not a valid guess.");
			}
		}while (lives != 0 && win == false);
		scanner.close();
		man.gallows(lives);
		for(int i = 0; i < guessboard.length; i++){
			System.out.print(guessboard[i] + " ");
		}
		if(lives == 0){
			System.out.println("\nYou lost!");

		}
		if(win){
			System.out.println("\nYou Won! The Word was: " + answer);
		}
	}

}
