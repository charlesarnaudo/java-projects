/**
 * Comp 2000: Data Structures, Fall, 2016
 *
 * Charles Arnaudo
 * Assignment 1: Bag ADT
 * Due: 9/19/2016
 */
public class TestBags {

    public static void main(String[] args) {
        LinkedBag1<Integer> linkedBag = new LinkedBag1();

        for (int i = 0; i < 10; i++) {
            linkedBag.add(i);
        }
        System.out.println("Entries: ");
        linkedBag.printArray();

        System.out.println("isEmpty: ");
        if (linkedBag.isEmpty()) {  //it's not
            System.out.println("It's empty.");
        } else {
            System.out.println("It's not empty");
        }
        System.out.println();
        System.out.println("getCurrentSize (should be 10): ");
        System.out.println(linkedBag.getCurrentSize());
        System.out.println();


        System.out.println("remove(), first entry should be gone now");
        linkedBag.remove();
        linkedBag.printArray();

        System.out.println("remove(T anEntry), removing 4");
        linkedBag.remove(4);
        linkedBag.printArray();

        System.out.println("clear(), should contain nothing");
        linkedBag.clear();
        linkedBag.printArray();

        System.out.println("getFrequencyOf(0), should be 0");
        System.out.println(linkedBag.getFrequencyOf(9));
        System.out.println();

        System.out.println("contains(3)");
        if (linkedBag.contains(3)) {
            System.out.println("It contains 3");
        } else {
            System.out.println("It does not contain 3");
        }


    }
}

