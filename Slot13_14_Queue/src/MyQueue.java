
public class MyQueue {

    Node head;
    Node tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(int key) {
        Node newNode = new Node(key);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int temp = this.head.info;

            this.head = this.head.next;

            if (this.head == null) {
                this.tail = null;
            }

            return temp;
        } else {
            return -1;
        }
    }

    public int front() {
        if (!isEmpty()) {
            return this.head.info;
        } else {
            return -1;
        }
    }

    public void display() {
        if (!isEmpty()) {
            Node current = this.head;

            while (current != null) {
                System.out.print(current.info + " ");
                current = current.next;
            }
        }
    }

}
