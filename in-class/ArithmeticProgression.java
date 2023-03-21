//cs 171 olivia kim

public class ArithmeticProgression extends AbstractProgression<Integer> {
    private int update_value;

    public ArithmeticProgression() {
        super();
        update_value = 1;
        current = 1;
    }

    public ArithmeticProgression(int start, int updateval) {
        super(start);
        update_value = updateval;
    }

    public void advance() {
        current += update_value;
    }

    public static void main(String[] args) {
        ArithmeticProgression prog = new ArithmeticProgression();
        prog.printProgression(10);
    }
}
