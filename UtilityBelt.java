/**
* This class provides several useful static methods and is part of the CS111 course material
* MiraCosta College 2020
*
* @author Nery Chapleton-Lamas <nery@miracosta.edu>
* @author Gabriel Siguenza <gebsiguenza@gmail.com>
*
* @version 1.0
**/

import java.util.Scanner;

public class UtilityBelt
{
	private static Scanner keyboard = new Scanner(System.in); //used by all methods, MUST be kept clean

	/**
	* Centers and prints text value within total width (like width in printf) given for one line,
	* ends with new line
	*
	* @param width minimum width for one line, assuming width is greater than text length
	* @param text string value to be displayed in centered format
	**/
	public static void printCentered(int width, String text)
	{
		
		int leftWidth; //number of space left of text, plus text length
		String spec; //format specified for text

		leftWidth = (width + text.length() ) / 2;
		spec = "%" + leftWidth + "s"; //automatically right justified

		System.out.printf(spec + "%n", text);
	}

	/**
	* Reads input from user until valid integer value entered (error-checked using bounds)
	*
	* @param prompt string value containing the question to ask user for input (assuming in format "question: ")
	* @param lower an integer for the lower bounds for input, assume lower < upper
	* @param upper an integer for the upper bounds for input, assume upper > lower
	*
	* @return returns integer value between lower and upper (inclusive)
	**/
	public static int readInt(String prompt, int lower, int upper) {
		String temp;
		int result = 0;
		boolean isNotValid;
	
		do {
			System.out.print(prompt);
	
			// Ensure input is available before reading
			if (!keyboard.hasNextLine()) {
				System.out.println("ERROR: No input available.");
				return lower; // Return a safe default value
			}
	
			temp = keyboard.nextLine();
	
			try {
				result = Integer.parseInt(temp);
				isNotValid = (result < lower) || (result > upper);
	
				if (isNotValid) {
					System.out.println("ERROR: Please enter a value between " + lower + " - " + upper);
				}
			} catch (NumberFormatException nfe) {
				System.out.println("ERROR: Integer input is required.");
				isNotValid = true; // Force loop to repeat
			}
	
		} while (isNotValid);
	
		return result;
	}
	/**
	* Reads input from user until valid double value entered (error-checked using bounds)
	*
	* @param prompt string value containing the question to ask user for input (assuming in format "question: ")
	* @param lower an double for the lower bounds for input, assume lower < upper
	* @param upper an double for the upper bounds for input, assume upper > lower
	*
	* @return returns double value between lower and upper (inclusive)
	**/
	public static double readDouble(String prompt, double lower, double upper)
	{
		String temp;
		double result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			
			try
			{
				result = Double.parseDouble(temp);
				isNotValid = (result < lower) || (result > upper);
				
				if(isNotValid)
				{
					System.out.println("ERROR: please enter value between " + lower + " - " + upper);
				}
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("ERROR: double input is required");
			}
		} while(isNotValid);


		return result;
	}


	/**
	* Reads input from user until valid char value entered (error-checked using validChars)
	*
	* @param prompt string value containing the question to ask user for input (assuming in format "question: ")
	* @param validChars string value containing exhaustive list of all valid chars (i.e., "YyNn")
	*
	* @return returns char value within validChars provided
	**/
	public static char readChar(String prompt, String validChars)
	{
		String temp;
		char result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			try
			{
				result = temp.charAt(0);
				isNotValid = validChars.indexOf(result) == -1;
			
				if(isNotValid)
				{
					System.out.println("ERROR: please enter one of the following valid characters: " + validChars);
				}
			}
			catch(StringIndexOutOfBoundsException sOutOfBounds)
			{
				System.out.println("ERROR: input type does not match");
			}
		} while(isNotValid);


		return result;
	}
}
