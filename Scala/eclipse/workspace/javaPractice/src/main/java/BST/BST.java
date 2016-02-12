package BST;

public class BST {

    Node root;

    public BST(){
        root = null;
    }

    public void insert(int key){
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key){

        if(root == null){
            root = new Node(key);
        }else if (key > root.key){
            root.right = insertRec(root.right, key);
        }else {
            root.left = insertRec(root.left, key);
        }

        return root;
    }

    private Node inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }

        return root;
    }

    public Node inorder(){
        return inorderRec(root);
    }

     

    public static void main(String[] args) {
        BST tree = new BST();

        /* Let us create following BFS
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BFS
        tree.inorder();
    }
}

