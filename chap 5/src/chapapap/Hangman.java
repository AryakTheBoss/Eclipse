///////////////////////////////////////////////////////////////////////////////
// Title:            Hangman
// Files:            Hangman.java
//////////////////////////// 80 columns wide //////////////////////////////////
package chapapap;
import java.util.*;

/**
 * This program implements the word guessing game called Hangman.
 *
 * <p>Bugs: none known
 *
 * @author CS302, 2009,2012 modified by Jim Skrentny
 */
public class Hangman {
	
	//////////////////////////////////////////////////////////////////////
	// 1. CLASS VARIABLE
	//////////////////////////////////////////////////////////////////////
	private static String [] words =   //choose secret word from these
	{"geography", "cat", "yesterday", "java", "truck", "opportunity",
		"fish", "token", "transportation", "bottom", "apple", "cake",
		"remote", "pocket", "terminology", "arm", "cranberry", "tool",
		"caterpillar", "spoon", "watermelon", "laptop", "toe", "toad",
		"fundamental", "capitol", "garbage", "anticipate", "apple"};
	
	
	
	//////////////////////////////////////////////////////////////////////
	// 2. INSTANCE VARIABLES
	//////////////////////////////////////////////////////////////////////
	private String secretWord;       // the chosen secret word
	private ArrayList<Character> correctLetters;   // correct guesses
	private ArrayList<Character> incorrectLetters; // incorrect guesses

	private Scanner stdin = new Scanner(System.in); // for user input
	
	
	
	//////////////////////////////////////////////////////////////////////
	// 3. CONSTRUCTOR
	//////////////////////////////////////////////////////////////////////
	/**
	 * Constructs a Hangman game.
	 */
	public Hangman() {
		//REMOVE LINE BELOW WHEN DONE TESTING
		//this.secretWord = "miscellaneous";

		//Randomly choose a word from list of words
		//UNCOMMENT LINES BELOW TO PLAY WHEN DONE TESTING
		Random randIndex = new Random();
		int index = randIndex.nextInt(Hangman.words.length);
		this.secretWord = Hangman.words[index];
		
		this.correctLetters = new ArrayList<Character>();
		for (int i = 0; i < this.secretWord.length(); i++)
			this.correctLetters.add('_');
		this.incorrectLetters = new ArrayList<Character>();
	}
	
	
	
	//////////////////////////////////////////////////////////////////////
	// 4. PUBLIC INSTANCE METHODS
	//////////////////////////////////////////////////////////////////////
	
