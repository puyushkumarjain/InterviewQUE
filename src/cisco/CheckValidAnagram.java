package cisco;

import java.util.Arrays;

public class CheckValidAnagram {
    public static int isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return 0;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        return Arrays.stream(charCounts).anyMatch(c -> c != 0) ? 0 : 1;
    }

    static void main() {
        isAnagram("listen", "silent");
    }
}
