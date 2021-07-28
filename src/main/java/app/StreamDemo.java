package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Names{
    private List<String> names;


    Names(List<String> names) {
        this.names = names;
    }

    //Uwaga, po pobraniu listy można ją wyczyścić, czyli utracimy elementy
    public List<String> getNames() {
        return names;
    }

    public Stream<String> getNamesAsStream(){
        return names.stream();
    }
}

public class StreamDemo {

    public static void main(String[] args) {
        /*
        Cechy strumieni:
        - leniwe przetwarzanie - dopiero wtedy, gdy strumień zakończy się metodą terminalną np. collect, forEach itd.
        - wykonywana jest tylko jedna iteracja po elementach strumienia, operacje pośrednie są składane
        - strumień nie modyfukuje źródła, na podstawie którego został stworzony, tworzy kopię elementów kolekcji
         */
        IntStream.range(0, 100)
                .peek(number -> System.out.println("Peek " + number))
                .filter(number -> {
                    System.out.println("Filter " + number);
                    return number % 2 == 0;
                }).forEach(number -> System.out.println("ForEach " + number));
        Names names = new Names(new ArrayList<>(List.of("Ola", "Ewa")));
        System.out.println(names.getNames());
        names.getNames().add("Karol");
        System.out.println(names.getNames());
        System.out.println(names.getNamesAsStream().collect(Collectors.toList()));
    }

}
