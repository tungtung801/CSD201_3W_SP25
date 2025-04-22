
public class Main {

    public static void main(String[] args) {
        MyQueue queue1 = new MyQueue();

        queue1.enqueue(0);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(5);
        queue1.enqueue(6);

        System.out.println("--------------");
        queue1.display();
        System.out.println("--------------");
        queue1.dequeue();
        queue1.display();
        System.out.println("--------------");
        int value = queue1.front();
        System.out.println("Front: " + value);

    }
}
