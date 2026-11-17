package sapient;

public class Solution {
    public static int solution(int[] arr) {
        boolean[] present = new boolean[arr.length + 1];

        for (int value : arr) {
            if (value > 0 && value <= arr.length) {
                present[value] = true;
            }
        }

        for (int candidate = 1; candidate <= arr.length; candidate++) {
            if (!present[candidate]) {
                return candidate;
            }
        }

        return arr.length + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(arr));
    }
}
