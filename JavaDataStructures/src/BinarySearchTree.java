public class BinarySearchTree{

    private BSTNode root;
    private int levelCount;
    private int degree;

    BinarySearchTree(){
        this.root = null;
        this.levelCount = 0;
    }

    public void insert(int data){
        BSTNode node = new BSTNode(data);
        if(this.root == null){
            this.root = node;
        }
        else{
            BSTNode current_node = this.root;
            while(current_node != null){
                if(data < current_node.data){
                    if(current_node.left == null){
                        current_node.left = node;
                        current_node = null;
                    }else{
                        current_node = current_node.left;
                    }
                }
                else{
                    if(current_node.right == null){
                        current_node.right = node;
                        current_node = null;
                    }
                    else{
                        current_node = current_node.right;
                    }
                }
            }
        }
    }

    static class BSTNode{
        private final int data;
        private BSTNode left;
        private BSTNode right;

        BSTNode(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public BSTNode getLeft() {
            return left;
        }

        public BSTNode getRight() {
            return right;
        }

        public void setLeft(BSTNode left) {
            this.left = left;
        }

        public void setRight(BSTNode right) {
            this.right = right;
        }
    }
}