	/**
	 * playGame
	 *
	 * Play one game of Hangman until
	 * the user wins (guesses all of the letters in the secret word)
	 * or loses (guesses 7 incorrect letters):
	 */
	public void playGame() {
		
		while (!gameOver()) {
			
			//Print the Hangman picture
			printHangman();
			
			//Print the correct guesses in the secret word
			for (int i = 0; i < this.correctLetters.size(); i++)
				System.out.print(this.correctLetters.get(i) + " ");
			
			//Print the incorrect letters that have been guessed
			System.out.print("\nWrong letters: ");
			for (int i = 0; i < this.incorrectLetters.size(); i++)
				System.out.print(this.incorrectLetters.get(i) + " ");
			
			//Prompt and read the next guess
			System.out.print("\nEnter a lower-case letter as your guess: ");
			String guess = stdin.nextLine();
			
			//Process the next guess
			handleGuess(guess.charAt(0));
		}
		
		System.out.println("The secret word was: " + secretWord);
		if (gameWon()) {
			System.out.println("Congratulations, you won!");
		} else {
			System.out.println("Sorry, you lost.");
			printHangman();
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////////
	// 5. PRIVATE INSTANCE METHODS (HELPERS)
	//////////////////////////////////////////////////////////////////////
	
	/**
	 * handleGuess
	 *
	 * If the guessed letter (parameter ch) is in the secret word
	 * then add it to the array list of correct guesses and tell the user
	 *      that the guess was correct;
	 * otherwise, add the guessed letter to the array list of incorrect
	 *      guesses and tell the user that the guess was wrong.
	 *
	 * @param ch the guessed letter
	 */
	private void handleGuess(char ch) {
		
		/////////////////////////
		// TODO FILL IN CODE HERE
		/////////////////////////
	}

	/**
	 * gameWon
	 *
	 * Return true if the user has won the game;
	 * otherwise, return false.
	 *
	 * @return true if the user has won, false otherwise
	 */
	private boolean gameWon() {
		
		/////////////////////////
		// TODO FILL IN CODE HERE
		/////////////////////////
		
		// NOTE: THE LINE BELOW IS SO THE CODE WILL COMPILE
		// Replace it with appropriate code for your implementation
		return false;
	}
	
	/**
	 * gameLost
	 *
	 * Return true if the user has lost the game;
	 * otherwise, return false.
	 *
	 * @return true if the user has lost, false otherwise
	 */
	private boolean gameLost() {
 
		/////////////////////////
		// TODO FILL IN CODE HERE
		/////////////////////////
		
		// NOTE: THE LINE BELOW IS SO THE CODE WILL COMPILE
		// Replace it with appropriate code for your implementation
		return false;
	}
	
    /**
     * gameOver
     *
     * Return true if the user has either won or lost the game;
     * otherwise, return false.
     *
     * @return true if the user has won or lost, false otherwise
     */
    private boolean gameOver() {

		/////////////////////////
		// TODO FILL IN CODE HERE
		/////////////////////////
		
		// NOTE: THE LINE BELOW IS SO THE CODE WILL COMPILE
		// Replace it with appropriate code for your implementation
		return false;
    }
	
	/**
	 * printHangman
	 *
	 * Print the Hangman that corresponds to the given number of
	 * wrong guesses so far.
	 *
	 * @param numWrong number of wrong guesses so far
	 */
	private void printHangman() {
		int poleLines = 6;   // number of lines for hanging pole
		System.out.println("  ____");
		System.out.println("  |  |");
		
		int badGuesses = this.incorrectLetters.size();
		if (badGuesses == 7) {
			System.out.println("  |  |");
			System.out.println("  |  |");
		}
		
		if (badGuesses > 0) {	    	   
			System.out.println("  |  O");
			poleLines = 5;
		}
		if (badGuesses > 1) {
			poleLines = 4;
			if (badGuesses == 2) {
				System.out.println("  |  |");
			} else if (badGuesses == 3) {
				System.out.println("  | \\|");
			} else if (badGuesses >= 4) {
				System.out.println("  | \\|/");
			}
		}
		if (badGuesses > 4) {
			poleLines = 3;
			if (badGuesses == 5) {
				System.out.println("  | /");
			} else if (badGuesses >= 6) {
				System.out.println("  | / \\");
			}
		}
		if (badGuesses == 7) {
			poleLines = 1;
		}

		for (int k = 0; k < poleLines; k++) {
			System.out.println("  |");
		}
		System.out.println("__|__");
		System.out.println();
	}
	
	
	
	//////////////////////////////////////////////////////////////////////
	// 6. FOR TESTING PURPOSE ONLY
	//////////////////////////////////////////////////////////////////////
	
	/**
	 * toString
	 * 
	 * Returns a string representation of the Hangman object.
	 * Note that this method is for testing purposes only!
	 * @return a string representation of the Hangman object
	 */
	public String toString() {
		String s = "secret word: " + this.secretWord;
		
		s += "\ncorrect letters: ";
		for (int i = 0; i < this.correctLetters.size(); i++)
			s += this.correctLetters.get(i) + " ";
		
		s += "\nused letters: ";
		for (int i = 0; i < this.incorrectLetters.size(); i++)
			s += this.incorrectLetters.get(i) + " ";
		
		s += "\n# bad letters: " + this.incorrectLetters.size();
		
		return s;
	}
	
    private void setCurrentWord(String newWord) {
        this.secretWord = newWord;
    }
    
    private void setCorrectLetters(ArrayList<Character> newGuesses) {
        this.correctLetters = newGuesses;
    }
    
    private void setIncorrectLetters(ArrayList<Character> newUsedLetters) {
        this.incorrectLetters = newUsedLetters;
    }
	
    private void setBadGuesses(int newBadGuesses) {
    	this.incorrectLetters.clear();
    	for (int i = 0; i < newBadGuesses; i++) {
    		this.incorrectLetters.add('x');
    	}
    }
	
	//////////////////////////////////////////////////////////////////////
	// 7. PUBLIC CLASS METHOD - MAIN
	//////////////////////////////////////////////////////////////////////
	
	public static void main(String [] args) {

        /* Note initially the constructor sets the secret word to:
         * "miscellaneous".  Be sure to update the constructor when
         * you're ready to play the game.
         */
		
		Hangman game = new Hangman();
		
        /* 
         * A. Testing the constructor
         *
         * To test the constructor, we use the toString method
         * to see if the data members are as expected.
         *

        System.out.println("The CONSTRUCTED game is:\n" + game);
       	System.out.println("\n======== END CONSTRUCTOR TEST  ========\n");
        // */
        
        /*
         * B. Testing gameWon
         *
         
        if (game.gameWon()) 
        	System.out.println("Game should not be won at beginning");
        
        String str = "miscellaneous";
        game.setCurrentWord(str);
        ArrayList<Character> guesses = new ArrayList<Character>();
        
        for (int i = 0; i < str.length(); i++)
        	guesses.add(str.charAt(i));
        game.setCorrectLetters(guesses);
        
        if (!game.gameWon()) {
        	System.out.println(game);
           	System.out.println("Game should be won");     	
        }
  
        for (int i = 0; i < str.length(); i += 3) 
        	guesses.set(i, '_');
        game.setCorrectLetters(guesses);
        
        if (game.gameWon()) {
        	System.out.println(game);
        	System.out.println("Game should NOT be won");
        }
        
       	System.out.println("\n========   END gameWon TEST    ========\n");
       // */
        
        /*
         * C. Testing gameLost
         *
        
        game = new Hangman();  // start with a new game
 
        if (game.gameLost()) 
        	System.out.println("Game should not be lost at beginning");
        
        game.setBadGuesses(3);
        if (game.gameLost()) {
        	System.out.println(game);
        	System.out.println("Game should not be lost");
        }
        	
        game.setBadGuesses(7);
        if (!game.gameLost()) {
            System.out.println(game);
        	System.out.println("Game should be lost");  
        }
 
        game.setBadGuesses(10);
        if (!game.gameLost()) {
            System.out.println(game);
        	System.out.println("Game should be lost");
        }
        
       	System.out.println("\n========   END gameLost TEST   ========\n");
        // */  
        
        /*
         * D. Testing gameOver
         *
         * Add your own similar tests as above.
         * 


       	System.out.println("\n========   END gameOver TEST   ========\n");
        // */  
        
        
        /*
         *  E. Testing handleGuess
         *
        
        game = new Hangman();  // start with a new game
        System.out.println(game);
        
        game.handleGuess('a');  // check a letter in the word
        System.out.println(game);
        
        game.handleGuess('q');  // check a letter not in the word
        System.out.println(game);
        
        game.handleGuess('m');  // check for first letter in word
        System.out.println(game);
        
        game.handleGuess('l');  // check a letter that appears more than once
        System.out.println(game);
        
        game.handleGuess('s');  // check last letter in word
        System.out.println(game);
        
        game.handleGuess('x');  // check another letter not in word
        System.out.println(game);
       	System.out.println("\n======== END handleGuess TEST  ========\n");
        // */
        
    	/* F. Test the playGame method
    	 * Do this after all the private methods have been tested.
    	 *
    	
        game = new Hangman();  // start with a new game
        game.playGame();
        // */
	}
	
}