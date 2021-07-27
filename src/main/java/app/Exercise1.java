package app;

import repository.PersonRepository;

import java.time.Month;

public class Exercise1 {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
        //1.1
        repository.findAll()
                .filter(person -> person.getName().length() == 3)
                .forEach(p -> System.out.println(p));
        //1.2
        repository.findAll()
                .filter(person -> person.getName().startsWith("A") && person.getName().endsWith("a"))
                .forEach(p -> System.out.println(p));
        //1.3
        repository.findAll()
                .filter(person -> person.getWeight() > 75)
                .forEach(p -> System.out.println(p));
        //1.4
        repository.findAll()
                .filter(person -> person.getWeight() >= 45 && person.getWeight() <= 64)
                .forEach(p -> System.out.println(p));
        //1.5
        repository.findAll()
                .filter(person -> person.getBirthDate().getMonth() == Month.MAY)
                .forEach(p -> System.out.println(p));
        //1.6
        repository.findAll()
                .filter(person -> person.getBirthDate().getYear() >= 1995 && person.getBirthDate().getYear() <= 2000)
                .forEach(p -> System.out.println(p));
        //1.7
        repository.findAll()
                .filter(person -> !person.getName().endsWith("a") && (int) person.getWeight() == person.getBirthDate().getYear() % 100)
                .forEach(p -> System.out.println(p));
    }
}
