package altimetrik;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Altimetrik {
    /*
        array : (-1,1,5,6,3)
        sum=4
        o/p : (-1,5) , (3,1)
     */
    public static void main(String[] args) {
        int[] ar = {-1, 1, 5, 2, 6, 3, 2};
        int sum = 4;
        int x = 0;
        int y = 1;

        StringBuffer res = new StringBuffer();


        for (int i = 0; i < ar.length; i++) {

            if (ar[x] + ar[y] == sum) {
                res.append(ar[x]).append(",").append(ar[y]).append(" \n");
                x++;
                y = x + 1;
            } else {
                y++;
            }
        }

        System.out.println(res);
        System.out.println();
        findPairs(ar, sum);
    }

    public static void findPairs(int[] arr, int targetSum) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;

            if (seen.contains(complement)) {
                System.out.println("(" + complement + "," + num + ")");
            }

            seen.add(num);
        }
    }

    public static List<Integer> findTaskPairForSlot(List<Integer> taskDurations, int slotLength) {
        // Write your code here
        if(taskDurations==null ||taskDurations.isEmpty()){
            return List.of(-1,-1);
        }
        HashMap<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < taskDurations.size(); i++){
            int complement = slotLength-taskDurations.get(i);
            if(seen.containsKey(complement))
            {
                return List.of(seen.get(complement),i);
            }
            seen.put(taskDurations.get(i), i);

        }

        return List.of(-1,-1);
    }

    static boolean find3Numbers(int[] A, int arr_size, int sum) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf("Triplet is %d,%d, %d", A[i], A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}
