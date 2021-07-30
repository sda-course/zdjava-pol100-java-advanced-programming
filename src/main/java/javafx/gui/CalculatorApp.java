package javafx.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    static final Label labelNumberA = new Label("Wpisz liczbę:");
    static final Label labelNumberB = new Label("Wpisz liczbę:");
    static final Label labelResult = new Label("Wynik");
    static final TextField numberA = new TextField("0");
    static final TextField numberB = new TextField("0");
    static final TextField result = new TextField("0");
    static final Button addBtn = new Button("+");
    static final Button mulBtn = new Button("*");
    static final Button rmBtn = new Button("RM");
    static final HBox buttons = new HBox();
    static final VBox root = new VBox();

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        //ustawienie szerokości przycisków
        addBtn.setMinWidth(60);
        mulBtn.setMinWidth(60);
        rmBtn.setMinWidth(60);
        //ustawienie odstępów między dziećmi kontenera
        buttons.setSpacing(10);
        //ustawienie wewnętrznego marginesu kontenera
        buttons.setPadding(new Insets(10));
        //wyrównanie zawartości kontenera do środka (w pionie i poziomie)
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(addBtn, mulBtn, rmBtn);
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(labelResult, result,labelNumberA, numberA, labelNumberB, numberB, buttons);
        //zablokowanie edycji pola, użytkownik nie może zmienić zawartości, ale programowo możemy ją zmieniać
        result.setEditable(false);
        //powiązanie przycisku addBtn z akcją w metodzie addAction
        addActionToButton(addBtn, CalculatorApp::addAction);
        addActionToButton(mulBtn, CalculatorApp::mulAction);
        addActionToButton(rmBtn, CalculatorApp::rmAction);
        Scene scene = new Scene(root,400, 300);
        stage.setScene(scene);
        stage.setTitle("Kalkulator");
        stage.show();
    }
    /*
    Metoda do powiązania aktywacji przycisku z akcją
     */
    static void addActionToButton(Button button, Runnable action){
        button.setOnAction(e -> {
            action.run();
        });
    }

    /*
    Metoda akcji dodawania dwóch liczb z pól numberA i numberB
     */
    static void addAction(){
        result.setText(Double.toString(getDoubleFromTextField(numberA) + getDoubleFromTextField(numberB)));
    }

    static void mulAction(){
        double av = getDoubleFromTextField(numberA);
        double bv = getDoubleFromTextField(numberB);
        result.setText(Double.toString(av * bv));
    }
    static void rmAction(){
        String strResult = CalculatorApp.result.getText();
        numberA.setText(strResult);
    }

    static double getDoubleFromTextField(TextField textField){
        try {
            String str = textField.getText();
            return Double.parseDouble(str);
        }catch (NumberFormatException e){
            return Double.NaN;
        }
    }
}
