import java.util.*;

public class CodingSolution {
    public static void main(String[] args) {
        int[] ar = {1,2,3,6,8,9,4};
        int target = 5;
        Set<Integer> seen = new HashSet<>();
        for(int i=0; i<ar.length; i++){
            int com= target- ar[i];
            if(seen.contains(com)){
                System.out.println(com+", "+ar[i]);

            }
            else{
                seen.add(ar[i]);
            }


        }

    }
}
