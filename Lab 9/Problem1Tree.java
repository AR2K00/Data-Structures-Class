import java.util.*;

public class Problem1Tree {
    private static List<Integer> nodeListpre = new LinkedList<>();
    private static List<Integer> nodeListin = new LinkedList<>();
    private static List<Integer> nodeListpost = new LinkedList<>();


    // returns a list of binary-tree nodes in in-order.
    public static List<Integer> createListpre(TreeNode<Integer> node) {

        if(node !=  null) {
            nodeListpre.add(node.data);
            nodeListpre= createListpre(node.left);
            nodeListpre= createListpre(node.right);
        }
        return nodeListpre;
    }
    public static List<Integer> createListin(TreeNode<Integer> node) {
        if(node !=  null) {
            nodeListin= createListin(node.left);
            nodeListin.add(node.data);
            nodeListin= createListin(node.right);
        }
        return nodeListin;
    }
    public static List<Integer> createListpost(TreeNode<Integer> node) {

        if(node !=  null) {
            nodeListpost= createListpost(node.left);
            nodeListpost= createListpost(node.right);
            nodeListpost.add(node.data);
        }
        return nodeListpost;
    }

    public static void main(String[] args) {
        // Declare the 11 nodes for the problem 1 example
        TreeNode               root,
                node1,                node2,
                node3,         node4,     node5,
                node6, node7,  node8,  node9,    node10;

        // Initialize problem 1 tree data
        root = new TreeNode(49);
        node1 = new TreeNode(21);
        node2 = new TreeNode(68);
        node3 = new TreeNode(20);
        node4 = new TreeNode(40);
        node5 = new TreeNode(55);
        node6 = new TreeNode(11);
        node7 = new TreeNode(19);
        node8 = new TreeNode(33);
        node9 = new TreeNode(44);
        node10 = new TreeNode(66);

        // link the nodes as shown in the picture
        // (the tree picture is in the homework instructions)
        root.left = node1; root.right = node2;
        node1.left = node3; node1.right = node4;
        node2.left = node5;
        node3.left = node6; node3.right = node7;
        node4.left = node8; node4.right = node9;
        node5.right = node10;

        // print the list of tree nodes
        System.out.println(createListpre(root));
        System.out.println(createListin(root));
        System.out.println(createListpost(root));
        //System.out.println(createList(node3));
    }
}