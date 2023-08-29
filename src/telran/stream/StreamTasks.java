package telran.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
	static public void printDigitStatistics() {
//	Opt-1:
//		Map<Integer, Long> map = new Random().ints(1_000_000, 0, Integer.MAX_VALUE)
//				.flatMap(n -> Integer.toString(n).chars()).boxed()
//				.collect(Collectors.groupingBy(d -> d, Collectors.counting()));
//		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
//				.forEach(e -> System.out.printf("%c -> %s\n", e.getKey(), e.getValue()));
//	Opt-2:
//		Map<Character, Long> map = new Random().ints(1_000_000, 0, Integer.MAX_VALUE)
//				.flatMap(n -> Integer.toString(n).chars()).mapToObj(d -> (char) d)
//				.collect(Collectors.groupingBy(d -> d, Collectors.counting()));
//		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
//				.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
//	Opt-3:	
		var map = new Random().ints(1_000_000, 0, Integer.MAX_VALUE).mapToObj(Integer::toString)
				.flatMap(s -> Arrays.stream(s.split(""))).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		map.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
	}
}