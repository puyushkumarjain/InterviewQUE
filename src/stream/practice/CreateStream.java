package stream.practice;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CreateStream {
    public static void main(String[] args) {
        String str = "madam  ";
       long count= str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().filter(cout -> cout % 2==1).count();
        System.out.println(count);

    }
}
