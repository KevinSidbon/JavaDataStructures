
// TODO: Create unit test

/**
 * Linked List Variation
 * @param <T>
 */
public class LinkedList<T> {

    private int length = 0;
    private Node<T> head;
    private Node<T> tail;

    LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void add(T data){
        Node<T> node = new Node<>(data);

        if(this.head == null){
            assert this.tail == null : new AssertionError("Internal Error 'LinkedList:add'. Head is null, yet tail is not");
            this.head = node;
        }
        else{
//            The code below is only here to show another way of doing it, but because I keep track of the tail,
//            the actual code is much faster and simpler.
//            Node<T> n = this.head;
//
//            while(n.next != null){
//                n = n.next;
//            }
//            n.next = node

            this.tail.next = node;
            node.previous = this.tail;
        }

        this.tail = node;

        this.length++;
    }

    /**
     * Overloaded method that inserts a node at the position requested, pushing the current node at that position to position + 1
     * @param position
     * @param data
     * @throws Exception
     */
    public void add(int position, T data) throws Exception {

        if(position < 0){
            throw new Exception("LinkedList:add(int position, T data) - input position is less than 0");
        }
        else if(position >= this.length){
            throw new Exception("LinkedList:add(int position, T data) - input position is bigger than the length of list");
        }

        Node<T> node = new Node<>(data);
        Node<T> currentNode = this.head;
        int pos = 0;
        if(position == 0){
            this.add_head(data);
            return;
        }
        else{
            while(pos != position){
                currentNode = currentNode.next;
                pos++;
            }

            node.previous = currentNode.previous;
            node.next = currentNode;
            currentNode.previous.next = node;
            currentNode.previous = node;
            currentNode.next = null;

        }

        this.length++;
    }

    /**
     * Inserts a node at the position requested, pushing the current node at that position to position + 1.
     * Does the same as add(int position, T data), but can clear any ambiguity inside your code.
     * @param position
     * @param data
     * @throws Exception
     */
    public void insert(int position, T data) throws Exception {
        this.add(position, data);
    }

    public void add_head(T data){
        Node<T> node = new Node<>(data);

        if(this.head == null){
            assert this.tail == null : new AssertionError("Internal Error 'LinkedList:add_head'. Head is null, yet tail is not");
            this.head = node;
            this.tail = node;
        }
        else {
            assert this.tail != null : new AssertionError("Internal Error 'LinkedList:add_head'. Tail is null, yet head is not");
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
        }

        this.length++;
    }

    public void add_tail(T data){
        Node<T> node = new Node<>(data);
        if(this.tail == null){
            assert this.head == null : new AssertionError("Internal Error 'LinkedList:add_tail'. Tail is null, yet head is not");
            this.head = node;
        }
        else{
            assert this.head != null : new AssertionError("Internal Error 'LinkedList:add_tail'. Head null, but tail is not");
            this.tail.next = node;
            node.previous = this.tail;
        }

        this.tail = node;
        this.length++;
    }

    public Node<T> remove(int position) throws Exception{
        if(position < 0){
            throw new Exception("input 'position' needs to be positive or equals to 0");
        }
        else if(position >= this.length){
            throw new Exception("input 'int position' is larger than length - 1");
        }

        int pos = 0;
        Node<T> node = this.head;
        while(pos != position){
            node = node.next;
            pos++;
        }
        if(pos == 0){
            this.head = node.next;
            this.head.previous = null;
        }
        else if(pos == this.length-1){
            this.tail = node.previous;
            this.tail.next = null;
        }
        else{
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }

        this.length--;

        return node;
    }

    public int getLength(){
        return this.length;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> getTail(){
        return this.tail;
    }

    public void enumerate(){
        int pos = 0;
        Node<T> node = this.head;
        while(pos < this.length){
            System.out.println(node.data);
            node = node.next == null ? node:node.next;
            pos++;
        }
    }

    static class Node<T>{
        private final T data;

        Node<T> previous;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.previous = null;
            this.next = null;
        }

        public T getData(){
            return data;
        }
    }
}
