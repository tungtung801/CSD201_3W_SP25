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
    Node left, right;

    public Node() {
        left = right = null;
    }

    public Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    // goi len constructor 3 tham so
    public Node(int info) {
        this(info, null, null);
    }
    
    
}
