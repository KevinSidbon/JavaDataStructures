public class Stack<T> {
    private final LinkedList<T> stack;

    Stack(){
        stack = new LinkedList<>();
    }

    public void push(T data){
        stack.add_head(data);
    }

    public LinkedList.Node<T> pop() throws Exception {
        return stack.remove(0);
    }

    public void enumerate(){
        this.stack.enumerate();
    }

    public int getLength(){
        return this.stack.getLength();
    }

    public LinkedList.Node<T> getHead(){
        return this.stack.getHead();
    }

//  The following is not interesting for a stack but will keep it commented out
//    public LinkedList.Node<T> getTail(){
//        return this.stack.getTail();
//    }
}
