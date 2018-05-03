/**
 * @author Charles Arnaudo
 */
public class LinkedList implements ListInterface {
    private Node firstNode;
    private int numberOfEntries;


    public LinkedList() {
    }

    @Override
    public boolean add(Object newEntry) {
        Node tempNode = new Node(newEntry, firstNode);
        firstNode = tempNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int newPosition, Object newEntry) {
        Node oldNode = getNodeAt(newPosition);
        Node prevNode = getNodeAt(newPosition - 1);
        Node newNode = new Node(newEntry, oldNode);
        prevNode.next = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public Object remove(int givenPosition) {
        Node oldNode = getNodeAt(givenPosition);
        if (numberOfEntries != 1) {
            Node tempNode = getNodeAt(givenPosition - 1);
            tempNode.next = oldNode.next;
        } else {
            firstNode = null;
        }
        numberOfEntries--;
        return oldNode;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, Object newEntry) {
        Node oldNode = getNodeAt(givenPosition);
        Node prevNode = getNodeAt(givenPosition - 1);
        Node newNode = new Node(newEntry, oldNode.next);
        prevNode.next = newNode;
        oldNode = newNode;
        return true;
    }

    @Override
    public Object getEntry(int givenPosition) {
        return getNodeAt(givenPosition).data;
    }

    @Override
    public boolean contains(Object anEntry) {
        Node tempNode = firstNode;
        while (tempNode.next != null) {
            if (tempNode.data == anEntry) {
                return true;
            } else {
                tempNode = tempNode.next;
            }
        }
        return false;
    }
    
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    // utility methods

    private Node getNodeAt(int givenPosition) {
        Node tempNode = firstNode;
        for (int i = 0; i < givenPosition; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    private class Node {
        private Object data; // Entry in bag
        private Node next; // Link to next node

        private Node(Object dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(Object dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}
