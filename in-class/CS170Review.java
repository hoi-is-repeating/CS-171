public class CS170Review {

    /*
     * -------------------- EXERCISE #1 ----------------------
     * Write a Java method isMultiple that takes two values n and m, and returns
     * true
     * if and only if n is a multiple of m, that is n=mi for some integer i.
     * 
     * 1. What data type should n and m be? integers
     * 2. What is the method return type? boolean
     * 3. What operator(s)/ syntax structure(s) can be used to implement the method?
     * %
     * 4. Write at least 3 test cases in the main method to check your
     * implementation.
     */
    public static boolean isMultiple(int n, int m) {
        if (m % n == 0)
            return true;
        return false;
    }
    /*
     * -------------------- EXERCISE #2 ----------------------
     * Write a Java method that counts the number of vowels in a given String.
     * 
     * 1. What data type should the input be? String
     * 2. What is the method return type? int
     * 3. What operator(s)/ syntax structure(s) can be used to implement the method?
     * ==
     * 4. Write at least 3 test cases in the main method to check your
     * implementation.
     */

    public static int isVowel(String yarn) {
        char[] meow = yarn.toCharArray();
        int cnt = 0;
        for (int i = 0; i < meow.length; i++) {
            if (meow[i] == 'a' || meow[i] == 'e' || meow[i] == 'i' || meow[i] == 'o' || meow[i] == 'u')
                cnt++;
        }
        return cnt;
    }

    /*
     * -------------------- EXERCISE #3 ----------------------
     * Write a Java method inorder that takes an array of integers as a parameter,
     * and returns the count of elements that are smaller than the element
     * immediately following it.
     * For example, if the array consists of 3, 7, 8, 5, 4, 9, the method should
     * return 3
     * because 3<7, 7<8, and 4<9.
     * 
     * 1. What data type should the input be?
     * 2. What is the method return type?
     * 3. What operator(s)/ syntax structure(s) can be used to implement the method?
     * 4. Write at least 3 test cases in the main method to check your
     * implementation.
     */

    public static int inOrder(int[] param) {
        int cnt = 0;
        for (int i = 0; i < param.length - 1; i++) {
            if (param[i] < param[i + 1])
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // isMultiple
        System.out.println(isMultiple(5, 10));
        System.out.println(isMultiple(3, 7));
        System.out.println(isMultiple(5, 36));

        // isVowel
        System.out.println(isVowel("apple"));
        System.out.println(isVowel("yum"));
        System.out.println(isVowel("olivia"));

        // inORder
        int[] doesitwork = { 3, 7, 8, 5, 4, 9 };
        System.out.println(inOrder(doesitwork));
        int[] idontknow = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(inOrder(idontknow));
        int[] youresupposedtoknow = { 2, 4, 9, 5, 3 };
        System.out.println(inOrder(youresupposedtoknow));
    }
}
