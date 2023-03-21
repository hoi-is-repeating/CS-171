
public class OverloadingNull {
    // version 1
    public static void method1(int a, float b) {
        System.out.println("int then float");
    }

    // version 2
    public static void method1(float a, int b) {
        System.out.println("float then int");
    }

    public static void method1(int a, int b) {
        System.out.println("int then int");
    }

    public static void method1(float a, float b) {
        System.out.println("float then float");
    }

    public static void nullTest() {
        // looking at null: a is a valid object and b is a null reference
        OverloadingNull a = new OverloadingNull();
        OverloadingNull b = null;
        System.out.println(null == b);
        System.out.println(null == a);
        System.out.println(a.equals(null));
        System.out.println(a.equals(a));
        System.out.println(a.equals(new OverloadingNull()));
        System.out.println(b.equals(null));
    }

    public static void callingmethod1() {
        int i = 0;
        float f = 2.45f;
        method1(i, f);
        method1(f, i);
        method1(i, i);
        method1(f, f);
    }

    public static void callingmethod1(int a, float b) {
        int i = a;
        float f = b;
        method1(i, f);
        method1(f, i);
        method1(i, i);
        method1(f, f);
    }

    public static void main(String[] args) {
        /*
         * 1. Predict what will be printed for each of the print statements in the
         * method nullTest,
         * then run the code and see if you were correct.
         */
        // nullTest();
        /*
         * 2. Predict which version of method 1 will be called for each line in the
         * method callingmethod1.
         * Then comment out the call above to nullTest, and uncomment the method
         * callingmethod1 and the call below.
         * Then run the code and see if you were correct.
         */
        callingmethod1();
        /*
         * 3. Write your own example of an overloaded method, writing at least two
         * different versions of a method.
         * The overloaded methods should have different results based on the given
         * parameters.
         * Here in the main method, write some test cases to demonstrate the
         * different versions of your method.
         */
        callingmethod1(3, 3.14f);
        callingmethod1(2, 2.252004f);
    }
}
