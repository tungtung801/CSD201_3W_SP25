
public class MyStack {

    Node top; // node đầu của stack

    public MyStack() {
    }

    public MyStack(Node top) {
        this.top = top;
    }

    public void load() {
        this.push(10);
        this.push(14);
        this.push(7);
        this.push(7);
        this.push(3);
        this.push(2);
        this.push(15);
        this.push(9);
    }

    // Ultility function to check if the Stack is empty or not ?
    public boolean isEmpty() {
        return this.top == null;
    }

    // insert an element at the top position
    public void push(int x) {
        // create new node with given data;
        Node newNode = new Node(x);

        // Make the new Node point to the current top
        newNode.next = this.top;

        // Update top after insert new node 
        this.top = newNode;
    }

    // Method return value of the top of the stack
    // -1:  return a default value if Stack is empty
    public int peek() {
        if (!isEmpty()) {
            return this.top.info;
        } else {
            System.out.println("STACK EMPTY !");
            return -1;
        }
    }

    // Method return value of the top of the stack then REMOVE it
    public int pop() {
        if (!isEmpty()) {
            // bien tam luu value cua top can xoa
            int temp = this.top.info;

            // skip the top that need remove
            this.top = this.top.next;
            return temp;
        } else {
            System.out.println("STACK EMPTY !");
            return -1;
        }
    }

    // display all
    public void display() {
        if (!isEmpty()) {
            Node current = this.top;
            
            System.out.print("\nStack elements: ");
            while (current != null) {
                System.out.print(current.info + " ");
                current = current.next;
            }
        } else {
            System.out.println("STACK EMPTY !");
        }
    }
    
    
    /**/
}
