package app;

import model.Person;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonApp {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
        List<Person> people = repository.findAll()
                .filter(person -> person.getHeight() > 170)
                .collect(Collectors.toList());
        people.forEach(person -> System.out.println(person));

        //Odpowiednik operacji na strumieniu wyżej
        List<Person> result = new ArrayList<>();
        for(Person person: repository.findAll().collect(Collectors.toList())){
            if (person.getHeight() > 170){
                result.add(person);
            }
        }
        Optional<Person> first = repository.findAll()
                .filter(person -> person.getHeight() > 170)
                .findFirst();
        if (first.isPresent()){
            System.out.println(first.get());
        }
        boolean allNamesWithK = repository.findAll().allMatch(person -> person.getName().startsWith("K"));
        System.out.println(allNamesWithK);
        boolean anyPersonWithK = repository.findAll().anyMatch(person -> person.getName().startsWith("K"));
        System.out.println(anyPersonWithK);
        Function<Person, String> toName = p -> p.getName();
        repository.findAll()
                .map(toName)
                .map(name -> name.toUpperCase())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        Integer sumOfNameLengths = repository.findAll()
                .map(person -> person.getName().length())
                .reduce(0, (accumulator, number) -> accumulator + number);
        String firstLetters = repository.findAll()
                .map(person -> person.getName().substring(0, 1))
                .reduce("", (a, i) -> a + i);
        System.out.println("Lancuch złozony z pierwszych liter imion :" + firstLetters);
        System.out.println("Suma długości wszystkim imion " + sumOfNameLengths);
        Optional<Person> tallestPerson = repository.findAll().max((a, b) -> Double.compare(a.getHeight(), b.getHeight()));
        System.out.println(tallestPerson);
    }
}
