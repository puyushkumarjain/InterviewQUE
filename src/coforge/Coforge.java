package coforge;

import java.util.ArrayList;
import java.util.Collections;

public class Coforge {
    public static void main(String[] args) {
        int [] taskDurations = {1, 2, 3, 4, 5};

        System.out.println(new ArrayList<>(Collections.singleton(taskDurations)));
    }
}
