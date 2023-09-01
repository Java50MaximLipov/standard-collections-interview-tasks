package telran.stream.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import telran.stream.StreamTasks;

class StreamTests {
	private static final int N_GROUP_NUMBERS = 100;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void test() {
		int[] ar = { 1, 2, 3, 4 };
		int sum = Arrays.stream(ar).sum(); // sum of the numbers
		assertEquals(10, sum);
		sum = Arrays.stream(ar).filter(n -> n % 2 == 0).sum(); // sum of the even numbers
		assertEquals(6, sum);
		IntSummaryStatistics statistics = Arrays.stream(ar).summaryStatistics();
		System.out.printf("sum=%d, avg=%f, min=%d, max=%d, count=%d", statistics.getSum(), statistics.getAverage(),
				statistics.getMin(), statistics.getMax(), statistics.getCount());
	}

	@Test
	@Disabled
	void sumGroupsTest() {
		List<Integer> group1 = getRandomGroup(N_GROUP_NUMBERS);
		List<Integer> group2 = getRandomGroup(N_GROUP_NUMBERS);
		List<Integer> group3 = getRandomGroup(N_GROUP_NUMBERS);
		List<List<Integer>> groups = List.of(group1, group2, group3);
		System.out.println("Sum of group numbers is " + getGroupsSum(groups));
	}

	private int getGroupsSum(List<List<Integer>> groups) {
		return groups.stream().flatMap(List::stream).mapToInt(n -> n).sum();
	}

	private List<Integer> getRandomGroup(int nGroupNumbers) {
		return new Random().ints(nGroupNumbers, 1, 100).boxed().toList();
	}

	@Test
	@Disabled
	void charsStringTest() {
		System.out.println();
		"Hello World".chars().forEach(ch -> System.out.printf("%c ", ch));
	}

	private void displayOccurrences(String[] strings) {
//		Map<String, Long> map = Arrays.stream(strings)
//		.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//		map.entrySet().stream().sorted((e1, e2) -> {
//			int res = Long.compare(e2.getValue(), e1.getValue());
//			if (res == 0) {
//				res = e1.getKey().compareTo(e2.getKey());
//			}
//			return res;
//		}).forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
		Map<String, Integer> map = getMap(strings);
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			if (res == 0) {
				res = e1.getKey().compareTo(e2.getKey());
			}
			return res;
		});
		list.forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
	}

	private Map<String, Integer> getMap(String[] strings) {
		Map<String, Integer> res = new HashMap<>();
		for (String str : strings) {
			res.merge(str, 1, Integer::sum);
		}
		return res;
	}

	@Test
	// @Disabled
	void displayOccurrencesTest() {
		String[] strings = { "lmn", "ab", "lmn", "ab", "c", "a", "lmn" };
		// lmn -> 3
		// ab -> 2
		// a -> 1
		// c -> 1
		displayOccurrences(strings);
	}

	@Test
	@Disabled
	void printDigitStatisticsTes() {
		StreamTasks.printDigitStatistics();
	}

	@Test
	@Disabled
	void printSportLotoNumbersTest() {
		for (int i = 0; i < 100; i++) {
			StreamTasks.printSportLotoNumbers();
			System.out.println();
		}
	}
}