package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import telran.interviews.DateRole;
import static telran.interviews.InterviewTasks.*;
import java.time.LocalDate;
import java.util.*;

class InterviewTasksTest {

	@Test
	void dateRolesTest() {
		List<DateRole> dateRoles = rolesInDates(
				List.of(new DateRole(LocalDate.parse("2017-10-12"), "Developer"),
						new DateRole(LocalDate.parse("2020-01-01"), "Team leader"),
						new DateRole(LocalDate.parse("2023-08-15"), "Project Manager")),
				List.of(LocalDate.parse("2015-01-01"), LocalDate.parse("2018-01-01"), LocalDate.parse("2023-01-01")));
		DateRole[] expected = { new DateRole(LocalDate.parse("2015-01-01"), null),
				new DateRole(LocalDate.parse("2018-01-01"), "Developer"),
				new DateRole(LocalDate.parse("2023-01-01"), "Team leader") };
		assertArrayEquals(expected, dateRoles.toArray(DateRole[]::new));
	}

	@Test
	void shuffledArrayTest() {
		int[] ar = { 1, 2, 3, 4, 5, 6, 7 };
		displayShuffled(ar);
	}

}