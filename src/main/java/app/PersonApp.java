package app;

import model.Person;
import repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PersonApp {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
        List<Person> people = repository.findAll()
                .filter(person -> person.getHeight() > 170)
                .collect(Collectors.toList());

        for (Person p: people) {
            System.out.println(p);
        }
    }
}
