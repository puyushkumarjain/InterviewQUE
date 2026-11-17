
@FunctionalInterface
interface MyFunc {
    void doSomthing();
//    void doSomthing1();
}


public class heyClass {

    public static int[] reHey(int[] numbers) {

        MyFunc myFunc= () -> System.out.println("sasd");

        myFunc.doSomthing();

        int[] result = new int[numbers.length];

        int index = 0;

        for (int i = 0; i < numbers.length; i++) {

            boolean mouse = false;

            for (int j = 0; j < i; j++) {

                if (numbers[i] != numbers[j]) {

                    mouse = true;

                    break;

                }

            }

            if (mouse) {

                result[index] = numbers[i];

                index++;

            }

        }

        return result;

    }

    public static void main(String[] args) {

        int[] numbers = { 20, 10, 30, 20, 40};

        int[] result = reHey(numbers);

        for (int n : result) {

            System.out.print(n + " ");

        }

    }

}
