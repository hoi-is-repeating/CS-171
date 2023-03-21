public class FibonacciProgression extends AbstractProgression<String> {
    private int repeat;
    private int end;
    private int[] mult;

    public FibonacciProgression() {
        super();
        repeat = 0;
        current = "";
    }

    public FibonacciProgression(int start1, int start2, int rep) {
        super();
        repeat = rep;
        mult = new int[repeat];
        mult[0] = start1;
        mult[1] = start2;
        for (int i = 2; i < repeat; i++) {
            end = mult[i] * mult[i - 1];
            advance();
        }

    }

    public void advance() {
        current = "" + end;
    }

    public static void main(String[] args) {

        AbstractProgression<String> nom = new FibonacciProgression(3, 1, 2);
        nom.printProgression(5);
    }
}
