package sapient;
public class CodingTest {


    public static int missingNumber(int[] arr) {
        int n = arr.length + 1; // Total numbers including the missing one
        int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum; // The missing number
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 1, 2};
        System.out.println(missingNumber(arr));
    }
}