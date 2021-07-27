package app;

import model.Sex;
import repository.PersonRepository;

import java.time.LocalDate;
import java.time.Period;

public class Exercice3 {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
        //3.1
        repository.findAll()
                .map(person -> person.getName().toUpperCase())
                .forEach(System.out::println);
        //3.2
        repository.findAll()
                .map(person -> (int) Math.rint(person.getWeight()))
                .forEach(System.out::println);
        //3.3
        repository.findAll()
                .map(person -> Period.between(person.getBirthDate(), LocalDate.now()))
                .forEach(System.out::println);
        //3.4
        repository.findAll()
                .map(person -> {
                    if (person.getName().endsWith("a")){
                        return Sex.FEMALE;
                    } else {
                        return Sex.MALE;
                    }
                })
                .forEach(System.out::println);
        //3.5
        repository.findAll()
                .map(person -> person.getWeight() / (Math.pow(person.getHeight()/100.0, 2)))
                .forEach(System.out::println);
    }
}
