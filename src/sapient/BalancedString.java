package sapient;

public class BalancedString {
    public static int minDeletionsToBalance(String s) {
        int deletions = 0;
        int bCount = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                // Keep track of 'b's seen so far
                bCount++;
            } else { // c == 'a'
                // If we see an 'a' after seeing 'b's, we have an imbalance.
                // We have two choices:
                // 1. Delete this 'a' (cost: deletions + 1)
                // 2. Keep this 'a' and delete all previous 'b's instead (cost: bCount)
                deletions = Math.min(deletions + 1, bCount);
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        String test1 = "aababbab";
        String test2 = "bbaaaaabb";

        // Output will be 2 (Delete indices 2 and 6 to get "aaabbb")
        System.out.println("Deletions for test1: " + minDeletionsToBalance(test1));

        // Output will be 2 (Delete the first two 'b's to get "aaaaabb")
        System.out.println("Deletions for test2: " + minDeletionsToBalance(test2));
    }
}
