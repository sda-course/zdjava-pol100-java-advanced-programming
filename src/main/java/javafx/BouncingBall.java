package javafx;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class BouncingBall implements Runnable {
    private final Circle ball;
    private final Group parent;
    private double dx;
    private double dy;
    private final BallCounter counter;

    public BouncingBall(Circle ball, Group parent, double dx, double dy, BallCounter counter) {
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
            //TODO do zmiany, rozmiary rodzica
            if (x - r < 0){
                dx = - dx;
                //liczymy odbicia od lewej ścianki
                counter.increment();
            }
            if (x + r > 600) {
                dx = -dx;
            }
            if (y - r < 0 || y + r > 400) {
                dy = -dy;
            }
            Platform.runLater(() -> {
                ball.setCenterX(ball.getCenterX() + dx);
                ball.setCenterY(ball.getCenterY() + dy);
            });
        }
        System.out.println("Zakończono animację!");
    }
}
