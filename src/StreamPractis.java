import java.util.*;
import java.util.stream.Collectors;

record EMP(String name, String dep, double sal) {
    @Override
    public String toString() {
        return "EMP{" +
                "name='" + name + '\'' +
                ", dep='" + dep + '\'' +
                ", sal=" + sal +
                '}';
    }
}

public class StreamPractis {
    private static final List<EMP> emps = new ArrayList<>();

    static {
        emps.add(new EMP("Ram", "IT", 1000));
        emps.add(new EMP("Shyam", "IT", 2000));
        emps.add(new EMP("Ramesh", "HR", 5000));
        emps.add(new EMP("Anita", "HR", 4000));
        emps.add(new EMP("Sunita", "HR", 3000));
        emps.add(new EMP("Suresh", "OPS", 6000));
        emps.add(new EMP("Sumit", "OPS", 2000));
        emps.add(new EMP("Amit", "OPS", 1000));
        emps.add(new EMP("Mahesh", "ENG", 9000));
        emps.add(new EMP("Madan", "ENG", 12000));
        emps.add(new EMP("Jagan", "ENG", 20000));
    }

    static void main() {

        Map<String, Double> highestSalByDept = emps.stream()
                .collect(Collectors.groupingBy(EMP::dep,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(EMP::sal)),
                                emp -> emp.map(EMP::sal).orElse(0.0))));
        Map<String, Double> avgSalByDept = emps.stream()
                .collect(Collectors.groupingBy(EMP::dep,
                        Collectors.averagingDouble(EMP::sal)));



        System.out.println(highestSalByDept);
        System.out.println(avgSalByDept);
        System.out.println(emps.stream()
                .collect(Collectors.groupingBy(EMP::dep)));
//        System.out.println("" + emps.stream().filter(emp -> emp.dep().equals("IT")).toList());
    }
}
