//package LeetCode;
//
//import BST.Node;
//
//public class KthSmallestBST {
//
//    public int kthSmallest(Node root, int k) {
//
//        int count = countNodes(root);
//
//        if (k <= count) {
//            return kthSmallest(root.left, k);
//        } else if (k > count + 1) {
//            return kthSmallest(root.right, k-1-count);
//        }
//
//        return root.val;
//    }
//
//    public int countNodes(Node n) {
//        if (n == null) {
//            return 0;
//        }
//
//        return 1 + countNodes(n.left) + countNodes(n.right);
//    }
//}
