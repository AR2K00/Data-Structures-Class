// Binary tree test program.
import java.util.Random;

public class TreeTest
{
    public static void main(String[] args)
    {
        System.out.println("\n\t\t--- Test 1 --- \n");
        Tree<Integer> tree1 = new Tree<Integer>();

        // Various test cases follow below. Comment/uncomment the relevant lines to experiment
        // Integer[] values = {21, 68, 11, 13, 17, 66, 99};
        Integer[] values = {49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99}; //this tree has depth 4
        // Integer[] values = {18, 19, 32, 40, 49, 69, 28, 72, 83, 92, 11, 97, 99, 44, 71};
        // Integer[] values = {21, 68, 11, 13, 17, 66, 99}; // this would have depth 4
        // Integer[] values = {21, 13, 68, 11, 17, 66, 99};   // this would have depth 3
        //Integer[] values = {68, 66, 99};   // this would have depth 2
        System.out.println("Inserting the following values: ");
        for (Integer value : values) {
            System.out.printf("%d ", value);
            tree1.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree1.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree1.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree1.postorderTraversal();
        System.out.println();

//    System.out.print("\nThe depth of this tree is ");
        System.out.println("The depth of this tree is " + tree1.depth());

        System.out.println("\n\n\t\t--- Test 2 --- \n");
        System.out.println("---> Uncomment the relevant lines in the source code to run TEST 2. <---");
        Tree<Integer> tree2 = new Tree<Integer>();
        Random randomNumber = new Random(2168);
        System.out.println("Inserting the following values: ");

        // insert 10 random integers from 0-99 in tree2
        for (int i = 1; i <= 10; i++) {
           int value = randomNumber.nextInt(100);
           System.out.printf("%d ", value);
           tree2.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree2.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree2.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree2.postorderTraversal();
        System.out.println();

        System.out.print("\nThe depth of this tree is ");
        System.out.println(tree2.depth());
        System.out.println("Here is the tree: ");
        tree1.levelOrder();
    }
} // end class TreeTest
