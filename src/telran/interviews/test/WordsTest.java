package telran.interviews.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.AutoCompletion;
import telran.interviews.Words;

class WordsTest {
	String words[] = { "abcdef", "ab123", "aaa", "ab", "ablmn", "abbbb", "a", "ABd", "bbb", "B12", "*/" };
	String wordsStartB[] = { "B12", "bbb" };
	String wordsStartAB[] = { "ab", "ab123", "abbbb", "abcdef", "ABd", "ablmn" };
	String wordsStartABC[] = { "abcdef" };
	String wordsStartAsteric[] = { "*/" };
	Words autoCompletion;

	@BeforeEach
	void setUp() throws Exception {
		autoCompletion = new AutoCompletion();
		for (String word : words) {
			autoCompletion.addWord(word);
		}
	}

	@Test
	void test() {
		assertArrayEquals(wordsStartABC, autoCompletion.getWordsByPrefix("abc").toArray(String[]::new));
		assertArrayEquals(wordsStartB, autoCompletion.getWordsByPrefix("B").toArray(String[]::new));
		assertArrayEquals(wordsStartAB, autoCompletion.getWordsByPrefix("ab").toArray(String[]::new));
		assertArrayEquals(wordsStartAsteric, autoCompletion.getWordsByPrefix("*").toArray(String[]::new));
	}
}