
import java.util.*;
import java.io.*;

public class MyStack {

    Node head;
    int size;

    MyStack() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            push(a[i], p);
        }
    }

    void push(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Phone newPhone = new Phone(n, p);
        Node newNode = new Node(newPhone);

        if (!isEmpty()) {
            newNode.next = this.head;
            this.head = newNode;
            size++;
        } else {
            this.head = newNode;
            size++;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    Phone pop() {
        if (!isEmpty()) {
            Phone temp = this.head.info;
            this.head = this.head.next;
            if (this.head == null) {
                clear();
            }
            size--;
            return temp;
        } else {
            return null;
        }
    }

    // f1: ham nay se goi ham push nhieu lan
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

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

//        Phone temp = null;
//        if(!isEmpty()){
//            temp = this.head.info;           
//            this.head = this.head.next;
//            
//            if(this.head == null){
//                clear();
//            }
//            size--;
//        }
        Phone p = this.pop();
        
//        f.writeBytes(temp.name + "-" + temp.price + "\n");
        f.writeBytes(p.name + "-" + p.price + "\n");
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone p = null;
        if (!isEmpty()) {
            p = this.head.info;
        }
        f.writeBytes(p.name + "-" + p.price + "\n");

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
