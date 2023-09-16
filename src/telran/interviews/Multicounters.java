package telran.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class Multicounters {
	HashMap<Object, Integer> items = new HashMap<>();
	TreeMap<Integer, Set<Object>> counters = new TreeMap<>();

	/**
	 * increments counter for a given item returns new counter value O[logN]
	 * 
	 * @param item
	 */
	public int addCounter(Object item) {
		int res = items.merge(item, 1, Integer::sum);
		if (res > 1) {
			removeItemFromCounters(item, res - 1);
		}
		counters.computeIfAbsent(res, k -> new HashSet<>()).add(item);
		return res;
	}

	/**
	 * removes item, throws NoSuchElementException if the item doesn't exists
	 * O[logN]
	 * 
	 * @param item
	 */
	public void removeItem(Object item) {
		int counter = getCounter(item);
		items.remove(item);
		Set<Object> itemsWithCounter = counters.get(counter);
		itemsWithCounter.remove(item);
		counters.remove(counter);
	}

	/**
	 * returns counter value for a given item, throws NoSuchElementException if the
	 * item doesn't exists O[1]
	 * 
	 * @param item
	 * @exception NoSuchElementException
	 */
	public int getCounter(Object item) {
		int counter = items.getOrDefault(item, 0);
		if (counter == 0) {
			throw new NoSuchElementException();
		}
		return counter;
	}

	/**
	 * gets set of items having counters in the given closed range O[logN]
	 * 
	 * @param counterFrom
	 * @param counterTo
	 */
	public Set<Object> getItemsByCounter(int counterFrom, int counterTo) {
		return counters.subMap(counterFrom, true, counterTo, true).values().stream().flatMap(Set::stream)
				.collect(Collectors.toSet());
	}

	/**
	 * returns set of items having maximal value of counters O[logN]
	 * 
	 * @param value
	 */
	public Set<Object> getItemsMaxCounter() {
		return counters.lastEntry().getValue();
	}

	private void removeItemFromCounters(Object item, int counter) {
		Set<Object> itemsWithCounter = counters.get(counter);
		itemsWithCounter.remove(item);
		counters.remove(counter);
	}
}
