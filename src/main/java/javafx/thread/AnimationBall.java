package javafx.thread;

import javafx.application.Platform;
import javafx.scene.shape.Circle;

public class AnimationBall extends Thread{
    private final Circle ball;
    private double dx = 2;

    public AnimationBall(Circle ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        double xe = 200 + ball.getCenterX();
        while(ball.getCenterX() < xe){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                ball.setCenterX(ball.getCenterX() + dx);
            });
        }
    }
}
