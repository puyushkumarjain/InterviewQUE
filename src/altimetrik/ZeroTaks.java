package altimetrik;

import java.util.Arrays;

public class ZeroTaks {

    public static void moveZerosToFront(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // Pointer to keep track of where the next non-zero element should go
        int insertPos = arr.length - 1;

        // Step 1: Scan from right to left and shift non-zero elements
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[insertPos] = arr[i];
                insertPos--;
            }
            System.out.println(Arrays.toString(arr));

        }

        // Step 2: Fill the remaining positions at the front with zeros
        System.out.println(insertPos);
        while (insertPos >= 0) {
            arr[insertPos] = 0;
            insertPos--;
        }
    }

    public static void move(int[] arr) {
        int st = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(arr, st, i);
                st++;

            } else {
                swap(arr, st, i);
            }
            System.out.println(Arrays.toString(arr));

        }
        if (arr[st] != 0) {
            swap(arr, st, arr.length - 1);
        }
    }

    public static void swap(int[] ar, int st, int end) {
        int tem = ar[st];
        ar[st] = ar[end];
        ar[end] = tem;
    }


    public static void moveLR(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[r] == 0) {
                swap(arr, l, r);
                l++;
            }
            r--;
            System.out.println();
            System.out.println(Arrays.toString(arr));
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -2, 0, -4, 0, 5};
        System.out.println(Arrays.toString(arr));

        move(arr);
//        moveLR(arr);
//        moveZerosToFront(arr);
        System.out.println(Arrays.toString(arr));
    }

}
