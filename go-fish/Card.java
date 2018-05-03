//Kristin Johnson
//Card:
//	Data:
//		number
//		suit
//
//	Methods:
//		getNumber
//		getSuit
//		compareTo()
//		printCard
public class Card {
    private int Number;
    private String Suit;

    public Card(int num, String suit) {
        Number = num;
        Suit = suit;
    }

    public int getNumber() {
        return Number;
    }

    public String getSuit() {
        return Suit;
    }

    public boolean compareTo(int num) //compares the Card to see if numbers match
    {
        if (num == Number) {
            return true;
        } else
            return false;
    }

    public void printCard(int num, String suit) {
        if (suit.toUpperCase() == "DIAMOND") {
            suit = "◆";
        }
        if (suit.toUpperCase() == "SPADES") {
            suit = "♠";
        }
        if (suit.toUpperCase() == "CLUBS") {
            suit = "♣";
        }
        if (suit.toUpperCase() == "HEARTS") {
            suit = "❤︎";
        }
        String TOP = " _____";
        String SIDE1 = "|  " + num + "  |";
        String SIDE2 = "|     |";
        String SIDE3 = "|  " + suit + " |";
        String BOTTOM = "|_____|";

        System.out.println(TOP + '\n' + SIDE1 + '\n' + SIDE2 + '\n' + SIDE3 + '\n' + BOTTOM);


    }


}


