package app;

import repository.CityRepository;
import repository.PersonRepository;

import java.io.IOException;

public class Exercise2 {



    public static void main(String[] args) throws IOException {
        CityRepository repository =
                CityRepository.fromZip(Exercise2.class.getResourceAsStream("../cities500.zip"));
        repository
                .findAll()
                .filter(city -> city.getCode().equals("US"))
                .forEach(System.out::println);
        //2.1
        System.out.println("Czy istnieje jakiekolwiek miasto o nazwie złożonej z 4 wyrazów: " + repository
                .findAll()
                .anyMatch(city -> city.getName().split("\\s").length == 4)
        );
        //2.2
//        System.out.println("Czy istnieje jakiekolwiek miasto o populacji złożonej z tych samych cyfr: " + repository
////                .findAll()
////                .anyMatch()
////        );
        //2.3
        System.out.println("Czy wszystkie miasta mają nazwy co najmniej 3 literowe: " + repository
                .findAll()
                .allMatch(city -> city.getName().length() >= 3)
        );
        System.out.println("Przykład miasta o nazwie krótszej od 3 znaków: " +
                repository.findAll()
                        .filter(city -> city.getName().length() < 3)
                        .findAny()
                );
        //2.4
        System.out.println("Czy wszystkie miasta mają populację co najmniej 500:  " + repository
                .findAll()
                .allMatch(city -> city.getPopulation() >= 500)
        );
        //napisz wyszukanie jakiegokolwiek miasto o populacji mniejszej od 500
        System.out.println("Przykład miasta o nazwie krótszej od 3 znaków: " +
                repository.findAll()
                        .filter(city -> city.getPopulation() < 500)
                        .findAny()
        );
    }
}
