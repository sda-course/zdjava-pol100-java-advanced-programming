package javafx;

public class BallCounter {
    private volatile int counter;

    public synchronized void  increment(){
        counter++;
    }

    public int get(){
        return counter;
    }
}
