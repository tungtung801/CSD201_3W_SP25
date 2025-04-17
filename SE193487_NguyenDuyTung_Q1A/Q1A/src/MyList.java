// MyList.java
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + " | " + p.info.major + " | " + p.info.gpa + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] names = Lib.readLineToStrArray("data.txt", k);
        String[] majors = Lib.readLineToStrArray("data.txt", k + 1);
        String[] gpaStr = Lib.readLineToStrArray("data.txt", k + 2);
        int n = names.length;
        for (int i = 0; i < n; i++) {
            double gpa = Double.parseDouble(gpaStr[i]);
            addLast(names[i], majors[i], gpa);
        }
    }

    // Add a new student at the beginning of the list
    void addFirst(String name, String major, double gpa) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
       
        Student newStudent = new Student(name, major, gpa);
        Node newNode = new Node(newStudent);
        
        if(!isEmpty()){
            newNode.next = this.head;
            this.head = newNode;
            size++;
        }else{
            this.head = this.tail = newNode;
            size++;
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    // Add a new student at the end of the list
    void addLast(String name, String major, double gpa) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
       
        Student newStudent = new Student(name, major, gpa);
        Node newNode = new Node(newStudent);
        
        if(!isEmpty()){
            this.tail.next = newNode;
            this.tail = this.tail.next;
            size++;
        }else{
            addFirst(name, major, gpa); 
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    // f1: Load data from file and display the linked list
    // This function loads student data from a file and displays all students in the list
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

    // f2: Add a new student named "X" with major "Information Technology" and GPA 8.5 at the beginning of the list
    // This function adds a predefined student to the beginning of the list and displays the updated list
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
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        addFirst("X", "Information Technology", 8.5);

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f3: Count and display the number of students with GPA >= 8.0
    // This function counts all students with GPA of 8.0 or higher and displays the count
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
        int count = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
        Node currNode = this.head;
        
        if(!isEmpty()){
            while (currNode != null) {
                if (currNode.info.gpa >= 8.0) {
                    count++;
                }
                currNode = currNode.next;
            }
        }else{
            return;
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes("Number of students with GPA >= 8.0: " + count + "\r\n");
        f.close();
    }

    // f4: Find and display the student with the highest GPA
    // This function finds the student with the maximum GPA and displays their information
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Student topStudent =  new Student();
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
        Node currNode = this.head;
        topStudent = currNode.info;
        
        if(!isEmpty()){
            while(currNode != null){
                if(currNode.info.gpa > topStudent.gpa){
                    topStudent = currNode.info;
                }
                currNode = currNode.next;
            }
        }else{
            return;
        }
        
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes("Student with highest GPA: " + topStudent.name + " | " + 
                    topStudent.major + " | " + topStudent.gpa + "\r\n");
        f.close();
    }

    // f5: Add 0.2 bonus points to all IT students' GPA (but do not exceed 10.0)
    // This function identifies IT students and increases their GPA
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
        Node currNode = this.head;
        
        if(!isEmpty()){
            while(currNode != null){
                if(currNode.info.major.equals("IT") && (currNode.info.gpa + 2.0 ) <= 10.0){
                    currNode.info.gpa += 2.0;
                }
                currNode = currNode.next;
            }  
        }else{
            return;
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes("After adding bonus points to IT students:\r\n");
        ftraverse(f);
        f.close();
    }
}