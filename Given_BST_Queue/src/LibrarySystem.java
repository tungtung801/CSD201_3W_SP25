// QueueNode.java

class QueueNode {

    Book info;
    QueueNode next;

    QueueNode(Book x, QueueNode p) {
        info = x;
        next = p;
    }

    QueueNode(Book x) {
        this(x, null);
    }
}

// BookBST.java
class BookBST {

    Node root;

    BookBST() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void clear() {
        root = null;
    }

    Node search(Node p, String xTitle) {
        if (p == null) {
            return null;
        }
        if (p.info.getTitle().equals(xTitle)) {
            return p;
        }
        if (xTitle.compareTo(p.info.getTitle()) < 0) {
            return search(p.left, xTitle);
        } else {
            return search(p.right, xTitle);
        }
    }

    void insert(String title, int copies, int price) {
        // Implement this function - add a new book to BST
        // If the title already exists, update the copies
        // --------------------------------------------------------
        Book newBook = new Book(title, copies, price);
        root = insertRec(root, newBook);

        // --------------------------------------------------------
    }

    Node insertRec(Node p, Book newBook) {
        if (p == null) {
            p = new Node(newBook);
        } else if (newBook.getTitle().compareTo(p.info.getTitle()) < 0) {
            p.left = insertRec(p.left, newBook);
        } else if (newBook.getTitle().compareTo(p.info.getTitle()) > 0) {
            p.right = insertRec(p.right, newBook);
        } else if (newBook.getTitle().compareTo(p.info.getTitle()) == 0) {
            p.info.setCopies(p.info.getCopies() + newBook.getCopies());
        }
        return p;
    }

    void loadDataBooks(int k) {
        try {
            // Read book data from the data.txt file
            String[] titles = Lib.readLineToStrArray("data.txt", k - 1);
            int[] copies = Lib.readLineToIntArray("data.txt", k);
            int[] prices = Lib.readLineToIntArray("data.txt", k + 1);

            int n = titles.length;

            // Insert all books into the BST
            for (int i = 0; i < n; i++) {
                insert(titles[i], copies[i], prices[i]);
            }
        } catch (Exception e) {
            System.out.println("Error loading book data: " + e);

        }
    }
}

// BorrowQueue.java
class BorrowQueue {

    QueueNode front, rear;

    BorrowQueue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void clear() {
        front = rear = null;
    }

    void enQueue(String title, int copies) {
        // Implement this function - add a book borrow request to queue
        // --------------------------------------------------------
        if (copies > 0) {
            Book newBook = new Book(title, copies);
            QueueNode newNode = new QueueNode(newBook);
            if (!this.isEmpty()) {
                this.rear.next = newNode;
                this.rear = newNode;
            } else {
                this.front = this.rear = newNode;
            }
        }
        // --------------------------------------------------------
    }

    Book deQueue() {
        // Implement this function - remove and return a book borrow request
        // --------------------------------------------------------
        if (!this.isEmpty()) {
            Book temp = this.front.info;
            this.front = this.front.next;
            if (this.front == null) {
                this.rear = null;
            }
            return temp;
        } else {
            return null;
        }
        // --------------------------------------------------------
    }

    void loadDataRequests(int k) {
        try {
            // Read request data from the data.txt file
            String[] titles = Lib.readLineToStrArray("data.txt", k + 2);
            int[] copies = Lib.readLineToIntArray("data.txt", k + 3);

            int n = titles.length;

            // Add all borrow requests to the queue
            for (int i = 0; i < n; i++) {
                enQueue(titles[i], copies[i]);
            }
        } catch (Exception e) {
            System.out.println("Error loading request data: " + e);
        }
    }
}

// LibrarySystem.java
class LibrarySystem {

    BookBST bookCatalog = new BookBST();
    BorrowQueue borrowRequests = new BorrowQueue();

    LibrarySystem() {
    }

    void fvisit(Node p, java.io.RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, java.io.RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void ftraverse(java.io.RandomAccessFile f) throws Exception {
        f.writeBytes("Book Catalog (BST Preorder Traversal):\r\n");
        preOrder(bookCatalog.root, f);
        f.writeBytes("\r\n");
        f.writeBytes("Borrow Requests (Queue):\r\n");
        QueueNode p = borrowRequests.front;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getTitle() + "," + p.info.getCopies() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception {
        bookCatalog.loadDataBooks(k);
        borrowRequests.loadDataRequests(k);
    }

    void f1() throws Exception {
        // Test insert() function in BookBST and enQueue() function in BorrowQueue
        load(1);
        String fname = "f1.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    boolean borrowBook(Book request) {
        // Search for the book in the catalog
        Node node = bookCatalog.search(bookCatalog.root, request.getTitle());

        // If book found and has enough copies, process the borrow
        if (node != null && node.info.getCopies() >= request.getCopies()) {
            node.info.setCopies(node.info.getCopies() - request.getCopies());
            return true;
        }
        return false;
    }

    void f2() throws Exception {
        // Implement borrowing a single book from the queue
        load(1);
        String fname = "f2.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        ftraverse(f);

        // Implement processing one borrow request
        // --------------------------------------------------------
        if(!bookCatalog.isEmpty()){
            Book target = borrowRequests.deQueue();
            Node p = bookCatalog.search(bookCatalog.root, target.getTitle());
            if(p!=null && p.info.getCopies() >= target.getCopies()){
                p.info.setCopies(p.info.getCopies() - target.getCopies());
            }
        }
        // --------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        // Implement borrowing all books from the queue
        load(1);
        String fname = "f3.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        ftraverse(f);

        // Implement processing all borrow requests
        // --------------------------------------------------------
        this.borrowBook2();
        // --------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int borrowBook2() {
        int S = 0;
        while (!borrowRequests.isEmpty()) {
            Book target = borrowRequests.deQueue();
            Node p = bookCatalog.search(bookCatalog.root, target.getTitle());
            
            if (p!= null && p.info.getCopies() >= target.getCopies()) {
                p.info.setCopies(p.info.getCopies() - target.getCopies());
                S += p.info.getPrice() * target.getCopies();
            }
        }
        return S;
    }

    void f4() throws Exception {
        // Calculate total value of borrowed books
        load(1);
        String fname = "f4.txt";
        java.io.File g123 = new java.io.File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        java.io.RandomAccessFile f = new java.io.RandomAccessFile(fname, "rw");
        ftraverse(f);

        int totalValue = 0;

        // Implement calculating the total value of all borrowed books
        // --------------------------------------------------------
        totalValue += this.borrowBook2();
        // --------------------------------------------------------
        f.writeBytes("Total Value of Borrowed Books: " + totalValue + "\r\n");
        f.close();
    }
}
