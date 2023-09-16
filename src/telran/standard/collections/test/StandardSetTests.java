package telran.standard.collections.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardSetTests {
	Integer[] numbers = { 10, -7, 100, 13, 91, 5, 10, 11 };
	TreeSet<Integer> treeSet;

	@BeforeEach
	void setUp() {
		treeSet = new TreeSet<>(List.of(numbers));
	}

	@Test
	void distinctListTest() {
		Integer[] expected = { 10, -7, 100, 13, 91, 5, 11 };
		Integer[] actual = distinctList(List.of(numbers)).toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
	}

	List<Integer> distinctList(List<Integer> listWithRepeated) {
		return new ArrayList<>(new LinkedHashSet<Integer>(listWithRepeated));
	}

	@Test
	void treeSetTest() {
		Integer[] expected = { -7, 5, 10, 11, 13, 91, 100 };
		Integer[] actual = treeSet.toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
	}

	@Test
	void treeSubTest() {
		NavigableSet<Integer> subset10_13 = treeSet.subSet(10, true, 13, true);
		Integer[] expected = { 10, 11, 13 };
		Integer[] actual = subset10_13.toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
		subset10_13.add(12);
		Integer[] expected1 = { -7, 5, 10, 11, 12, 13, 91, 100 };
		Integer[] actualAll = treeSet.toArray(Integer[]::new);
		assertArrayEquals(expected1, actualAll);
		Integer[] expected2 = { -7, 5, 91, 100 };
		subset10_13.clear();
		actualAll = treeSet.toArray(Integer[]::new);
		assertArrayEquals(expected2, actualAll);
		assertThrowsExactly(IllegalArgumentException.class, () -> subset10_13.add(14));
		assertThrowsExactly(IllegalArgumentException.class, () -> subset10_13.add(9));
	}

}
