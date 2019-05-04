//************************************************************************
//  Snake.java       Author: Em Powers
//
//  Engages a two-player dice game called Snake between the
//  user and the computer. 
//************************************************************************

import java.util.Scanner; 

/**
 * 1. Creates two dice objects. 
 * 		a. dieone
 * 		b. dietwo
 * 2. Prints out initial line welcoming user to the game of Snake. 
 * 3. Creates all-encompassing "do" loop that switches between the
 * 		user and computer turns. 
 * 		a. Inputs conditionals to keep loop running until the game ends.
 * 4. Creates "do" loop for user. 
 * 		a. Inputs conditionals to keep loop running until conditionals are met.
 * 5. Creates "if" loop for user. 
 * 		a. Checks if either of the two dice values are one, creating "snake eyes."
 * 		b. If this conditional is met, the user's turn ends and the computer's turn starts.
 * 6. Creates "else-if" loop for user.
 * 		a. Checks if both of the dice values are not one. 
 * 		b. Accumulates the player's score until "snake eyes" are engaged OR the user 
 * 			inputs "r" to hold their accumulated dice points. 
 * 7. Creates two "if" loops for user. 
 * 		a. Checks if character is an "r" or an "h."
 * 		b. If "r," the dice are rolled again and the "if-else" loop engages.
 * 		c. If "h," the user's turn ends with the sum of dice from the turn kept. 
 * 8. Creates "if" loop to check to see if the user accumulated 100 points.
 * 		a. If the user accumulated 100 points, the game ends and does not 
 * 			continue to the computer's turn. 
 * 9. Creates "do" loop for computer. 
 * 		a. Inputs conditionals to keep loop running until conditionals are met.
 * 10. Creates "if" loop for computer. 
 * 		a. Checks if the user accumulated 100 points and only engages the loop if the user did not. 
 * 11. Creates "if" loop for computer. 
 * 		a. Checks if either of the two dice values are one, creating "snake eyes."
 * 		b. If this conditional is met, the computer's turn ends and the user's turn starts.
 * 12. Creates "else-if" loop for computer. 
 * 		a. Checks if both of the dice values are not one. 
 * 		b. Accumulates the computer's score until "snake eyes" are engaged OR until 
 * 			the computer reaches 20 points. 
 * 7. Creates "if" loop for computer. 
 * 		a. Checks if computer reached 100 points and announces that the game is won
 * 		   if the value is met. 
 * 
 * 
 * @return turnscore, aiturnscore, yourturnscore.
 */ 

public class Snake {

