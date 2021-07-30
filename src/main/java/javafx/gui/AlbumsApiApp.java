package javafx.gui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class AlbumsApiApp extends Application {
    static TextField uriText = new TextField("https://jsonplaceholder.typicode.com/albums");
    static Button loadBtn = new Button("Pobierz");
    static TextArea textArea = new TextArea();

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().addAll(uriText, loadBtn, textArea);
        loadBtn.setOnAction(e -> {
            loadJsonToTextArea();
        });
        Scene scene = new Scene(root,400, 300);
        stage.setScene(scene);
        stage.setTitle("Json Api Tester");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    static public void loadJsonToTextArea(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(uriText.getText()))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .handleAsync((response, exeption) ->{
                    if (exeption != null){
                        textArea.setText("Wystąpił wyjątek, nie udało się pobrać danych. " + exeption.getMessage());
                        return response;
                    }
                    //pobranie jsona z odpowiedzi
                    String json = response.body();
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        //deserializacja jednego obiektu w json
                        //Album album = mapper.readValue(json, Album.class);
                        //deserializacja tablicy obiektów w json
                        Album[] albums = mapper.readValue(json, Album[].class);
                        Platform.runLater(() -> {
                            textArea.setText("");
                            Arrays.stream(albums).forEach(album -> textArea.appendText(album.toString()+"\n"));
                        });
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return  response;
        });

    }
}
