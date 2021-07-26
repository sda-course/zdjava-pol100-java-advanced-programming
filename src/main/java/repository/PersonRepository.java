package repository;

import data.PersonGenerator;
import model.Person;

import java.util.List;
import java.util.stream.Stream;

public class PersonRepository {
    private final List<Person> people;

    public PersonRepository() {
        this.people = PersonGenerator.generate(1000);
    }

    public void save(Person person){
        people.add(person);
    }

    public boolean remove(Person person){
        return people.remove(person);
    }

    public Person removeByIndex(int index){
        return people.remove(index);
    }

    public Stream<Person> findAll(){
        return people.stream();
    }
}
