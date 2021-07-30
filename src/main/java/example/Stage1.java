package example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stage1 extends Application {
    static Label amountLabel = new Label("Wpisz kwotę");
    static Button runBtn = new Button("Run");
    static TextField amountField = new TextField();
    static VBox root = new VBox();
    static Scene scene = new Scene(root, 400, 400);
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        buildUI();
        stage.setScene(scene);
        stage.setTitle("Kantorek");
        stage.show();
    }

    public static void buildUI(){
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(amountLabel, amountField, runBtn);
    }
}
