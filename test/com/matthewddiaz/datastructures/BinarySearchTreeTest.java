import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by matthewdiaz on 8/30/16.
 */
public class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree;

    @Before
    public void setUp() throws Exception {
        this.binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testInsertElement() throws Exception {
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.printInOrderTraversal();
    }

    @Test
    public void testContainsElement() throws Exception {
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.containsElement(5);
        assertTrue(this.binarySearchTree.containsElement(5));
        assertTrue(this.binarySearchTree.containsElement(1));
        assertFalse(this.binarySearchTree.containsElement(2));
        assertTrue(this.binarySearchTree.containsElement(15));
    }

    @Test
    public void testRemoveElement() throws Exception {
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);

        this.binarySearchTree.removeElement(10);
        assertFalse(this.binarySearchTree.containsElement(10));
    }

    @Test
    public void testHeightOfTree() throws Exception {
        this.binarySearchTree.insertElement(9);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);
        this.binarySearchTree.insertElement(10);

        System.out.println(binarySearchTree.heightOfTree());
    }

    @Test
    public void testSumOfLeftLeaves() throws Exception {
        this.binarySearchTree.insertElement(9);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(14);
        System.out.println("Sum of left leaves is: " + this.binarySearchTree.sumOfLeftLeaves());
    }
}