
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class StudentStack {

    Node top;

    public StudentStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void clear() {
        this.top = null;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = top;
        while (p != null) {
            f.writeBytes(p.info.toString()); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        String[] d = Lib.readLineToStrArray("data.txt", k + 3);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int age = Integer.parseInt(c[i]);
            double gpa = Double.parseDouble(d[i]);
            push(a[i], b[i], age, gpa);
        }
    }

    public void push(String id, String name, int age, double gpa) {
        Student newStudent = new Student(id, name, age, gpa);
        Node newNode = new Node(newStudent);

        if (!isEmpty()) {
            newNode.next = this.top;
            this.top = newNode;
        } else {
            this.top = newNode;
        }
    }

    public Student pop() {
        if (!isEmpty()) {
            Student temp = this.top.info;
            this.top = this.top.next;
            return temp;
        }
        return null;
    }

    public Student peek() {
        if (!isEmpty()) {
            return this.top.info;
        }
        return null;
    }

    // f1: Load data from file and display all students
    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // f2: Add a new student from console input
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student id: ");
        String id = sc.nextLine();
        
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        
        System.out.print("Enter student gpa: ");
        double gpa = sc.nextDouble();
        
        push(id, name, age, gpa);
        //------
        ftraverse(f);
        f.close();
    }

    // f3: Calculate average GPA of all students (using pop)
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        double average = 0;
        //---------
        int count = 0;
        double sum = 0;
        StudentStack s_tack = this; // khong lam anh huog den stack goc khi pop
        
        while(!s_tack.isEmpty()){
            Student st = s_tack.pop();
            sum += st.getGpa();
            count++;
        }
        
        count = (count == 0) ? 1:count;
        average = sum / count;
        //---------
        f.writeBytes("Average GPA: " + average + "\r\n");
        f.close();

    }
}
