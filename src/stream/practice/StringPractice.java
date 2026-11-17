package stream.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringPractice {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("madam", "apple", "racecar", "java", "noon");

        List<String> palindromes = words.stream()
                .filter(StringPractice::isPalindrome)
                .collect(Collectors.toList());

        System.out.println(palindromes);
        // Output: [madam, racecar, noon]
    }

    private static boolean isPalindrome(String str) {
        if (str == null) return false;

        // Check character matching from start to the middle of the string
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
    }
}

