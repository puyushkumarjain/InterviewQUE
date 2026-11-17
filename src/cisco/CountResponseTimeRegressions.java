package cisco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CountResponseTimeRegressions {


    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {

        if (responseTimes.size() < 2)
            return 0;

        int count = 0;
        double sum = 0;
        for (int i = 1; i < responseTimes.size(); i++) {
            sum += responseTimes.get(i - 1);
            double average = sum / i;
            if (responseTimes.get(i) > average) {
                count++;
            }
        }

        return count;


    }

    static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int responseTimesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> responseTimes = IntStream.range(0, responseTimesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = CountResponseTimeRegressions.countResponseTimeRegressions(responseTimes);

        System.out.println(result);

        bufferedReader.close();
    }
}
