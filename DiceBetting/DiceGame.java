
package Lab11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiceGame extends JFrame implements ActionListener, ItemListener
{
	  //JLabel declarations
      JLabel greeting;
      JLabel cash;
      JLabel bet;
      JLabel comfort;
      JLabel funds;
      JLabel spacing;
        
      //JButton declarations
      JButton d1;
      JButton d2;
      JButton d3;
      JButton out;
      JButton roll;
      
      //JComboBox declaration
      JComboBox options;
      
      //JTextField declarations
      JTextField remaining;
      JTextField betting;
      
      //JPanel declarations
      JPanel buttonsPanel;
      JPanel east;
      JPanel west;
      JPanel south;
      
      int money;
      
    public DiceGame()
    {
    	//call parent
        super("Casino Simulator");
        
        //frame dimensions
        final int FRAME_WIDTH = 450;
        final int FRAME_HEIGHT = 200;
        
        //initialize JLabels
        greeting = new JLabel(" Welcome to The High Rollers Game");
        greeting.setFont(new Font("Ariel", Font.BOLD, 24));
        cash = new JLabel("Cash Available");
        cash.setFont(new Font("Ariel", Font.BOLD, 16));
        bet = new JLabel("Place your bet");
        comfort = new JLabel("");
        funds = new JLabel("");
        spacing = new JLabel("       ");
        
        //set starting value for money
        money = 1000;
        
        //initialize JComboBox
        String[] comboArray = {"Quick Bet", "$100", "$350", "$500"};
        options = new JComboBox(comboArray);
        
        //initialize JButtons
        d1 = new JButton("D1");
        d2 = new JButton("D2");
        d3 = new JButton("D3");
        out = new JButton("Cash Out");
        roll = new JButton("Roll Dice");
        
        //initialize JTextFields
        remaining = new JTextField("$" + money);
        betting = new JTextField(15);
        
        //initialize JPanels
        buttonsPanel = new JPanel();
        east = new JPanel();
        west = new JPanel();
        south = new JPanel();
        
        
        //////////////////////////////////////////////////////////////
        
        //add ItemListener to options
        options.addItemListener(this);
        
        //add ActionListener to buttons
        betting.addActionListener(this);
        out.addActionListener(this);
        roll.addActionListener(this);
        
        //apply size of frame, proper closing, layout, and location
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        //disable editing this JTextField
        remaining.setEditable(false);
        
        /////////////////////////////////////////////////////////////////
        //add the major portions to each section of the border layout
        add(buttonsPanel, BorderLayout.CENTER);
        add(greeting, BorderLayout.NORTH);
        add(west, BorderLayout.WEST);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        
        //add cash and remaining to the left side of the frame
        west.setLayout(new GridLayout(2, 2, 5, 5));
        west.add(cash);
        west.add(remaining);
        
        //add out and options to the right side of the frame
        east.setLayout(new GridLayout(2, 2, 5, 5));
        east.add(out);
        east.add(options);
        
        //add funds, roll, and comfort to the bottom of the frame
        south.setLayout(new GridLayout(1, 1, 3, 3));
        south.add(funds);
        south.add(roll);
        south.add(comfort);
        
        //add all dice buttons, the bet message and 
        //bet text box to the middle of the frame
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(d1);
        buttonsPanel.add(d2);
        buttonsPanel.add(d3);
        buttonsPanel.add(spacing);
        buttonsPanel.add(bet);
        buttonsPanel.add(betting);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    	//get the source
        Object source = ae.getSource();
        
        //compares source to roll if equal run the code
        if(source == roll)
        {
        	//rolls dice 1 and changes the text in the corresponding button
        	int dice = (int)(Math.random() * 6) + 1;
        	String diceRoll = Integer.toString(dice);
        	d1.setText(diceRoll);
        	
        	//rolls dice 2 and changes the text in the corresponding button
        	int dice2 = (int)(Math.random() * 6) + 1;
        	String diceRoll2 = Integer.toString(dice2);
        	d2.setText(diceRoll2);
        	
        	//rolls dice 3 and changes the text in the corresponding button
        	int dice3 = (int)(Math.random() * 6) + 1;
        	String diceRoll3 = Integer.toString(dice3);
        	d3.setText(diceRoll3);
        	
        	//gets the text in betting
        	String betString = betting.getText();
        	//converts the string into an integer
        	int bet = Integer.parseInt(betString);
        	
        	//checks if user ran out of money and changes 
        	//the button of the cash out button to "exit"
        	if(money == 0)
        	{
        		out.setText("Exit");
        	}
        	//informs the user that they cannot bet with the amount they inputed
        	else if (bet > money)
        	{
        		funds.setText("Insufficient funds");
        	}
        	//compares the result of the three dice
        	else if(bet <= money)
        	{
        		funds.setText(""); //resets the insufficient fund message
        		
	        	////////////////////////////////////////////////////////////////////////////////////////////////////
	        	
	        	if(dice == dice2 || dice2 == dice3 || dice == dice3) //if two of a kind
	        	{
	        		if(dice == dice2 && dice == dice3) //if three of a kind
	        		{
	        			money += (bet * 2); //add winnings to money
	        			comfort.setText("Three of a kind!"); 
	        			funds.setText("WINNER");
	        			remaining.setText("$" + money); //update the balance display
	        		}
	        		else
	        		{
	        			money += bet; //add winnings to money
	            		comfort.setText("Two of a kind!");
	            		funds.setText("WINNER");
	            		remaining.setText("$" + money); //update the balance display
	        		}
	        	}
	        	else
	        	{
	        		money -= bet; //deduct loss from money
	        		comfort.setText("Better luck next time.");
	        		funds.setText("LOSER");
	        		remaining.setText("$" + money); //update the balance display
	        	}	
	        	/////////////////////////////////////////////////////////////////////////////////////////////////////
        	}
        }
        if(source == out) //if the Cash Out button is clicked
        {
        	//closes the frame
            super.dispose();
        }    
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) 
    {
    	//get the object
        Object source = ie.getSource();
        //get the choice picked by the user
        int select = ie.getStateChange();
        
        //compares source to options if equal run the code
        if(source == options)
        {
        	if(select == ItemEvent.SELECTED)
        	{
        		//gets the index of the option selected by the user
        		int positionOfSelected = options.getSelectedIndex();
        		//checks for a match between users choice and the possible options
        		if (positionOfSelected == 1)
        		{
        			betting.setText("100"); //sets betting to 100
        		}
        		else if (positionOfSelected == 2)
        		{
        			betting.setText("350"); //sets betting to 350
        		}
        		else if (positionOfSelected == 3)
        		{
        			betting.setText("500"); //sets betting to 500
        		}
        	}
        	
        }
    }
    
}
