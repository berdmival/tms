package lec_15.homework.task_04;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
	// метод, который называется find*** должен возвращать то, что он нашел
	public static void findPalindroms(String textForInspect) {
		SortedSet<String> wordsFromText = new TreeSet<>();

		Pattern pattern =
				Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
						| Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(textForInspect);

		while (matcher.find()) {
			if (isPalindrom(matcher.group())) {
				wordsFromText.add(matcher.group());
			}
		}
// ненужная пустая строка
		System.out.println(wordsFromText);
	}

	public static boolean isPalindrom (String word) {
		return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
	}
}
