package telran.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
	static public void printDigitStatistics() {
//	var map = new Random().ints(1_000_000, 0, Integer.MAX_VALUE)
//	.flatMap(n -> Integer.toString(n).chars()).mapToObj(d->(char)d)
//	.collect(Collectors.groupingBy(d -> d, Collectors.counting()));
		var map = new Random().ints(1_000_000, 0, Integer.MAX_VALUE).mapToObj(Integer::toString)
				.flatMap(s -> Arrays.stream(s.split(""))).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
	}

	static public void printSportLotoNumbers() {
		// prints random 6 unique numbers from 1 to 49 [1-49]
		new Random().ints(1, 50).distinct().limit(6).forEach(n -> System.out.print(n + " "));
	}
}