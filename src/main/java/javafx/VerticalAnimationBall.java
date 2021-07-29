package javafx;

import javafx.application.Platform;
import javafx.scene.shape.Circle;

public class VerticalAnimationBall extends Thread {
    private final Circle ball;
    private double dy = 1;

    public VerticalAnimationBall(Circle circle) {
        this.ball = circle;
    }

    @Override
    public void run() {
        double ye = 200 + ball.getCenterY();
        while (ball.getCenterY() < ye) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                        ball.setCenterY(ball.getCenterY() + dy);
                    }
            );
        }
    }
}
