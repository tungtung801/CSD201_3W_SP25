/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TungTung
 */
public class Node {
    int info;
    Node next;
    
    Node(){
    }
    
    Node(int info, Node next){
        this.info = info;
        this.next = next;
    }
    
    // overloading: 1 method trung ten nhung khac tham so, nam trong cung 1 class
    Node(int info){
        this.info = info;
    }
}
