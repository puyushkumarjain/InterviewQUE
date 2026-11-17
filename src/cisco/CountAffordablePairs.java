package cisco;

import java.util.List;

public class CountAffordablePairs {

    public static int countAffordablePairs(List<Integer> prices, int budget) {
        int count = 0;
        if (prices.isEmpty())
            return count;

        for (int i = 0; i < prices.size(); i++) {
            for (int j = i + 1; j < prices.size(); j++) {

                if (prices.get(i) + prices.get(j) <= budget)
                    count++;

            }
        }
        return count;

    }
}
