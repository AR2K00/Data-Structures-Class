import java.util.LinkedList;

class TreeNode<Integer> {
    TreeNode left;
    Integer data; // node value
    TreeNode right;

    // Constructor. Initializes node data and makes this a leaf node.
    public TreeNode(Integer data) {
        this.data = data;
        left = right = null; // node has no children
    }
}