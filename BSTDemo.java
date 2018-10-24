package assignment8;


public class BSTDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree <String> bst = new BinarySearchTree<String>();
		
		bst.add("dog");
		bst.add("pelican");
		bst.add("zebra");
		bst.add("cat");
		bst.add("alpaca");
		bst.add("cow");
		bst.add("chupacabra");
		bst.add("dragon");
		
		System.out.println(bst.contains("cow"));
		System.out.println(bst.contains("monkey"));
		
		
		bst.writeDot("BST.dot");
	
		

		
		// Try inserting in alphabetical order instead
		// What happens to the shape (and thus performance) of the tree?
		
		/*
		bst.insert("alpaca");
		bst.insert("cat");
		bst.insert("chupacabra");
		bst.insert("cow");
		bst.insert("dog");
		bst.insert("dragon");
		bst.insert("pelican");
		bst.insert("zebra");
		*/
		
				
	}

}