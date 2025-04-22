
public class MyQueue {

    Node head, tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(String id, String name, int age, double gpa) {
        Student newStudent = new Student(id, name, age, gpa);
        Node newNode = new Node(newStudent);

        if (!isEmpty()) {
            this.tail.next = newNode;
            this.tail = newNode;
        } else {
            this.head = this.tail = newNode;
        }
    }

    public Student dequeue() {
        if (!isEmpty()) {
            Student temp = this.head.info;
            this.head = this.head.next;

            if (this.head == null) {
                this.tail = null;
            }

            return temp;
        } else {
            return null;
        }
    }

    public Student front() {
        if (!isEmpty()) {
            return this.head.info;
        } else {
            return null;
        }
    }

    public void display() {
        if (!isEmpty()) {
            Node current = this.head;

            while (current != null) {
                System.out.print(current.info + "     ");
                current = current.next;
            }
        }
    }

    // find student highest Gpa
    public Student highestGPA() {
        if (!this.isEmpty()) {
            Student highest = this.head.info;
            MyQueue temp_Q = new MyQueue();
            Node tempHead = this.head;

            //copy all node in original queue to temp queue
            while (tempHead != null) {
                temp_Q.enqueue(tempHead.info.getId(), tempHead.info.getName(),
                        tempHead.info.getAge(), tempHead.info.getGpa());
                tempHead = tempHead.next;
            }

            // find highest gpa stu
            while (!temp_Q.isEmpty()) {
                Student target = temp_Q.dequeue();
                if (target.getGpa() > highest.getGpa()) {
                    highest = target;
                }
            }

            return highest;
        } else {
            return null;
        }
    }

    public void minDelete() {
        //find min and delete
        Node current = this.head;
        Node nextNode = this.head.next;
        Node prev = null;
        Node min = this.head;

        while (nextNode != null) {
            if (nextNode.info.getGpa() < min.info.getGpa()) {
                min = nextNode;
                prev = current;
            }
            current = nextNode;
            nextNode = nextNode.next;
        }

        if (min == this.head) {
            this.head = this.head.next;
            
            if(this.head.next == null){
                this.tail = null;
            }
        } else {
            prev.next = min.next;
            
            if(min == this.tail){
                this.tail = prev;
            }
        }
    }
}