	public static void main(String[] args) {
		
		PairOfDice dieone, dietwo;
		dieone = new PairOfDice();
		dietwo = new PairOfDice();
		int turnscore = 0;
		int aiturnscore = 0;
		int yourturnscore = 0;
		int winvalue = 100; 
		int turnovervalue = 1;
		Scanner sc = new Scanner(System.in); 
		boolean humanturn = true;
		boolean computerturn = true;
		boolean gameover = false;

		System.out.println("Welcome to the game of Snake!");
		
	    /** Creates a master "do" loop to iterate between the user's and the computer's turns 
	     *  as long as the Snake game is running. 
	     */
		
		do {
			
			/** Creates a "do" loop to iterate the user's turn as long as either Snake Eyes (rolling 1 on
			 *  either die) or inputting the character 'r' is not met. 
			 */
				do
				{
					// Rolls the two dice and prints out their values. 
					
					int firstRoll = dieone.roll(); 
					int secondRoll = dietwo.roll();
					System.out.println("You rolled: " + firstRoll + " and " + secondRoll);	
					
					/** Creates an "if" loop to check if the user rolled Snake Eyes 
					 * 	on their dice rolls, and uses the sentinel value turnovervalue
					 *  to end the loop and the boolean value computerturn to start the
					 *  computer AI's turn. 
					 */
					
				if (firstRoll == 1 || secondRoll == 1)
					{
						System.out.println("You lose your turn!");
						System.out.println("Your turn score is " + yourturnscore);
						turnovervalue = 1;
						computerturn = true; 
						} 
				
				/** Creates an "else if" loop to check if the user did not get Snake Eyes 
				 * 	on their dice rolls, and prompts the user if they want to roll 
				 * 	the dice again by inputting the character 'r' or hold their current
				 * 	dice value by inputting the character 'h'.
				 */
					else if (firstRoll != 1 || secondRoll != 1)		
						{
							turnscore += (firstRoll + secondRoll);
							yourturnscore += (firstRoll + secondRoll);
							System.out.println("Your turn score is " + yourturnscore);
							System.out.println("If you hold, you will have " + yourturnscore + " points.");
							System.out.println("Enter 'r' to roll again, 'h' to hold.");
							char ch = sc.next().charAt(0);
							
							// Creates an if-loop to roll dice again if the user inputted 'r'. 
							
							if (ch == 'r')
								{
									firstRoll = dieone.roll(); 
									secondRoll = dietwo.roll();
								}
							
							// Creates an if-loop to end user turn if the user inputted 'h'. 
							
							if (ch == 'h')
								{
									System.out.println("Your turn score is " + yourturnscore);
									turnovervalue = 1; 
									computerturn = true;	
								} 
						}
				
				// Creates an if-loop to check to see if the user scored more than 100 points, ending the game.
				
					if (yourturnscore >= 100 )
					{
						System.out.println("YOU WIN");
						gameover = true;
					}
				} while (humanturn = true && turnovervalue != 1 && yourturnscore <= winvalue);	
				
				
				/** Creates a "do" loop to iterate the computer's turn as long as either Snake Eyes (rolling 1 on
				 *  either die) or the computer reaching more than 20 points isn't met. 
				 */
		do
		{

			/** Creates an "if" loop to check if the user rolled 100 on their turn already
			 *  and to not iterate the AI "do" loop if that's the case. 
			 */
			
			if (yourturnscore <= 100)
			{

				/** Creates an "if" loop to iterate the rolling of dice if the computer's
				 *  score for that turn is less than 20 AND the boolean value 
				 *  turnovervalue is 1. 
				 */
				
				if (turnscore <= 20 && turnovervalue == 1)
				System.out.println("It is the computer's turn.");	
				int firstaiRoll = dieone.roll(); 
				int secondaiRoll = dietwo.roll();
				
				// Prints out the computer's roll. 
				
				System.out.println("The computer rolled: " + firstaiRoll + " and " + secondaiRoll);	
										
						/** Creates an "if" loop to check if the user rolled Snake Eyes 
						 * 	on their dice rolls, and uses the sentinel value turnovervalue
						 *  to end the loop and the boolean value humanturn to start the
						 *  user's turn. 
						 */
				
							if (firstaiRoll == 1 || secondaiRoll == 1)
								{
									System.out.print("The computer lost its turn! ");
									System.out.println("Computer total is " + aiturnscore);
									turnovervalue = 0;
									humanturn = true; 
										} 

							/** Creates an "else if" loop to check if the computer did not get Snake Eyes 
							 * 	on their dice rolls, and to iterate and print out what the computer AI
							 *  scored on dice rolls.  
							 */
		
										else if (firstaiRoll != 1 || secondaiRoll != 1) 	
											{
												turnscore += (firstaiRoll + secondaiRoll);
												aiturnscore += (firstaiRoll + secondaiRoll);
												System.out.println("Computer total is " + aiturnscore);
												} 
							
							// Creates an if-loop to check to see if the AI scored more than 100 points, ending the game.
							
									if (aiturnscore >= 100 )
							{
								System.out.println("THE COMPUTER WINS!");
								gameover = true;
							}
						} 
		
				} while (computerturn = true && turnovervalue == 1 && turnscore <= 20);	
		} while (yourturnscore <= winvalue && aiturnscore <= winvalue && gameover == false);
	}
}
