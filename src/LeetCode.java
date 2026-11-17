import java.util.Arrays;

public class LeetCode {
    static void main() {
        int nums[] = {100, 4, 200, 1, 3, 2};
        if (nums.length == 0)
            return;

        int res = 1; int curr=0;
        Arrays.stream(nums)
                .sorted()
                .forEach(n -> {

                    if(n + 1 == curr){

                    }

                });
    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int res = 1;
        int cunt = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1])
                continue;

            if (nums[i] == nums[i - 1] + 1) {
                cunt++;
            } else {
                cunt = 1;
            }

            res = Math.max(res, cunt);


        }
        return res;
    }
}
