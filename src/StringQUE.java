import java.util.HashMap;

public class StringQUE {
    static void main() {
        System.out.println(lengthOfLongestSubstring("abcabcadaeef"));
        System.out.println(lengthOfLongestSubstringChar("abcabcadaeef"));
        System.out.println(lengthOfLongestSubstringOld("abcabcadaeef"));
    }

    public static int lengthOfLongestSubstringOld(String s) {
        // Map to store the character and its most recent index
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If character is a duplicate inside the current window, move start
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= start) {
                start = charMap.get(currentChar) + 1;
            }

            // Update the map with the current character's index
            charMap.put(currentChar, end);

            // Update max length if current window is larger
            maxLength = Math.max(maxLength, end - start + 1);
            System.out.println(s.substring(start,end));
        }

        return maxLength;
    }
    //Given a string s, return the length of the longest substring without repeating characters.
    // Example: Input: "abcabcbb" → Output: 3 (substring is "abc")
    // Input: "bbbbb" → Output: 1 (substring is "b")
    public static int lengthOfLongestSubstring(String s) {
        // Base case: empty string has a length of 0
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Map to store the most recent index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Left boundary of the sliding window

        // Right boundary travels across the string
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already seen, move the left window pointer
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update or insert the current character's index
            map.put(currentChar, right);

            // Calculate window size and update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static int lengthOfLongestSubstringChar(String s) {
        if (s == null || s.length() == 0) return 0;

        // Array to store the last seen index of each character
        int[] lastSeen = new int[128];
        // Initialize all positions with -1 (not seen yet)
        java.util.Arrays.fill(lastSeen, -1);

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character was seen inside the current window, move left pointer
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }

            // Record the current character's index
            lastSeen[currentChar] = right;

            // Calculate maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

