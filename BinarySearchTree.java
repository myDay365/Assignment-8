package assignment8;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;


public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {

	private Node root;
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually inserted); otherwise, returns false
	 * @throws NullPointerException if the item is null
	 */
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		Node nodeToAdd = new Node(item);
		Node currentNode = root;
		if (root == null) {
			root = nodeToAdd;
			size++;
		} else {
			
			while (true) { //As long as a tree is available
				
				int compare = (currentNode.data).compareTo(item); 
				if (compare < 0) { //Look at the right side of the tree
					if (currentNode.right == null) {
						currentNode.right = nodeToAdd;
						size++;
						break; //Once we the position 

					} else {
						currentNode = currentNode.right;
					}

				} else if (compare > 0) { //Look at the left side of the tree
					if (currentNode.left == null) {
						currentNode.left = nodeToAdd;
						size++;
						break; //Once we found the position
					} else {
						currentNode = currentNode.left;
					}
				} else { //If the node is already availabe
					return false;
				}

			}
		}
		return true;

	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually inserted); otherwise,
	 *         returns false
	 * @throws NullPointerException if any of the items is null
	 */

	@Override
	public boolean addAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		boolean setChanged = false;
		for (T thingInCollection : items) {
			boolean addingThings = add(thingInCollection);
			if (addingThings == true) {

				setChanged = true;
			}

		}
		return setChanged;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually inserted); otherwise,
	 *         returns false
	 * @throws NullPointerException if any of the items is null
	 */

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */

	@Override
	public void clear() {
		root = null;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item;
	 *         otherwise, returns false
	 * @throws NullPointerException if the item is null
	 */
	@Override
	public boolean contains(T item) {
		Node currentNode = root;
		while (true) {
			int compare = currentNode.data.compareTo((T) item);

			if (compare > 0) {
				if (currentNode.left == null) {
					return false;
				} else {
					currentNode = currentNode.left;
				}
			} else if (compare < 0) {
				if (currentNode.right == null) {
					return false;
				} else {
					currentNode = currentNode.right;
				}
			}

			else {
				// if the node is found
				return true;

			}

		}
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in
	 * this set that is equal to it.
	 * 
	 * @param items - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item
	 *         in this set that is equal to it; otherwise, returns false
	 * @throws NullPointerException if any of the items is null
	 */
	@Override
	public boolean containsAll(Collection<? extends T> items) {
		boolean containsItems = true;
		for (T findItem : items) {
			boolean checkingItem = contains(findItem);
			if (checkingItem == false) {
				containsItems = false;
			}
		}
		return containsItems;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public T first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		// If the node to the left is null then return the root
		if (root.left == null) {
			return root.data;
		} else {
			Node smallestNode = getLeftmostNode(root);
			return smallestNode.data;
		}
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public T last() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		// If the node to the right of the root is null return the root
		if (root.right == null) {
			return root.data;
		} else {
			Node largestNode = getRightmostNode(root);
			return largestNode.data;
		}

	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually removed); otherwise, returns false
	 * @throws NullPointerException if the item is null
	 */
	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;

	}

	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually removed); otherwise,
	 *         returns false
	 * @throws NullPointerException if any of the items is null
	 */
	@Override
	public boolean removeAll(Collection<? extends T> items) {
		// TODO Auto-generated method stub
		return false;

	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	@Override
	public ArrayList<T> toArrayList() {
		ArrayList<T> treeArray = new ArrayList<T>();
		inOrder(treeArray, root);
		return treeArray;
	}

	private void inOrder(ArrayList<T> arrayToFill, Node current) {
		if (current == null) {
			return;
		}
		inOrder(arrayToFill, current.left);
		arrayToFill.add(current.data);
		inOrder(arrayToFill, current.right);
	}

	public Node getLeftmostNode(Node current) {
		if (current.left == null) {
			return current;
		}
		return getLeftmostNode(current.left);
	}

	public Node getRightmostNode(Node current) {
		if (current.right == null) {
			return current;
		}
		return getRightmostNode(current.right);
	}

	public class Node {
		private T data;
		private Node left;
		private Node right;

		public Node(T element) {
			this.data = element;
			this.left = null;
			this.right = null;
		}

	}
	
	// Driver for writing this tree to a dot file
		public void writeDot(String filename)
		{
			try {
				// PrintWriter(FileWriter) will write output to a file
				PrintWriter output = new PrintWriter(new FileWriter(filename));

				// Set up the dot graph and properties
				output.println("digraph BST {");
				output.println("node [shape=record]");

				if(root != null)
					writeDotRecursive(root, output);
				// Close the graph
				output.println("}");
				output.close();
			}
			catch(Exception e){e.printStackTrace();}
		}


		// Recursive method for writing the tree to  a dot file
		private void writeDotRecursive(Node n, PrintWriter output) throws Exception
		{
			output.println(n.data + "[label=\"<L> |<D> " + n.data + "|<R> \"]");
			if(n.left != null)
			{
				// write the left subtree
				writeDotRecursive(n.left, output);

				// then make a link between n and the left subtree
				output.println(n.data + ":L -> " + n.left.data + ":D" );
			}
			if(n.right != null)
			{
				// write the left subtree
				writeDotRecursive(n.right, output);

				// then make a link between n and the right subtree
				output.println(n.data + ":R -> " + n.right.data + ":D" );
			}

		}

}
