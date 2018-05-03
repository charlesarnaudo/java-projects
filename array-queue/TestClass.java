/**
 * Created by arnaudoc on 10/23/2016.
 */
public class TestClass {
    public static void main(String[] args) {
        ArrayQueue<Integer> testQueue = new ArrayQueue<>();

        System.out.println("queue entries");
        for (int i = 0; i < 10; i++) {
            testQueue.enqueue(i);
        }

        System.out.println("getFront: ");
        System.out.println(testQueue.getFront());

        System.out.println("deque entries: ");
        while(!testQueue.isEmpty()) {
            System.out.println(testQueue.dequeue());
        }

        ArrayQueue<Integer> testStack2 = new ArrayQueue();
        System.out.println("queueing more than 50 entries, forcing queue to resize");
        for (int i = 0; i < 100; i++) {
            testStack2.enqueue(i);
        }

        System.out.println("getFront: ");
        System.out.println(testStack2.getFront());

        System.out.println("deque entries: ");
        while(!testStack2.isEmpty()) {
            System.out.println(testStack2.dequeue());
        }

        ArrayQueue<Integer> testStack3 = new ArrayQueue<>();
        System.out.println("dequeing with nothing in stack. Bad stuff SHOULD happen. ");
        testStack3.dequeue();

        System.out.println("getFront with nothing in stack. Bad stuff SHOULD happen. ");
        testStack3.getFront();

    }
}
