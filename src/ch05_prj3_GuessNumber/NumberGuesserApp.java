package ch05_prj3_GuessNumber;

import java.util.Scanner;

public class NumberGuesserApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Guess a Number App:");
		
		Scanner sc = new Scanner(System.in);
		
		int number = generateRandomNumber();
		
		boolean correctGuess = false;
		int counter = 0;
		while (!correctGuess) {
			int guess = getIntWithinRange(sc, "Enter number: ", 1, 100);
			counter++;
			int diff = guess - number;
			if (diff <= -10) {
				System.out.println("Way too low");
			}
			else if (diff >=10) {
				System.out.println("Way too high");
			}
			else if (diff <0) {
				System.out.println("Too low!");
			}
			else if (diff > 0) {
				System.out.println("Too high!");
			}
			else {
				correctGuess = true;
			}
		}
		displayCorrectGuessMessage(counter);
		
		
		
		sc.close();
		System.out.println("Bye");
	}

	private static int generateRandomNumber() {
		System.out.println("I'm thinking of a number between 1 and 100.\nTry to guess it.");
		int random = (int)(Math.random()*100)+1;
		System.out.println("* random # = "+random);
		return random;
	}
	
	private static int getInt(Scanner sc, String prompt) {
		int guessNumber = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.println(prompt);
			if (sc.hasNextInt()) {
				guessNumber = sc.nextInt();
				isValid = true;
			}
			else {
				System.out.println("Error - please enter a valid integer.");
				sc.nextLine();
			}
		}
		return guessNumber;
	}
	
	private static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		int guessNumber = 0;
		boolean isValid = false;
		while (!isValid) {
			guessNumber = getInt(sc, prompt);
			if (guessNumber >= min) {
				if (guessNumber <= max)
					isValid = true;
				else {
					System.out.println("Error:  number must be less than "+(max+1));
					continue;
				}
			}
			else {
				System.out.println("Error:  number must be greater than "+(min-1));
				continue;
			}
			
		}
		return guessNumber;	
	}
	
	private static void displayCorrectGuessMessage(int numberGuesses) {
		System.out.println("# of guesses: "+numberGuesses);
		if (numberGuesses <= 3) {
			System.out.println("Great work! You are a mathematical wizard.");
		}
		else if (numberGuesses > 3 && numberGuesses <= 7) {
			System.out.println("Not too bad! You've got some potential.");
		}
		else {
			System.out.println("What took you so long? Maybe you should take\r\n" + 
					"                       some lessons.\r\n");
		}
	}
}








