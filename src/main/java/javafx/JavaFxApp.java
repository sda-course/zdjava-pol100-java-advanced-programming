package javafx;

import app.RepeatApp;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFxApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Rectangle rectangle = new Rectangle(50, 50);
        rectangle.setFill(Color.DARKMAGENTA);
        rectangle.setX(200);
        rectangle.setY(200);
        root.getChildren().add(rectangle);
        Line line = new Line(0,0, 300,300);
        line.setStroke(Color.RED);
        line.setStrokeWidth(3);
        Circle circle = new Circle(100,100, 20);
        circle.setFill(Color.rgb(123, 45, 57));
        root.getChildren().add(circle);
        root.getChildren().add(line);
        circle.setOnMouseClicked(e -> {
            circle.setFill(circle.getFill() == Color.RED ? Color.GREEN : Color.RED);
        });
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
