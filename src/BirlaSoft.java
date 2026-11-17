public class BirlaSoft {

    static void main() {

    }


    public static void swap() {
        int a = 10;
        int b = 15;

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + "  " + b);

    }

    public boolean isPaligdrom(int num) {
        if (num < 0) {
            return false;
        }

        int temp = num;
        int revNum = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            revNum = (revNum * 10) + lastDigit;
            num = num / 10;
        }

        return temp == revNum;
    }

    public void findFirstNonRepeating() {


        String s = "aaabbccdee";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                System.out.println(ch);
                break;
            }
        }
    }
}
