package telran.interviews;

import java.util.List;

public interface Words {
	/**
	 * adds word
	 * 
	 * @param word
	 * @return true if added, otherwise false if an word already exists (case
	 *         insensitive)
	 */
	boolean addWord(String word);

	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	List<String> getWordsByPrefix(String prefix);
}