package TicTac;

import java.util.Scanner;

public class Game_Board 
{
	//declare 2D array
	static char [][] twoD;
	//make your cin
	static Scanner input = new Scanner(System.in);
			
	public Game_Board()
	{
		//initialize 2D array
		twoD = new char[][] 
		{
			{' ', '|', ' ', '|', ' '},
			{'-', '-', '-', '-', '-'},
			{' ', '|', ' ', '|', ' '},
			{'-', '-', '-', '-', '-'},
			{' ', '|', ' ', '|', ' '}
		};
		
	}
	
	public static void placeX(int row, int column)
	{	
		//since we don't want some spaces to be used we
		//adjust them to locations that are intended to be used
		
		if(row == 1)
		{
			row++;
		}
		else if(row == 2)
		{
			row = row + 2;
		}
		//error checking for numbers out of range
		else
		{
			while (row < 0 || row > 2)
			{
				System.out.println("Invalid input");
				System.out.println("Enter a new row: ");
				row = input.nextInt();
				if(row == 1)
				{
					row++;
				}
				else if(row == 2)
				{
					row = row + 2;
				}
			}
		}
		//====================================================
		//same thing as row but for the column
		if(column == 1)
		{
			column++;
		}
		else if(column == 2)
		{
			column = column + 2;
		}
		//error checking for out of bounds
		else 
		{
			while (column < 0 || column > 4)
			{
				System.out.println("Invalid input");
				System.out.println("Enter a new column: ");
				column = input.nextInt();
				if(column == 1)
				{
					column++;
				}
				else if(column == 2)
				{
					column = column + 2;
				}
			}
		}
		//====================================================
		//checking if the location selected has already been used previously
		//if it has been used, code asks for new row and column to be inputed
		if (twoD[row][column] != ' ')
		{
			System.out.println("This spot is already taken");
			System.out.println("Enter a new row: ");
			row = input.nextInt();
			System.out.println("Enter a new column: ");
			column = input.nextInt();
			placeX(row, column);
		}
		else
		{
			twoD[row][column] = 'X'; //places an 'X' in a location of [row][column]
		}
	}
	public static void placeO(int row, int column)
	{
		//since we don't want some spaces to be used we
		//adjust them to locations that are intended to be used
		if(row == 1)
		{
			row++;
		}
		else if(row == 2)
		{
			row = row + 2;
		}
		//error checking for numbers out of range
		else
		{
			while (row < 0 || row > 2)
			{
				System.out.println("Invalid input");
				System.out.println("Enter a new row: ");
				row = input.nextInt();
				if(row == 1)
				{
					row++;
				}
				else if(row == 2)
				{
					row = row + 2;
				}
			}
		}
		//=============================================
		//same thing as row but for the column
		if(column == 1)
		{
			column++;
		}
		else if(column == 2)
		{
			column = column + 2;
		}
		//error checking for numbers out of range
		else
		{
			while (column < 0 || column > 4)
			{
				System.out.println("Invalid input");
				System.out.println("Enter a new column: ");
				column = input.nextInt();
				if(column == 1)
				{
					column++;
				}
				else if(column == 2)
				{
					column = column + 2;
				}
			}
		}
		//=================================================
		//checking if the location selected has already been used previously
		//if it has been used, code asks for new row and column to be inputed
		if (twoD[row][column] != ' ')
		{
			System.out.println("This spot is already taken");
			System.out.println("Enter a new row: ");
			row = input.nextInt();
			System.out.println("Enter a new column: ");
			column = input.nextInt();
			placeO(row, column);
		}
		else
		{
			twoD[row][column] = 'O'; //places an 'O' in a location of [row][column]
		}
	}
	//prints the board
	public static void printBoard()
	{
		int rows = 5;
		int columns = 5;
		
		//FOR EVERY ROW
		for(int i = 0; i<rows; i++)
		{
			//FOR EVERY COLUMN
		    for(int j = 0; j<columns; j++)
		    {
		    	//PRINT OUT THE VALUE
		        System.out.print(twoD[i][j]);
		    }
		    //SPACING
		    System.out.println();
		}
	}
	
	//checks all possible ways to 'X' to win 
	//and returns 10 if one of these statements
	//is true to end the game early, if false returns 0;
	public static int checkWinnerX()
	{
		//HORIZONTALS WINNING LINES ///////////////////////////////////////////////
		if(twoD[0][0] == 'X' && twoD[0][2] == 'X' && twoD[0][4] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		else if(twoD[2][0] == 'X' && twoD[2][2] == 'X' && twoD[2][4] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		else if(twoD[4][0] == 'X' && twoD[4][2] == 'X' && twoD[4][4] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		
		//VERTICALS WINNING LINES //////////////////////////////////////////////////
		else if(twoD[0][0] == 'X' && twoD[2][0] == 'X' && twoD[4][0] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		else if(twoD[0][2] == 'X' && twoD[2][2] == 'X' && twoD[4][2] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		else if(twoD[0][4] == 'X' && twoD[2][4] == 'X' && twoD[4][4] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		
		//DIAGONALS WINNING LINES ///////////////////////////////////////////////////
		else if(twoD[0][0] == 'X' && twoD[2][2] == 'X' && twoD[4][4] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		else if(twoD[4][0] == 'X' && twoD[2][2] == 'X' && twoD[0][4] == 'X')
		{
			System.out.println("Player 1 wins!");
			return 10;
		}
		else
		{
			//IF NONE OF THE CONDITIONS ARE MET
			return 0;
		}
	}
	//checks all possible ways to 'O' to win 
	//and returns 10 if one of these statements
	//is true to end the game early, if false returns 0;
	public static int checkWinnerO()
	{
		//HORIZONTALS WINNING LINES///////////////////////////////////////////
		if(twoD[0][0] == 'O' && twoD[0][2] == 'O' && twoD[0][4] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		else if(twoD[2][0] == 'O' && twoD[2][2] == 'O' && twoD[2][4] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		else if(twoD[4][0] == 'O' && twoD[4][2] == 'O' && twoD[4][4] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		
		//VERTICALS WINNING LINES////////////////////////////////////////////
		else if(twoD[0][0] == 'O' && twoD[2][0] == 'O' && twoD[4][0] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		else if(twoD[0][2] == 'O' && twoD[2][2] == 'O' && twoD[4][2] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		else if(twoD[0][4] == 'O' && twoD[2][4] == 'O' && twoD[4][4] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		//DIAGONALS WINNING LINES////////////////////////////////////////////
		else if(twoD[0][0] == 'O' && twoD[2][2] == 'O' && twoD[4][4] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		else if(twoD[4][0] == 'O' && twoD[2][2] == 'O' && twoD[0][4] == 'O')
		{
			System.out.println("Player 2 wins!");
			return 10;
		}
		else
		{
			//IF NONE OF THE CONDITIONS ARE MET
			return 0;
		}
	}
}
