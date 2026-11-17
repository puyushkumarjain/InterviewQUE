package cisco;


import java.util.*;

public class CiscoPrep {
/*
Given an array of positive integers, return the number of elements that are strictly greater than the average of all previous elements. Skip the first element.

Example

Input

responseTimes = [100, 200, 150,300]
Output

2
- Day 0: 100 (no previous days, skip)
- Day 1: 200 > average(100) = 100 → count = 1
- Day 2: 150 vs average(100, 200) = 150 → not greater → count = 1
- Day 3: 300 > average(100, 200, 150) = 150 → count = 2 Return 2.

 */

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {

        if (responseTimes.size() < 2)
            return 0;

        int count = 0;
        double sum = 0;
        for (int i = 1; i < responseTimes.size(); i++) {
            sum += responseTimes.get(i - 1);
            double average = sum / i;
            if (responseTimes.get(i) > average) {
                count++;
            }
        }

        return count;

    }

    public static int findSmallestMissingPositive(List<Integer> orderNumbers) {

        if (orderNumbers.isEmpty())
            return 1;
        orderNumbers.sort(Integer::compareTo);
        int expected = 1;
        for (int num : orderNumbers) {
            if (num == expected) {
                expected++;
            }
        }
        return expected;

    }

    public static int findSmallestMissingPositiveWOSorting(List<Integer> orderNumbers) {

        if (orderNumbers.isEmpty())
            return 1;
        int n = orderNumbers.size();
        for (int i = 0; i < n; i++) {

            while (orderNumbers.get(i) > 0 && orderNumbers.get(i) <= n &&
                    !orderNumbers.get(i).equals(orderNumbers.get(orderNumbers.get(i) - 1))) {
                swap(orderNumbers, i, orderNumbers.get(i) - 1);

            }
        }
        for (int i = 0; i < n; i++) {
            if (orderNumbers.get(i) != i + 1) {
                return i + 1;
            }
        }


        return n + 1;

    }

    private static void swap(List<Integer> orderNumbers, int i, int j) {
        int temp = orderNumbers.get(i);
        orderNumbers.set(i, orderNumbers.get(j));
        orderNumbers.set(j, temp);
    }

    public static boolean isAlphabeticPalindrome(String code) {


        if (code.isEmpty())
            return false;
        int left = 0;
        int right = code.length() - 1;
        while (left < right) {
            char lChar = code.charAt(left);
            char rChar = code.charAt(right);
            if (!Character.isLetter(lChar)) {
                left++;
            } else if (!Character.isLetter(rChar)) {
                right--;

            } else if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;

    }

    public static boolean isNonTrivialRotation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return false;
        }

        String concatenated = s1 + s1;
        return concatenated.contains(s2);

    }

    public static void maximizeNonOverlappingMeetings() {
        // Write your code here

        List<List<Integer>> meetings = Arrays.asList(
                List.of(1, 2),
                List.of(2, 3),
                List.of(3, 4),
                List.of(1, 3)
        );

        meetings.sort(Comparator.comparingInt(a -> a.get(1)));

        int res = 1;
        int lastEnd = meetings.getFirst().getLast();

        for (int i = 1; i < meetings.size(); i++) {
            List<Integer> curent = meetings.get(i);
            if (curent.get(0) >= lastEnd) {
                res++;
                lastEnd = curent.get(1);
            }
        }
    }

    public static boolean areBracketsProperlyMatched(String s) {

        if (s == null || s.isEmpty())
            return false;
        Deque<Character> brackets = new ArrayDeque<>();

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                brackets.push(c);
            }
            else if(c == ')' || c == '}' || c == ']'){
                if(brackets.isEmpty()) return false;
                char top = brackets.pop();

                if(c==')' && top != '(') return false;
                if(c=='}' && top != '{') return false;
                if(c==']' && top != '[') return false;

            }
        }


        return brackets.isEmpty();

    }

    public static void main(String[] args) {
        maximizeNonOverlappingMeetings();
    }
}
