import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");


		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	/**
	 Test addFirst method
	 */
	@Test
	public void testAddFirst() {
		/* 1.add to empty deque(int) */
		LinkedListDeque<Integer> d1 = new LinkedListDeque<>();
		d1.addFirst(114514);
		assertEquals(114514, d1.get(0), 0);
		assertEquals(1, d1.size());
		/* 2.add to non-empty deque(String) */
		LinkedListDeque<String> d2 = new LinkedListDeque<>("aaa");
		d2.addFirst("bbb");
		d2.addFirst("ccc");
		assertEquals("aaa", d2.get(2));
		assertEquals(3, d2.size());
	}

	/**
	 Test addLast method
	 */
	@Test
	public void testAddLast() {
		/* 1.add to empty deque(double) */
		LinkedListDeque<Double> d1 = new LinkedListDeque<>();
		d1.addLast(114514.0);
		assertEquals(114514, d1.get(0), 0.0);
		assertEquals(1, d1.size());
		/* 2.add to non-empty deque(String) */
		LinkedListDeque<String> d2 = new LinkedListDeque<>("aaa");
		d2.addLast("bbb");
		d2.addLast("ccc");
		assertEquals("ccc", d2.get(2));
		assertEquals(3, d2.size());
		/* 3.add to a deque constructed by addFirst */
		LinkedListDeque<Integer> d3 = new LinkedListDeque<>();
		d3.addFirst(114514);
		d3.addFirst(1919);
		d3.addFirst(810);
		d3.addLast(514);
		assertEquals(810, d3.get(0), 0);
		assertEquals(114514, d3.get(2), 0);
		assertEquals(514, d3.get(3), 0);
		assertEquals(4, d3.size());
		/* 4.addFirst to a deque constructed by addLast */
		LinkedListDeque<Boolean> d4 = new LinkedListDeque<>();
		d4.addLast(false);
		d4.addLast(true);
		d4.addFirst(false);
		assertEquals(false, d4.get(0));
		assertEquals(false, d4.get(1));
		assertEquals(true, d4.get(2));
	}

	/**
	 * Test isEmpty and size method
	 */
	@Test
	public void testIsEmpty() {
		/* empty deque */
		LinkedListDeque<Double> emp = new LinkedListDeque<>();
		assertEquals(true, emp.isEmpty());
		/* non-empty deque */
		LinkedListDeque<Double> nonemp = new LinkedListDeque<>(0.0);
		assertEquals(false, nonemp.isEmpty());
		/* test size() */
		LinkedListDeque<Integer> d = new LinkedListDeque<>(0);
		d.addFirst(2);
		d.addLast(3);
		assertEquals(3, d.size());
	}

	/**
	 * test printDeque method, but no use of assertEquals
	 */
	@Test
	public void testPrintDeque() {
		/* int deque */
		LinkedListDeque<Integer> d1 = new LinkedListDeque<>();
		d1.addFirst(114514);
		d1.addFirst(1919);
		d1.addFirst(810);
		d1.addLast(514);
		System.out.println("expected: 810 1919 114514 514");
		d1.printDeque();
		/* double deque */
		LinkedListDeque<Double> d2 = new LinkedListDeque<>();
		d2.addLast(114.514);
		d2.addLast(1919.810);
		System.out.println("expected: 114.514 1919.810");
		d2.printDeque();
		/* String deque */
		LinkedListDeque<String> d3 = new LinkedListDeque<>("henghengheng");
		d3.addLast("AHHHHHHHHHH");
		d3.addLast("ahhhhh");
		System.out.println("expected: henghengheng AHHHHHHHHHH ahhhhh");
		d3.printDeque();
		/* boolean deque */
		LinkedListDeque<Boolean> d4 = new LinkedListDeque<>();
		d4.addLast(false);
		d4.addLast(true);
		d4.addFirst(false);
		System.out.println("expected: false false true");
		d4.printDeque();
	}

	/**
	 * test removeFirst and removeLast method
	 */
	@Test
	public void testRemove() {
		/* empty */
		LinkedListDeque<Double> emp = new LinkedListDeque<>();
		assertEquals(null, emp.removeFirst());
		assertEquals(null, emp.removeLast());
		/* 1 Node */
		LinkedListDeque<String> single = new LinkedListDeque<>("hello");
		assertEquals("hello", single.removeFirst());
		assertEquals(null, single.removeLast());
		single = new LinkedListDeque<>("hello");
		assertEquals("hello", single.removeLast());
		assertEquals(null, single.removeFirst());
		/* multiple Nodes */
		LinkedListDeque<Integer> d = new LinkedListDeque<>();
		d.addFirst(114514);
		d.addFirst(1919);
		d.addFirst(810);
		d.addLast(514);
		assertEquals(810, d.removeFirst(),0);
		assertEquals(514, d.removeLast(), 0);
		assertEquals(2, d.size());
	}

	/**
	 * test removeFirst and removeLast method
	 */
	@Test
	public void testGet() {
		LinkedListDeque<Integer> d = new LinkedListDeque<>();
		d.addFirst(114514);
		d.addFirst(1919);
		d.addFirst(810);
		d.addLast(514);
		assertEquals(810, d.get(0), 0);
		assertEquals(514, d.get(d.size()-1), 0);
		assertEquals(null, d.get(114514));
		assertEquals(810, d.getRecursive(0), 0);
		assertEquals(514, d.getRecursive(d.size()-1), 0);
		assertEquals(null, d.getRecursive(114514));
	}
	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
}
