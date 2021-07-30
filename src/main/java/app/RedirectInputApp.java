package app;

import javafx.scene.Scene;

import java.util.Scanner;

/**
 * Przekierowanie dany wejściowych z pliku
 * Edit Configuration (między młotkiem a trójkątem)
 *      Modify options
 *          zaznaczyć Redirect Input
 *      w polu Redirect Input from wybrać plik z danymi pasującymi do naszej aplikacji.
 *
 */
public class RedirectInputApp {
    public static void main(String[] args) {
        //Zamiast wpisywać z klawiatury dane, możne je podać z pliku
        //java RedirectInputApp < data.txt
        //w data.txt muszą być dane zgodne z naszym programem, czyli
        //np. 5 Hello
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String message = scanner.nextLine();
        System.out.println(message.trim().repeat(count));
    }
}
