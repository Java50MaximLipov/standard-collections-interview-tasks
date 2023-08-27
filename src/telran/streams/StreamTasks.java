package telran.streams;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
	private static final int N_LIST_NUMBERS = 1_000_000;
	public List<Integer> randomNumbersList = getRandomNumbersList(N_LIST_NUMBERS);

	private List<Integer> getRandomNumbersList(int nListNumbers) {
		return new Random().ints(nListNumbers, 0, Integer.MAX_VALUE).boxed().collect(Collectors.toList());
	}

	public void printDigitStatistics(List<Integer> randomNumbersList) {
		Map<Integer, Long> digitOccurrences = randomNumbersList.stream().mapToInt(n -> n).boxed()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		digitOccurrences.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getKey(), e1.getKey()))
				.forEach(e -> System.out.printf("%d: %d\n", e.getValue(), e.getKey()));
	}
}