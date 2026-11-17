package cisco;

import java.util.*;

public class MergeAndSortIntervals {


    public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {

        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<List<Integer>> result = new ArrayList<>();

        intervals.sort(Comparator.comparingInt(i -> i.get(0)));
        List<Integer> lastIntv = intervals.get(0);


        for (int i = 1; i < intervals.size(); i++) {
            if (lastIntv.get(1) >= intervals.get(i).get(0)) {
                lastIntv.set(1, Math.max(lastIntv.get(1), intervals.get(i).get(1)));
                result.add(lastIntv);
            } else {
                result.add(intervals.get(i));
                lastIntv = intervals.get(i);
            }


        }
        return result;


    }

    public static List<List<Integer>> mergeHighDefinitionIntervalsAI(List<List<Integer>> intervals) {

        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<List<Integer>> result = new ArrayList<>();


        intervals.sort(Comparator.comparingInt(i -> i.get(0)));
        List<Integer> lastIntv = intervals.get(0);
        result.add(lastIntv);


        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> currentIntv = intervals.get(i);
            int curET = lastIntv.get(1);
            int nextST = currentIntv.get(0);
            int nextET = currentIntv.get(1);
            if (nextST <= curET) {
                lastIntv.set(1, Math.max(nextET, curET));
            } else {
                result.add(intervals.get(i));
                lastIntv = intervals.get(i);
            }


        }
        return result;


    }

    static void main() {
        List<List<Integer>> meetings = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 3)),
                new ArrayList<>(List.of(2, 6)),
                new ArrayList<>(List.of(8, 10)),
                new ArrayList<>(List.of(11, 15))
        ));
        System.out.println(mergeHighDefinitionIntervalsAI(meetings));
    }
}
