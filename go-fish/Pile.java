import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * @author Charles Arnaudo
 */
public class Pile {
    protected ArrayList<Card> cards = new ArrayList<>();

   /* public static void main(String[] args) {
        Pile testPile = new Pile();
        for (int i = 0; i < 10; i++) {
            testPile.addCard(new Card(i, "s"));
        }

        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).getNumber());
        }

        Card testCard = new Card(0, "s");
        testPile.removeCard(testCard);
        System.out.println();

        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).getNumber());
        }
    }*/

    /**
     * Defualt constructor. ArrayList cards initialized on creation
     */
    public Pile() {
    }

    /**
     * @return length of ArrayList cards
     */
    public int getLength() {
        return cards.size();
    }

    /**
     * @return ArrayList cards
     */
    public ArrayList getCards() {
        return cards;
    }

    /**
     * @return string representing ArrayList cards
     */
    public String toString() {
        return cards.toString();
    }

    /**
     * Adds card to end of cards
     *
     * @param card card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Removes first instance of a specified card from cards
     *
     * @param card card to be removed
     * @return card that was removed
     */
    public Card removeCard(Card card) {
        for (Card tempCard : cards) {
            if (card.compareTo(tempCard.getNumber())) {
                cards.remove(tempCard);
                return tempCard;
            }
        }
        return null;
    }

    /**
     * Shuffles cards using java.util.Collections
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Sorts using java.util.Collections and custom comparator cardComparator
     */
    public void sort() {
        Collections.sort(cards, new cardComparator());
    }

    /**
     * Searches cards for passed card
     *
     * @param card card to search for
     * @return true or false
     */
    public boolean search(Card card) {
        for (Card tempCard : cards) {
            if (tempCard.compareTo(card.getNumber())) {
                return true;
            }
        }
        return false;
    }

    public Card search(int index) {
        return cards.get(index);
    }

    /**
     * This doesn't work and probably won't ever work ¯\_(ツ)_/¯
     */
    public void split() {
    }

    /**
     * same tbh ¯\_(ツ)_/¯
     */
    public void group() {
    }

    /**
     * comparator class used to sort an ArrayList of type Card
     */
    private class cardComparator implements Comparator<Card> {

        /**
         * Compares two given cards for less than, equal too, or greater than
         *
         * @param card1
         * @param card2
         * @return -1 if card1 < card2; 0 if card1 == card2; 1 if card1 > card2
         */
        @Override
        public int compare(Card card1, Card card2) {
            if (card1.getNumber() < card2.getNumber()) {
                return -1;
            } else if (card1.compareTo(card2.getNumber())) {
                return 0;
            } else {
                return 1;
            }
        }

        /**
         * @param card
         * @return
         */
        public boolean equals(Card card) {
            return true;
        }
    }
}