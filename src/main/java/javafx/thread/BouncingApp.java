package javafx.thread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BouncingApp extends Application {
    public static Random random = new Random();
    public static boolean isTermined = false;
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
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
                        .mapToObj(i -> new Circle(
                                20 + random.nextInt(600 -20),
                                20 + random.nextInt(400 - 20),
                                10 + random.nextInt(10)))
                        .peek(ball -> ball.setFill(Color.rgb(
                                random.nextInt(255),
                                random.nextInt(255),
                                random.nextInt(255))))
                        .collect(Collectors.toList());
        //kolekcja wątków aninimujących kulki
        List<BouncingBall> animations =
                balls.stream().map(ball -> new BouncingBall(ball, root, 1 + random.nextDouble() * 5, 1 + random.nextDouble()* 5, counter))
                        .collect(Collectors.toList());
        List<Thread> threads = animations.stream().map(Thread::new).collect(Collectors.toList());
        //uruchamiamy wątki z kolekcji
        threads.forEach(Thread::start);
        root.getChildren().addAll(balls);
        root.getChildren().add(counterInfo);
        stage.setScene(scene);
        stage.setTitle("Bouncing ball");
        stage.show();
        stage.setOnCloseRequest(e ->{
            threads.forEach(Thread::interrupt);
            System.out.println("suma lokalnych liczników: " + animations.stream().mapToInt(BouncingBall::getLocalCounter).reduce(0, (a,b) -> a + b));
            System.out.println("licznik globalny: " + counter.get());
            service.shutdown();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
