public class Main {
    public static void main(String[] args) throws Exception {
//        LinkedList<String> test = new LinkedList<String>();
//        test.add_head("first");
//        test.add_tail("second");
//        test.add("third");
//        test.add(2, "fourth");
//        test.enumerate();
//        System.out.println("==============");
//        LinkedList.Node<String> n = test.remove(2);
//        System.out.println("n = " + n.data);
//        test.enumerate();

        Stack<String> stringStack = new Stack<>();
        stringStack.push("first");
        stringStack.push("second");
        stringStack.push("third");
        LinkedList.Node<String> n = stringStack.pop();
        System.out.println("node data = " + n.getData());
        stringStack.push("fourth");
        stringStack.enumerate();
    }
}
