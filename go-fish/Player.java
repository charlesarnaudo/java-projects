import java.util.Scanner;
public class Player {
	private String userName;
	private Hand playerHand;
	private Pile matches;
	private int score = 0;
	
	public Player(Hand tempHand)
	{
		userName = "Player";
		playerHand = tempHand;
		matches = new Pile();
		
	}//end player
	
	public Player(String name, Hand tempHand)
	{
		userName = name;
		playerHand = tempHand;
		matches = new Pile();
	}//end player
	
	/**
	 * Getter for the players name
	 * @return userName   string form of player name
	 */
	public String getName()
	{
		return userName;
	}//end getName
	
	/**
	 * Getter for the players score
	 * @return score   players current score
	 */
	public int getScore()
	{
		return score;
	}//end getScore
	
	/**
	 * Calculates the score for the player
	 */
	public void setScore(int add)
	{
	  score = score + add;
	}
	
	/** 
	 * Getter for the players hand
	 * @return playerHand   players current hand
	 */
	public Hand getHand()
	{
		return playerHand;
	}//end getHand
	
	/**
	 *Finds the matches in the hand and adds them to the
	 *match pile 
	 */
	public void addMatches()
	{
		int matchCount = 0;
		matchCount = playerHand.checkMatches(); 
		
		if(matchCount > 0)
		{
			System.out.println("You have a match!");
		}
		this.setScore(matchCount);
	}
	/**
	 * Adds a card from the deck to the players hand
	 */
	public void drawCard(Deck deck)
	{
		
		playerHand.addCard(deck.draw());
	}//end drawCard
	
	/**
	 * Asks the player what card they want
	 */
	public Card ask(Scanner input)
	{
		
		System.out.print("What card do you want: ");
		String answer = input.next(); 
		if(answer.equalsIgnoreCase("K"))
		{
			answer = "13";
		}
		
		if(answer.equalsIgnoreCase("Q"))
		{
			answer = "12";
		}
		
		if(answer.equalsIgnoreCase("J"))
		{
			answer = "11";
		}
		
		if(answer.equalsIgnoreCase("A"))
		{
			answer = "1";
		}
		
		Card card = new Card(Integer.parseInt(answer), "heart");
		return card;
	}//end ask
	
	/**
	 * checks the players hand for the card
	 * 
	 * @return if the player has the card
	 */
	public boolean answer(Card target)
	{
		
		if(playerHand.search(target) == true)
		{
			return true;
		}
		else
		return false;
	}//end answer

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Hand hand = new Hand();
		Player p = new Player(hand);
		System.out.println("Name: "+ p.getName());
		System.out.println("Score: "+ p.getScore());
		
		Card c = p.ask(input);
		
		Card c2 = new Card(3, "Diamonds");
		Card c3 = new Card(3, "Clubs");
		hand.addCard(c);
		System.out.println("Wanted Card: "+ c.getNumber() + " " + c.getSuit());
		System.out.println("Has wanted card (inputted card): " + p.answer(c));
		System.out.println("Has 3 diamonds: " + p.answer(c2));
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c3);
		p.addMatches();
		System.out.println("Score: " + p.getScore());
		p.addMatches();
		System.out.println("Score: " + p.getScore());
	}//end main
	
}//end player class
