/**
 * @author Charles Arnaudo
 */
public class StackTest {
    public static void main(String[] args) {
        ArrayStack testStack = new ArrayStack();

        System.out.println("pushing entries");
        for (int i = 0; i < 10; i++) {
            testStack.push(i);
        }

        System.out.println("peek: ");
        System.out.println(testStack.peek());

        System.out.println("pop entries: ");
        while(!testStack.isEmpty()) {
            System.out.println(testStack.pop());
        }

        ArrayStack testStack2 = new ArrayStack();
        System.out.println("pushing more than 50 entries, forcing stack to resize");
        for (int i = 0; i < 51; i++) {
            testStack2.push(i);
        }

        System.out.println("peek: ");
        System.out.println(testStack2.peek());

        System.out.println("pop entries: ");
        while(!testStack2.isEmpty()) {
            System.out.println(testStack2.pop());
        }
    }
}
