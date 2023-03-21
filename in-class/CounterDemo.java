public class CounterDemo {
    public static void main(String[] args) {
        // 1. declare a Counter variable c (not yet constructed)
        Counter c;
        // 2. construct a default Counter (count=0) and assign its reference to c
        c = new Counter(0);
        // 3. declare and construct a Counter d with count=5
        Counter d = new Counter(5);
        // 4. increase count in c by 1
        c.increment();
        // 5. increase count in c by 3
        c.increment(3);
        // 6. get and print the count in c
        System.out.println(c.getCount());
        // 7. save the count in c in a variable
        int cnt = c.getCount();
        // 8. reset the count in c
        c.reset();
        // 9. increase count in d by 1
        d.increment();
        // 10. create a new reference e that references the same object as d
        Counter e = d;
        // 11. get and print the count of e
        e.increment();
        // 12. increase count in e by 2
        e.increment(2);
        // 13. get and print the count of e
        System.out.println(e.getCount());
        // 14. get and print the count of d
        System.out.println(d.getCount());
    }
}
