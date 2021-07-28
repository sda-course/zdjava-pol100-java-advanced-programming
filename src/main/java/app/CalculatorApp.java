package app;

public class CalculatorApp {
    public static void main(String[] args) {
        //wpisz kod, który wyświetla help, gdy liczba parametrów jest zero, brak parametrów
        if (args.length == 0) {
            help();
            return;
        }
        if (args.length != 3) {
            error();
            return;
        }
        double a;
        double b;
        try {
            a = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            operandError(args, 0);
            return;
        }
        try{
            b = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            operandError(args, 2);
            return;
        }
        String operator = args[1];
        switch (operator) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case ":":
                System.out.println(a / b);
                break;
            default:
                operatorError();
        }
    }

    private static void operatorError() {
        System.err.println("Nieznany operator!");
    }

    private static void operandError(String[] args, int i) {
        System.err.println("Błędny format liczby dziesiętnej! Wpisałeś: " + args[i]);
    }

    public static void help() {
        //wpisz kod wyświetlający opis działania programu
        System.err.println("Super kalkulator:");
        System.err.println("Wywołanie: CalculatorApp <liczba> <operator> <liczba>");
        System.err.println("-----------------------------------------------------");
        System.err.println("<liczba> - dowolna liczba dziesiętna");
        System.err.println("<operator> - jeden z operatorów: ");
        System.err.println(" + dodanie obu liczb");
        System.err.println(" - odejmowanie obu liczb");
        System.err.println(" * mnożenie obu liczb");
        System.err.println(" : dzielenie obu liczb");
    }

    public static void error() {
        System.err.println("Niepoprawna liczba argumentów. Podaj <liczba> <operator> <liczba!>");
    }
}
