public class Deck extends Pile {

	public static void main(String[] args) {
		Deck deck = new Deck();
		
		Card card = deck.draw();
		System.out.println(card.getNumber());
		System.out.println(card.getSuit());
		
		Card[] Card = deck.deal();
		System.out.println(Card.length);

	}
	//constructor for deck, adds 13 Card of each suit
	public Deck()
	{
		for(int i=1;i<14;i++)
		{
			addCard(new Card(i, "clubs"));
			addCard(new Card(i, "spades"));
			addCard(new Card(i, "hearts"));
			addCard(new Card(i, "diamonds"));
		}
		shuffle();
	}
	
	//draws one card from the deck
	public Card draw()
	{
		Card card = Card.remove(0);
		return card;
	}
	
	//draws 7 Card from the deck and returns an array of Card
	public Card[] deal()
	{
		Card[] c = new Card[7];
		for(int i=0;i<7;i++)
		{
			c[i] = draw();
		}
		return c;
	}

}
