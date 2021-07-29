package javafx.thread;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BouncingBall implements Runnable {
    private final Circle ball;
    private final Pane parent;
    private double dx;
    private double dy;
    private final BallCounter counter;
    private int localCounter;

    public BouncingBall(Circle ball, Pane parent, double dx, double dy, BallCounter counter) {
        this.ball = ball;
        this.parent = parent;
        this.dx = dx;
        this.dy = dy;
        this.counter = counter;
    }


    @Override
    public void run() {
        //warunek testuje, czy do wątku dotarł sygnał przerwania
        while (!Thread.currentThread().isInterrupted()) {
            //Musimy
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                //ewentualnie można wstawić break lub return, aby zakończyć pętle lub całą metodę
               Thread.currentThread().interrupt();
            }
            double x = ball.getCenterX();
            double y = ball.getCenterY();
            double r = ball.getRadius();
            if (x - r + dx < parent.getLayoutX()){
                dx = - dx;
                //liczymy odbicia od lewej ścianki
                counter.increment();
                localCounter++;
            }
            if (x + r + dx> parent.getLayoutX() + parent.getWidth()) {
                dx = -dx;
            }
            if (y - r +dy < parent.getLayoutY() || y + r + dy > parent.getHeight()) {
                dy = -dy;
            }
            Platform.runLater(() -> {
                ball.setCenterX(ball.getCenterX() + dx);
                ball.setCenterY(ball.getCenterY() + dy);
            });
        }
        System.out.println("Zakończono animację!");
    }

    public int getLocalCounter() {
        return localCounter;
    }
}
