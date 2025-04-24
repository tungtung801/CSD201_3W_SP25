/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TungTung
 */
public class MyTree {

    Node root;

    public MyTree() {
        this.root = null;
    }

    public void load() {
        insert(20);
        insert(10);
        insert(30);
        insert(5);
        insert(15);
        insert(25);
        insert(35);
        insert(100);

    }

    public void insert(int value) {
        // tra ve 1 bst hoan chinh sau khi goi insertRec
        root = insertRec(root, value);
    }

    private Node insertRec(Node p, int value) {
        // check null
        if(p == null){
            // neu cay ban dau null, thi tao node moi va return bst 
            return root = new Node(value);
        }else{
            if(p.info < value){
                // de quy sang trai
                p.left = insertRec(p.left, value);
            }else if (p.info > value){
                // de quy sang phai, truong hop = nhau thi khong lam gi ca
                p.right = insertRec(p.right, value);
            }
        }
        
        // cuoi cung sau khi hoan tat them trai / phai thi return ve bst hoan chinh
        return p;
    }

    public void visit(Node p) {
        System.out.print(p.info + " ");
    }

    public void preOrder(Node p) {
        if(p != null){
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void inOrder(Node p) {
        if(p != null){
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    public void postOrder(Node p) {
        if(p != null){
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    public int search(Node p, int x) {
        if(p == null){ // ko tim thay
            return 0;
        }
        if(p.info == x){
            return 1; // da tim thay
        }
        if(x < p.info){
            return search(p.left, x);
        }else{
            return search(p.right, x);
        }
    }
    

    private int maxLevel(Node p){
        // neu cay rong thi chieu cao = 0
        // chạy đến khi nào root là null thì return
        if(p == null){
            return 0;
        }
        
        // tao 2 bien de tinh maxLevel ben trai / phai
        int maxLeftLevel = maxLevel(p.left);
        int maxRightLevel = maxLevel(p.right);
        // quy trinh hoat dong:
        /*
            root ban đầu gọi left, left gọi tiếp left.left đến khi nếu cả 2 con của nó null return về root
            root gọi đệ quy right và thực hiện tương tự với left
            cứ sau khi node nào hoàn thành xong check 2 bên thì sẽ return về maxLevel của node tại vtri đó
        */
        
        // dòng lệnh này để return về maxLevel tại node đó sau khi tìm tính dc max left / right;
        return 1 + Math.max(maxLeftLevel, maxRightLevel);
    }
    
    private int countNodes(Node p){
        if(p == null){
            return 0;
        }
        /*
            Phải cộng 1 là vì đếm node root hiện tại
            root ban đầu gọi đệ quy trái, sau khi chạy hết bên trái gặp null thì return
            bằng dòng lệnh bên dưới.
            tương tự với bên phải.
            sau cùng return về 
        */
        return 1 + countNodes(p.left) + countNodes(p.right);
    }
    
    private int countLeafNodes(Node p){
        if(p == null){
            return 0;
        }
        
        // lá nên sẽ ko có 2 con 2 ben
        int x = (p.left == null && p.right == null) ? 1 : 0;
        
        return x + countLeafNodes(p.left) + countLeafNodes(p.right);              
    }
    
    private int sum(Node p){
        if(p == null){
            return 0;
        }
        
        return p.info + sum(p.left) + sum(p.right);
    }

    // compute height: maxLevel - 1 = height;
    public int f1() {
        return maxLevel(root) - 1;
    }

    // count nodes
    public int f2() {
        return countNodes(root);
    }

    // count leaf nodes
    public int f3() {
        return countLeafNodes(root);
    }

    // compute sum of all nodes
    public int f4() {
        return sum(root);
    }

    // test preOrder
    public void f5() {
        this.preOrder(root);
    }

    // test inOrder
    public void f6() {
        this.inOrder(root);
    }

    // test postOrder
    public void f7() {
        this.postOrder(root);
    }

    // search
    public int f8(int x) {
        return this.search(root, 100);
    }
}
