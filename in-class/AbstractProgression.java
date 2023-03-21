//cs 171 olivia kim

public abstract class AbstractProgression<T> implements ProgressionInterface<T> {
    protected T current;

    public AbstractProgression() {
        current = null;
    }

    public AbstractProgression(T curr) {
        current = curr;
    }

    public T nextValue() {
        T tmp = current;
        advance();
        return tmp;
    }

    public abstract void advance();

    public void printProgression(int n) {
        nextValue();
        for (int i = 1; i <= n; i++) {
            System.out.println(nextValue());
        }
    }
}
