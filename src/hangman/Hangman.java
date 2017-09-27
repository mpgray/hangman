package hangman;

public class Hangman {

	private String theMan(int lives){
		String theMan = "      ";
		switch(lives){
		case 6: 
			theMan = "      ";
			break;
		case 5:
			theMan = "0     ";
			break;
		case 4:
			theMan = "0|    ";
			break;
		case 3:
			theMan = "0|/   ";
			break;
		case 2:
			theMan = "0|/\\  ";
			break;
		case 1:
			theMan = "0|/\\/ ";
			break;
		default:
			theMan = "0|/\\/\\";
			break;
		}
		
		return theMan;
	}
	public void gallows(int lives){
		String theMan = theMan(lives);
		System.out.println(" ;--,");
		System.out.println(" |  " + theMan.charAt(0));
		System.out.println(" | " + theMan.charAt(2) + theMan.charAt(1) + theMan.charAt(3));
		System.out.println(" | " + theMan.charAt(4) + " " + theMan.charAt(5));
		System.out.printf("_|______  ");
	}
	
}
