package RandStand;

public class CodingTest {

    public static String Palindrome(String str) {
        // code goes here
    if(str==null){
        return "false";
    }

    str=str.replaceAll("\\s+", "").toLowerCase();

    int left=0;
    int right=str.length()-1;
    while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return "false";
        }
        left++;
        right--;

    }

    return "true";
}
    public static int TrappingWater(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalTrpWater = 0; // Cumulative trapped water volume
        int currentHeight = 0; // Active structural elevation filter

        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    currentHeight = leftMax - arr[left];
                    totalTrpWater += currentHeight;
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    currentHeight = rightMax - arr[right];
                    totalTrpWater += currentHeight;
                }
                right--;
            }
        }

        return totalTrpWater;
    }


    public static void main(String[] args) {
    System.out.println(Palindrome("racecar"));
//    System.out.println(TrappingWater(new int[]{0, 2, 4, 0, 2, 1, 2, 6}));
    }
}
