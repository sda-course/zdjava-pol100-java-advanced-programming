package app;

import model.Person;
import repository.PersonRepository;

import java.util.Optional;
import java.util.stream.Stream;

public class Exercise4 {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
        Stream<Person> people = repository.findAll();
        //4.1
        long femaleCount = people
                .filter(person -> person.getName().endsWith("a"))
                .count();
        System.out.println("Liczba kobiet: " + femaleCount);
        people = repository.findAll();
        //4.2
        System.out.println("Suma wag osób urodzonych przed 1990: " +
                people
                        .filter(person -> person.getBirthDate().getYear() < 1990)
                        .map(person -> person.getWeight())
                        .reduce(0d, (a, b) -> a + b)
        );
        //4.3
        Optional<Person> optionalPerson = repository.findAll()
                .filter(person -> "Karol".equals(person.getName()))
                .min((a, b) -> Double.compare(a.getHeight(), b.getHeight()));
        if (optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            System.out.println("Najniższy Karol ma wzrost: " + person.getHeight());
        }
        //4.4
        Optional<Double> maxWeight = repository.findAll()
                .map(person -> person.getWeight())
                .max(Double::compare);
        System.out.println(maxWeight);
    }
}
