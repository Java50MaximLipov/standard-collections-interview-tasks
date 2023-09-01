package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyStack;

class MyStackTest {
	int ar[] = { 100_000, 50_000, 100_000, 20, 20, 20, 2_000_000, 2_000_000 };
	MyStack<Integer> myStack;
	MyStack<String> emptyStack = new MyStack<>();

	@BeforeEach
	void setUp() throws Exception {
		myStack = new MyStack<>();
		fillStack(myStack);
	}

	private void fillStack(MyStack<Integer> stack) {
		for (int num : ar) {
			stack.push(num);
		}
	}

	@Test
	void testPop() {
		assertEquals(2_000_000, myStack.pop());
		assertEquals(2_000_000, myStack.pop());
		assertThrowsExactly(NoSuchElementException.class, () -> emptyStack.pop());

	}

	@Test
	void testIsEmpty() {
		assertFalse(myStack.isEmpty());
		assertTrue(emptyStack.isEmpty());
	}

	@Test
	void testGetMax() {
		assertEquals(2_000_000, myStack.getMax());
		myStack.pop();
		assertEquals(2_000_000, myStack.getMax());
		myStack.pop();
		assertEquals(100_000, myStack.getMax());
		myStack.push(100);
		assertEquals(100_000, myStack.getMax());
		myStack.push(1_000_000);
		assertEquals(1_000_000, myStack.getMax());
		assertThrowsExactly(NoSuchElementException.class, () -> emptyStack.getMax());

	}

	@Test
	void testComparator() {
		MyStack<Integer> reversedStack = new MyStack<>((a, b) -> Integer.compare(b, a));
		fillStack(reversedStack);
		assertEquals(20, reversedStack.getMax());
	}

}