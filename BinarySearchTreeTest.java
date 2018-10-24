package assignment8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {
	BinarySearchTree<String> stringTest = new BinarySearchTree<String>();
	BinarySearchTree<Integer> numberTest = new BinarySearchTree<Integer>();

	@Test
	public void addARoot() {
		String newRoot = "Hi";
		boolean didItAdd = stringTest.add(newRoot);
		int size = stringTest.size();
		if (size == 1 && didItAdd) {
			assert (true);
		} else {
			assert (false);
		}
	}

	@Test
	public void addFiveThingsAndCheckContainsAll() {
		ArrayList<String> addingStuff = new ArrayList<String>();
		addingStuff.add("T");
		addingStuff.add("W");
		addingStuff.add("I");
		addingStuff.add("C");
		addingStuff.add("E");
		boolean didItAtLeastOneThing = stringTest.addAll(addingStuff);
		boolean didItContainThem = stringTest.containsAll(addingStuff);

		if (didItAtLeastOneThing == true && didItContainThem == true && stringTest.size() == 5) {

			assert (true);
		}

	}

	@Test
	public void testGetFirst() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("G");
		adding.add("F");
		adding.add("R");
		adding.add("I");
		adding.add("E");
		adding.add("N");
		adding.add("D");
		stringTest.addAll(adding);
		String result = stringTest.first();
		String answer = "D";
		if (stringTest.size() != 7) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}
	}

	@Test
	public void testGetFirstAscending() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("A");
		adding.add("B");
		adding.add("C");
		adding.add("D");
		adding.add("E");
		adding.add("F");
		adding.add("G");
		stringTest.addAll(adding);
		String result = stringTest.first();
		String answer = "A";
		if (stringTest.size() != 7) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}
	}

	@Test
	public void testGetFirstDescending() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("G");
		adding.add("F");
		adding.add("E");
		adding.add("D");
		adding.add("C");
		adding.add("B");
		adding.add("A");
		stringTest.addAll(adding);
		String result = stringTest.first();
		String answer = "A";
		if (stringTest.size() != 7) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}
	}

	@Test
	public void testGetFirstRoot() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("E");
		adding.add("G");
		adding.add("F");
		adding.add("R");
		adding.add("I");
		adding.add("N");
		adding.add("D");
		stringTest.addAll(adding);
		String result = stringTest.first();
		String answer = "D";
		if (stringTest.size() != 7) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}
	}

	@Test
	public void testGetFirstIfNothing() {

		boolean resultingBoolean = false;
		try {
			String result = stringTest.first();
		} catch (NoSuchElementException E) {
			resultingBoolean = true;
		}
		if (stringTest.size() != 0) {
			resultingBoolean = false;
		}
		assert (resultingBoolean);
	}
	

	@Test
	public void testGetLastAscending() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("A");
		adding.add("B");
		adding.add("C");
		adding.add("D");
		adding.add("E");
		adding.add("F");
		adding.add("G");
		stringTest.addAll(adding);
		String result = stringTest.last();
		String answer = "G";
		if (stringTest.size() != 7) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}
	}

	@Test
	public void testGetLastDescending() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("G");
		adding.add("F");
		adding.add("E");
		adding.add("D");
		adding.add("C");
		adding.add("B");
		adding.add("A");
		stringTest.addAll(adding);
		String result = stringTest.last();
		String answer = "G";
		if (stringTest.size() != 7) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}
	}

	@Test
	public void testGetLast() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("G");
		adding.add("F");
		adding.add("R");
		adding.add("I");
		adding.add("E");
		adding.add("N");
		adding.add("D");
		stringTest.addAll(adding);
		String result = stringTest.last();
		String answer = "R";
		if (stringTest.size() != 7) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}

	}

	@Test
	public void testGetLastWithNumbers() {
		ArrayList<Integer> adding = new ArrayList<Integer>();
		adding.add(10);
		adding.add(13);
		adding.add(29);
		adding.add(462);
		adding.add(1012);
		adding.add(84075);
		adding.add(99);
		adding.add(5000);
		adding.add(6);
		adding.add(313);
		adding.add(6462);
		adding.add(64);
		adding.add(2008);
		adding.add(1994);
		numberTest.addAll(adding);
		Integer result = numberTest.last();
		Integer answer = 84075;
		if (numberTest.size() != 14) {
			assert (false);
		} else {
			assertEquals(answer, result);
		}
	}

	@Test
	public void testGetLastRoot() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("R");
		adding.add("G");
		adding.add("F");
		adding.add("I");
		adding.add("E");
		adding.add("N");
		adding.add("D");
		stringTest.addAll(adding);
		String result = stringTest.last();
		String answer = "R";
		assertEquals(answer, result);

	}

	@Test
	public void testGetLastIfNothing() {

		boolean resultingBoolean = false;
		try {
			String result = stringTest.last();
		} catch (NoSuchElementException E) {
			resultingBoolean = true;
		}
		assert (resultingBoolean);
	}

	@Test
	public void testIsEmpty() {
		if (stringTest.isEmpty() && stringTest.size() == 0) {
			assert (true);
		}

	}

	@Test
	public void toArrayWhenEmpty() {

		ArrayList<String> result = stringTest.toArrayList();
		if (result.size() == 0) {
			assert (true);
		}
	}

	@Test
	public void testToArraySimple() {
		ArrayList<String> adding = new ArrayList<String>();
		adding.add("G");
		adding.add("F");
		adding.add("R");
		adding.add("I");
		adding.add("E");
		adding.add("N");
		adding.add("D");
		stringTest.addAll(adding);
		
		Collection<String> list = new ArrayList<String>(Arrays.asList("D","E", "F", "G", "I", "N", "R"));

	    List<String> expected = new ArrayList<String>(list);
	    
		//ArrayList<String> expected = new ArrayList<String>(stringTest.toArrayList());
		System.out.println("To Array Simple: " + stringTest.toArrayList());
		Assert.assertEquals(stringTest.toArrayList(), expected);

	}
}
