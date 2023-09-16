package telran.interviews;

import java.time.LocalDate;
import java.util.*;

public class InterviewTasks {
	public static void displayShuffled(int[] array) {
		new Random().ints(0, array.length).distinct().limit(array.length)
				.forEach(i -> System.out.print(array[i] + " "));
	}

	static public List<DateRole> rolesInDates(List<DateRole> datesRoles, List<LocalDate> dates) {
		TreeMap<LocalDate, String> mapDateRole = new TreeMap<>();
		datesRoles.forEach(dr -> mapDateRole.put(dr.date(), dr.role()));
		return dates.stream().map(d -> {
			Map.Entry<LocalDate, String> entry = mapDateRole.floorEntry(d);
			DateRole dr = new DateRole(d, entry == null ? null : entry.getValue());
			return dr;
		}).toList();
	}
}