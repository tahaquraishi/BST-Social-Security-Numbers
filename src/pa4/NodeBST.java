/**
 * Represents a node.
 * Every node has a parent, right, and left node attached to it.
 * For this assignment, a node also contains a SSN and a name.
 * 
 * @author Taha Quraishi
 */

package pa4;

public class NodeBST {
	
	// SSN stored here.
	private int key;
	// Name stored here.
	private String name;
	// Parent node of this node.
	private NodeBST parent;
	// Right node of this node.
	private NodeBST right;
	// Left node of this node.
	private NodeBST left;
	
	/**
	 * Constructs a node with a given name and SSN.
	 * 
	 * @param name A name.
	 * @param key A SSN.
	 */
	public NodeBST(String name, int key) {
		this.name = name; // Stores name.
		this.key = key; // Stores SSN. 
		parent = null; // Initializes parent node to null.
		right = null; // Initializes right node to null.
		left = null; // Initializes left node to null.
	}
	
	/**
	 * Sets the parent node of this node.
	 * 
	 * @param parent A node that will become the parent node of this node.
	 */
	public void setParent(NodeBST parent) {
		this.parent = parent; // Sets the parent node.
	}
	
	/**
	 * Sets the right node of this node.
	 * 
	 * @param right A node that will become the right node of this node.
	 */
	public void setRight(NodeBST right) {
		this.right = right; // Sets the right node.
	}
	
	/**
	 * Sets the left node of this node.
	 * 
	 * @param left A node that will become the left node of this node.
	 */
	public void setLeft(NodeBST left) {
		this.left = left; // Sets the left node.
	}
	
	/**
	 * Gets the parent node.
	 * 
	 * @return The parent node.
	 */
	public NodeBST getParent() {
		return parent;
	}
	
	/**
	 * Gets the right node.
	 * 
	 * @return The right node.
	 */
	public NodeBST getRight() {
		return right;
	}
	
	/**
	 * Gets the left node.
	 * 
	 * @return The left node.
	 */
	public NodeBST getLeft() {
		return left;
	}
	
	/**
	 * Gets the SSN.
	 * 
	 * @return The SSN.
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return The name.
	 */
	public String getName() {
		return name;
	}

}
