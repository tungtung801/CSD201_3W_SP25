/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot03_a_sll;

/**
 *
 * @author TungTung
 */
public class Node {
    // public
    // private
    // protected: lop cha co thi lop con cung co
    // default: chung 1 package thi moi thay dc method() cua nhau
    
    int info;
    Node next;

    public Node() {
    }

    public Node(int info, Node next) {
        this.info = info; 
        this.next = next;
    }

    public Node(int info) {
        this.info = info;
    }
    
    
}
