package example;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class HttpClientDemo {
    public static void main(String[] args) throws URISyntaxException {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .handleAsync((response, exception) -> {
                    System.out.println("response");
                    System.out.println(exception);
                    System.out.println(response.body());
                    return response;
                });
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
    }
}
