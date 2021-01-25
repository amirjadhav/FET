
class StringTest {
    String test;

    StringTest() {
        test = "";
    }

    StringTest(String test) {
        this.test = test;
    }

    String cal() {
        int length = this.test.length();

        if (length % 2 == 0) {

            System.out.println("Center of String is : " + test.charAt(length / 2 - 1) + test.charAt(length / 2));

        } else {
            System.err.println("Center of String is : " + test.charAt(length / 2));
        }
        return "";
    }
}

public class CenterChar {
    public static void main(String[] args) {
        StringTest oT = new StringTest("abcde");
        System.out.println("Test:");
        oT.cal();
    }
}
