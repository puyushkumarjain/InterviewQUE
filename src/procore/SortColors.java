package procore;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) zero++;
            else if (num == 1) one++;
            else if (num == 2) two++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero > 0) {
                nums[i] = 0;
                zero--;
            } else if (one > 0) {
                nums[i] = 1;
                one--;
            } else if (two > 0) {
                nums[i] = 2;
                two--;
            }
        }
    }

    public static void sortColorsAI(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) swap(nums, low++, mid++);
            else if (nums[mid] == 1) mid++;
            else swap(nums, mid, high--);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,0,2,1,1,0};
        int[] arr2 = {2,0,1};

//        sortColorsAI(arr1);
//        sortColorsAI(arr2);
//        System.out.println("sortColorsAI : "+ Arrays.toString(arr1));
//        System.out.println("sortColorsAI"+ Arrays.toString(arr2));
        sortColors(arr1);
        sortColors(arr2);
        System.out.println("sortColorsAI : "+ Arrays.toString(arr1));
        System.out.println("sortColorsAI"+ Arrays.toString(arr2));
    }
}
