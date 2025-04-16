package slot03_a_sll;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TungTung
 */
public class MyList {

    Node head;

    public MyList() {
        this.head = null; // null: not exist | empty: not have value
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    public void traverse() {
        Node currNode = this.head;

        while (currNode != null) {
            System.out.print(currNode.info + " ");
            currNode = currNode.next;
        }
    }

    public void loadData(int k) { // k is number of elements
        Random generator = new Random();

        for (int i = 0; i < k; i++) {
            int number = generator.nextInt(1000);
            addFirst(number);
        }
    }

    public void addFirst(int n) {
        Node newNode = new Node(n);

        if (this.head != null) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            this.head = newNode;
        }
    }

    public void addLast(int n) {
        Node newNode = new Node(n);
        Node currNode = this.head;

        if (this.head == null) {
            addFirst(n);
            return;
        }

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    // 
    void f1() {
        System.out.print("Linked List: ");
        this.traverse();
        System.out.println("");
    }

    // nhap con so tu ban phim => addLast
    void f2() {
        System.out.println("Before: ");
        this.traverse();

        // Start code ===================
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter value: ");
        int value = sc.nextInt();

        addLast(value);

        // End code ======================
        System.out.println("After: ");
        this.traverse();
    }

    // f3 add at position
    void f3() {
        System.out.println("Before: ");
        this.traverse();
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter value: ");
        int value = sc.nextInt();

        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        Node currNode = this.head;
        int index = 0;

        if (pos == 0) {
            addFirst(value);
        } else {
            while (index < pos - 1 && currNode != null) {
                currNode = currNode.next;
                index++;
            }

            Node newNode = new Node(value);
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
        //  ...
        //------ End your code here-----------------------------------------------------------
        System.out.println("After: ");
        this.traverse();
    }

    // f4: delete first
    void f4() {
        System.out.println("Before: ");
        this.traverse();
        //------ Start your code here---------------------------------------------------------
        if (this.head != null) {
            this.head = this.head.next;
        } else {
            return;
        }
        //  ...
        //------ End your code here-----------------------------------------------------------
        System.out.println("\nAfter: ");
        this.traverse();
    }

    // f5: delete last
    void f5() {
        System.out.println("Before: ");
        this.traverse();
        //------ Start your code here---------------------------------------------------------
        if(this.head != null){
            if(this.head.next == null){
                this.head = null;
            }else {
                Node currNode = this.head;

                // move to the second last node
                while (currNode.next.next != null) {
                    currNode = currNode.next;
                }

                currNode.next = null;
            }
        }
        //  ...
        //------ End your code here-----------------------------------------------------------
        System.out.println("\nAfter: ");
        this.traverse();
    }
}
