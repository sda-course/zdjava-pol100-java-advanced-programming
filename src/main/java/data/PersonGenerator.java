package data;


import model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonGenerator {
    private final static Random random = new Random();
    private final static String[] names = {
            "Adam",
            "Aleksandra",
            "Beata",
            "Krzysztof",
            "Stefan",
            "Ewa",
            "Karol",
            "Zbigniew",
            "Gerwazy",
            "Konstanty",
            "Scholastyka",
            "Anastazja",
            "Tomasz",
            "Robert",
            "Katarzyna",
            "Karolina"
    };
    private  final static String[] surenames = {
            "Kowalski",
            "Nowak",
            "Kąkol",
            "Abel",
            "Komar",
            "Bąk",
            "Styczeń",
            "Marzec",
            "Biały",
            "Komenda",
            "Popiel",
            "Szary"
    };

    private static final double[] reaminders = { 0, 0.25, 0.5, 0.75, 1.0};

    public static List<Person> generate(int n){
        return Stream
                .generate(() -> new Person(randomName(), randomDouble(40, 100), randomDouble(145, 195), randomDate(LocalDate.EPOCH, LocalDate.of(2005,1, 1))))
                .limit(n)
                .collect(Collectors.toList());
    }

    private static double randomDouble(double min, double max){
        return Math.rint(min + (random.nextDouble() *(max - min))) + reaminders[random.nextInt(reaminders.length - 1)];
    }

    private static LocalDate randomDate(LocalDate min, LocalDate max){
        long epoch = (long) (min.toEpochDay() + random.nextDouble() *(max.toEpochDay() - min.toEpochDay()));
        return LocalDate.ofEpochDay(epoch);
    }

    private static String randomName(){
        return names[random.nextInt(names.length - 1)];
    }
    private static String randomSurename(){
        return surenames[random.nextInt(surenames.length - 1)];
    }
}
