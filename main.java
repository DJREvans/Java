package TicTac;

import java.util.Scanner;

public class Main 
{
	
	//create a cin
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) 
	{
		final int TURN_LIMIT = 10;
		int choiceRow;
		int choiceColumn;
		int turn = 1;
		
		//Intro message
		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println("========================");
		
		//create a gameboard
		Game_Board board = new Game_Board();
		
		//print the board
		board.printBoard();

		//repeat the following code until the turn limit is reached
		while(turn < TURN_LIMIT)
		{
			//when the turn is even
			if(turn % 2 == 0)
			{
				System.out.println("Player 2 turn 'O'");
				//increase turn count
				turn++;
				
				//get row from user
				choiceRow = row();
				
				//get column from user
				choiceColumn = column();
				
				//place an 'O' in the row and column of choice
				board.placeO(choiceRow, choiceColumn);
				
				//check if the player won
				//if true add 10 to turn and end the game early
				turn += board.checkWinnerO();
				
				//print the board
				board.printBoard();
				
			}
			//when the turn is odd
			else if(turn % 2 == 1)
			{
				System.out.println("Player 1 turn 'X'");
				//increase turn
				turn++;
				
				//get row from user
				choiceRow = row();
				
				//get column from user
				choiceColumn = column();
				
				//place 'X' at given location
				board.placeX(choiceRow, choiceColumn);
				
				//check for winner
				//add 10 if true, add 0 if false
				turn += board.checkWinnerX();
				
				//since last turn is odd, if turn reaches turn limit 
				//call it a draw
				if(turn == TURN_LIMIT)
				{
					System.out.println("Cat's Game!");
					board.printBoard();
				}
				else
				{
					//prints the board
					board.printBoard();
				}
				
			}
		
		}
		
		
	}
	//asks the user which row they would like to select
	public static int row()
	{
		System.out.println("Which row would you like?");
		int row = input.nextInt();
		return row;
	}
	//asks the user which column they would like to select
	public static int column()
	{
		System.out.println("Which column would you like?");
		int column = input.nextInt();
		return column;
	}
	

}
