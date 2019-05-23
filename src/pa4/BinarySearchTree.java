/**
 * A data structure represented as a tree where the left subtree of a node has a key 
 * less than its parent node, and the right subtree of a node has key greater than or equal to its parent.
 * 
 * @author Taha Quraishi
 */

package pa4;

public class BinarySearchTree {
	
	// Root of the BST.
	private NodeBST root;
	
	/**
	 * Costrcuts a BST and initializes the root.
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * Inserts a node into the BST.
	 * BST property is maintained.
	 * 
	 * @param z The node to insert into the BST.
	 */
	public void treeInsert(NodeBST z) {
		NodeBST y = null; // Creates node y and sets it to null.
		NodeBST x = root; // Creates node x and sets it to the root.
		while (x != null) { // Runs only if x is not null.
			y = x; // Sets y to x.
			if (z.getKey() < x.getKey()) { // Checks if z's key is less than x's key.
				x = x.getLeft(); // Sets x to its left node.
			} else {
				x = x.getRight(); // Sets x to its right node.
			}
		}
		z.setParent(y); // Sets z's parent node to y.
		if (y == null) { // Checks if y is null.
			root = z; // Sets the root to z.
		} else if (z.getKey() < y.getKey()) { // Checks if z's key is less than y's key.
			y.setLeft(z); // Sets y's left node to z.
		} else {
			y.setRight(z); // Sets y's right node to z.
		}
	}
	
	/**
	 * Prints the BST using in order traversal.
	 * 
	 * @param x The node to start the in order traversal from.
	 */
	public void inOrderTreeWalk(NodeBST x) {
		if (x != null) { // Checks if x is not null.
			inOrderTreeWalk(x.getLeft()); // Recursive call on x's left node.
			String serial = "" + ((x.getKey() / 1000) % 10) + ((x.getKey() / 100) % 10) + ((x.getKey() / 10) % 10) + ((x.getKey() / 1) % 10); // Gets the serial part of the node's SSN. 
			String group = "" + ((x.getKey() / 100000) % 10) + ((x.getKey() / 10000) % 10); // Gets the group part of the node's SSN.
			String area = "" + ((x.getKey() / 100000000) % 10) + ((x.getKey() / 10000000) % 10) + ((x.getKey() / 1000000) % 10); // Gets the area part of the node's SSN.
			String SSN = area + "-" + group + "-" + serial; // Formats the SSN.
			System.out.printf("%-10s %s\n", x.getName(), SSN); // Prints the node's name and SSN.
			inOrderTreeWalk(x.getRight()); // Recusrive call on x's right node.
		}
	}
	
	/**
	 * Replaces a subtree with anoter.
	 * 
	 * @param u A node.
	 * @param v A node.
	 */
	public void transplant(NodeBST u, NodeBST v) {
		if (u.getParent() == null) { // Checks if u's parent is null.
			root = v; // Sets root to v.
		} else if (u == u.getParent().getLeft()) { // Checks if u is equal to u's parent's left node.
			u.getParent().setLeft(v); // Sets u's parent's left node to v.
		} else {
			u.getParent().setRight(v); // Sets u's parent's right node to v.
		}
		if (v != null) { // Checks if v is not null.
			v.setParent(u.getParent()); // Set's v's parent to u's parent.
		}
	}
	
	/**
	 * Gets the minimum of the tree at the given node.
	 * 
	 * @param x The node to start the search.
	 * @return The minimum node.
	 */
	public NodeBST treeMinimum(NodeBST x) {
		while (x.getLeft() != null) { // Runs until x's left node is null.
			x = x.getLeft(); // Sets x to x's left node.
		}
		return x; // Returns the minimum node.
	}
	
	/**
	 * Deletes a node from the BST.
	 * BST property is maintained.
	 * 
	 * @param z The node to remove from the BST.
	 */
	public void treeDelete(NodeBST z) {
		if (z.getLeft() == null) { // Checks if z's left node is null.
			transplant(z, z.getRight()); // Calls the transplant method on z and z's right node.
		} else if (z.getRight() == null) { // Checks if z's right node is null.
			transplant(z, z.getLeft()); // Calls the transplant method on z and z's left node.
		} else {
			NodeBST y = treeMinimum(z.getRight()); // Creates node y and sets it to the minimum of the tree at z's right node.
			if (y.getParent() != z) { // Checks if y's parent is not z.
				transplant(y, y.getRight()); // Calls the transplant method on y and y's right node.
				y.setRight(z.getRight()); // Sets y's right node to z's right node.
				y.getRight().setParent(y); // Set y's right node's parent to y.
			}
			transplant(z, y); // Calls the transplant method on z and y.
			y.setLeft(z.getLeft()); // Sets y's left node to z's left node.
			y.getLeft().setParent(y); // Sets y's left node's parent to y.
		}
	}
	
	/**
	 * Gets the root of the BST.
	 * 
	 * @return Root node of the BST.
	 */
	public NodeBST getRoot() {
		return root;
	}

}
