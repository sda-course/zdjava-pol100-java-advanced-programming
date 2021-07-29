package javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BouncingApp extends Application {
    public static Random random = new Random();

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400);
        BallCounter counter = new BallCounter();
        Text counterInfo = new Text(20, 40, "Licznik: 0");
        //tworzymy serwis, który zajmuje się uruchamianiem wątków działających okresowo
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(() -> {
            Platform.runLater(() -> {
                counterInfo.setText("Licznik: " + counter.get());
            });
        }, 0, 10, TimeUnit.MILLISECONDS);
        //kolekcja kulek
        List<Circle> balls =
                IntStream.range(0, 10)
                        .mapToObj(i -> new Circle(random.nextInt(600),
                                random.nextInt(400),
                                10 + random.nextInt(10)))
                        .peek(ball -> ball.setFill(Color.rgb(
                                random.nextInt(255),
                                random.nextInt(255),
                                random.nextInt(255))))
                        .collect(Collectors.toList());
        //kolekcja wątków aninimujących kulki
        List<Thread> threads =
                balls.stream().map(ball -> new Thread(new BouncingBall(ball, root, 20, 20, counter)))
                        .collect(Collectors.toList());
        //uruchamiamy wątki z kolekcji
        threads.stream().forEach(thread -> thread.start());
        root.getChildren().addAll(balls);
        root.getChildren().add(counterInfo);
        stage.setScene(scene);
        stage.setTitle("Bouncing ball");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
