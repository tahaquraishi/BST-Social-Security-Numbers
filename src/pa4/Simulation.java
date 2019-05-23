/**
 * Provides a user interface that allows the user to:
 * print the BST, insert a person, and remove a person.
 * 
 * @author Taha Quraishi
 */

package pa4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
	 
	// Scanner object created.
	public static Scanner scanner = new Scanner(System.in);
	// BST constructed.
	public static BinarySearchTree BST = new BinarySearchTree();
	// Nodes will be stored here.
	public static ArrayList<NodeBST> nodes = new ArrayList<NodeBST>();
	// SSNs will be stored here.
	public static ArrayList<Integer> SSNs;
	// Names will be stored here.
	public static ArrayList<String> names;

	
	/**
	 * The main method of the program. Calls the startUp()
	 * and displayUI() method.
	 * 
	 * @param args Compiler looks for this method.
	 */
	public static void main(String[] args) {
		startUp();
		displayUI();
	}
	
	/**
	 * Fills up the names and SSNs ArrayLists.
	 * Creates 20 nodes with a name and SSN.
	 * Adds every node into an ArrayList and into the BST.
	 */
	public static void startUp() {
		names = readFromFile("Names.txt"); // Stores all the names from the file.
		SSNs = generateSocialSecurityNumbers(); // Generates unique social security numbers.
		for (int i = 0; i < names.size(); i++) { // Loops through every name.
			nodes.add(new NodeBST(names.get(i), SSNs.get(i))); // Creates a node with a name and SSN, and adds it into an ArrayList.
			BST.treeInsert(nodes.get(i)); // Inserts the node into the BST.
		}
		System.out.println(names.size() + " users with generated SSNs have been inserted into the BST. Enter the first option to view the tree.\n");
	}
	
	/**
	 * Displays the BST using in order traversal.
	 */
	public static void displayBST() {
		BST.inOrderTreeWalk(BST.getRoot()); // Calls the in order traversal method of the BST.
		System.out.println();
	}
	
	/**
	 * Inserts a person into the BST.
	 */
	public static void insertPerson() {
		System.out.print("Enter name: "); // Asks the user for a name. 
		String name = scanner.nextLine(); // Stores the name.
		names.add(name); // Adds the name into the ArrayList.
		int key = 0; // SSN will be stored here.
		boolean done = false; // Used as a flag for the while loop.
		while (!done) { // Runs until a unique SSN is created.
			SocialSecurityNumber ssn = new SocialSecurityNumber(); // Creates a SSN.
			if (!(SSNs.contains(ssn.getSSNWithoutFormatting()))) { // Checks for duplicates.
				SSNs.add(ssn.getSSNWithoutFormatting()); // Adds the SSN into the SSNs ArrayList.
				key = ssn.getSSNWithoutFormatting(); // Sets the SSN.
				done = true; // Stops the loop.
			}
		}
		nodes.add(new NodeBST(name, key)); // Adds a new node with the given name and SSN into the nodes ArrayList.
		BST.treeInsert(nodes.get(nodes.size() - 1)); // Inserts the last node in the ArrayList into the BST.
		String serial = "" + ((key / 1000) % 10) + ((key / 100) % 10) + ((key / 10) % 10) + ((key / 1) % 10); // Gets the serial part of the SSN.
		String group = "" + ((key / 100000) % 10) + ((key / 10000) % 10); // Gets the group part of the SSN.
		String area = "" + ((key / 100000000) % 10) + ((key / 10000000) % 10) + ((key / 1000000) % 10); // Gets the area part of the SSN.
		String SSN = area + "-" + group + "-" + serial; // Formats the SSN.
		System.out.println(name + "'s generated SSN is " + SSN + ". This person has been added into the BST.\n");
	}
	
	/**
	 * Removes a person from the BST.
	 */
	public static void removePerson() {
		System.out.print("Enter name: "); // Aks the user for a name.
		String name = scanner.nextLine(); // Stores the name.
		boolean found = false; // Used as a flag for the while loop.
		int position = 0; // Position of the node containing the name will be stored here.
		for (int i = 0; i < nodes.size(); i++) { // Loops through the nodes.
			if (nodes.get(i).getName().equalsIgnoreCase(name)) { // Looks for a node containing the name.
				BST.treeDelete(nodes.get(i)); // Deletes the node at the current position.
				position = i; // Stores the current position.
				found = true; // Stops the loop.
			}
		}
		if (found == true) { // Checks if the node was deleted.
			nodes.remove(position); // Removes the node from the ArrayList.
			System.out.println(name + " has been removed from the BST.\n");
		} else {
			System.out.println("Could not find user.\n");
		}
	}
	
	/**
	 * Displays the UI. Allows the user to:
	 * display the BST, insert a person, remove a person, and exit the program.
	 */
	public static void displayUI() {
		boolean done = false;
		while (!done) { 
			System.out.println(" ========================================");
			System.out.println("|                                        |");
			System.out.println("|      Binary Search Tree Simulation     |");
			System.out.println("|                                        |");
			System.out.println(" ========================================");
			System.out.println("| Options:                               |");
			System.out.println("| 1 >> Display BST                       |");
			System.out.println("| 2 >> Insert Person                     |");
			System.out.println("| 3 >> Remove Person                     |");
			System.out.println("| 4 >> Exit                              |");
			System.out.println(" ========================================");
			System.out.print("\nPlease enter an option number above: ");
			String option = scanner.nextLine();
			if (option.equals("1")) {
				displayBST(); // Displays the BST using in order traveral if the first option is called.
			} else if (option.equals("2")) {
				insertPerson(); // Inserts a person into the BST if the second option is called.
			} else if (option.equals("3")) {
				removePerson(); // Removes a person from the BST if the third option is called.
			} else if (option.equals("4")) {
				System.out.println("Thank you for using the Binary Search Tree Simulation. Goodybe.");
				done = true; // Quits the program if the fourth option is called.
			} else {
				System.out.println("You must enter an option displayed in the user interface!\n");
			}
		}
	}

	/**
	 * Generates unique SSNs.
	 * 
	 * @return ArrayList containing the unique SSNs.
	 */
	public static ArrayList<Integer> generateSocialSecurityNumbers() {
		ArrayList<Integer> noDuplicates = new ArrayList<Integer>(); // Unique SSNs will be stored here.
		while (noDuplicates.size() < names.size()) { // Runs until there is an SSN for every name.
			SocialSecurityNumber ssn = new SocialSecurityNumber(); // Creates a SSN.
			if (!(noDuplicates.contains(ssn.getSSNWithoutFormatting()))) { // Checks if the SSN isn't in the ArrayList.
				noDuplicates.add(ssn.getSSNWithoutFormatting()); // Adds the SSN.
			}
		}
		return noDuplicates; // Returns the ArrayList containing uniqye SSNs.
	}
	
	/**
	 * Reads every line in the file, adds each into an ArrayList, and returns it.
	 * 
	 * @param fileName The file to read from.
	 * @return ArrayList containing every line in the file.
	 */
	public static ArrayList<String> readFromFile(String fileName) {
		ArrayList<String> names = new ArrayList<String>(); // Every line in the file will be stored here.
		try { // Try block for I/O handling.
			FileReader fr = new FileReader(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "PA4-Section 7-Quraishi" + File.separator + "Text Files" + File.separator + fileName); // Creates a FileReader object in order to read the given file.
			BufferedReader br = new BufferedReader(fr); // Creates a BufferedReader. 
			String line = ""; // Line will be stored here.
			while ((line = br.readLine()) != null) { // Loop runs until there are no more lines, reads a line.
				names.add(line); // Adds the line into the ArrayList.
			}
			br.close(); // Closes the BufferedReader.
			fr.close(); // Closes the FileReader.
		} catch (IOException x) { // Catch block in case of I/O error.
			x.getMessage(); // Prints the error message.
		}
		return names; // Returns the ArrayList containing every line in the file.
	}

}
