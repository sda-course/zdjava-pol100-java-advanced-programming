package javafx;

public class SimpleThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
            for(int i = 0; i < 10; i ++){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello World " + i);
            }
        }).start();
        for(int i = 0; i < 10; i++){
            Thread.sleep(1);
            System.out.println("START " + i);
        }
    }
}
