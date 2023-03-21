public class Counter{

    //an integer instance variable
    private int count;

    //default constructor (count=0)
    public Counter(){

    }

    //alternate constructor
    public Counter(int initial){
        count = initial;
    }

    //accessor method
    public int getCount(){
        return count;
    }

    //update method
    public void increment(){
        count++;
    }

    //update method (overloaded)
    public void increment(int delta){
        count += delta;
    }

    //update method
    public void reset(){
        count = 0;
    }
}