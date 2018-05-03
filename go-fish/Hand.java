import java.util.ArrayList;
import java.util.Collections;

public class Hand extends Pile {

    public static void main(String[] args) {
        Card card1 = new Card(2, "diamond");
        Card card2 = new Card(12, "hearts");
        Hand hand = new Hand(new Card[]{card1, card2});

        System.out.println(hand);

        //should return 0
        System.out.println(hand.checkMatches());

        //add a matching card
        hand.addCards(new Card(2, "spades"));

        //should return 1
        System.out.println(hand.checkMatches());
    }

    public Hand() {

    }

    //constructor for hand, takes array of cards
    public Hand(Card[] arg) {
        for (int i = 0; i < arg.length; i++) {
            addCards(arg[i]);
        }
    }

    //function to check for matches and remove them from the hand
    public int checkMatches() {
        ArrayList<Card> matches = new ArrayList<>();
        int count = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for (Card card : cards) {
            nums.add(card.getNumber());
        }
        for (int num : nums) {
            if (Collections.frequency(nums, num) > 1) {
                for (Card card : cards) {
                    if (card.getNumber() == num) {

                        matches.add(removeCards(card));
                        count++;
                        break;
                    }
                }
                for (Card card : cards) {
                    if (card.getNumber() == num) {
                        matches.add(removeCards(card));
                        count++;
                        break;
                    }
                }
            }
        }


        return matches.size() / 2;
    }

    //prints the hand to the console
    public void printHand() {
        for (Card card : cards) {
            card.printCard(card.getNumber(), card.getSuit());
        }
    }

}
