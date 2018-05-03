/**
 * Created by Charl on 11/12/2016.
 */
public class TestClass {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        System.out.println("isEmpty?. " + linkedList.isEmpty());

        System.out.println("\n");
        System.out.println("Adding integers sequentially from 0 to 10. ");
        for (int i = 0; i < 10; i ++) {
            linkedList.add(i);
        }

        System.out.println("Printing out integers. ");
        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.print(linkedList.getEntry(i) + " ");
        }

        System.out.println("\n");
        System.out.println("Add(27)");
        linkedList.add(27);

        System.out.println("Printing out entries");
        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.print(linkedList.getEntry(i) + " ");
        }

        System.out.println("\n");
        System.out.println("add(4,21)");
        linkedList.add(4, 21);
        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.print(linkedList.getEntry(i) + " ");
        }

        System.out.println("\n");
        System.out.println("remove()");
        linkedList.remove(4);
        System.out.println("Printing out entries");
        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.print(linkedList.getEntry(i) + " ");
        }

        System.out.println("\n");
        System.out.println("replace(4,69)");
        linkedList.replace(4, 69);
        System.out.println("Printing out entries");
        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.print(linkedList.getEntry(i) + " ");
        }

        System.out.println("\n");
        System.out.println("clear()");
        linkedList.clear();
        System.out.println("Printing out entries");
        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.print(linkedList.getEntry(i) + " ");
        }








    }
}
