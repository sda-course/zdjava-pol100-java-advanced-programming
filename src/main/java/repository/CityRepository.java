package repository;

import model.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipInputStream;

public class CityRepository implements AutoCloseable{
    private final List<City> cities;

    private CityRepository(List<City> cities) {
        this.cities = cities;
    }

    public static CityRepository from(InputStream input){
        return loadCities(input);
    }

    public static CityRepository fromZip(InputStream input) throws IOException {
        return loadCitiesFromZip(input);
    }

    public Stream<City> findAll(){
        return cities.stream();
    }

    private static CityRepository loadCities(InputStream input){
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
        return new CityRepository(reader.lines().map(line -> City.parse(line, "\\t")).collect(Collectors.toList()));
    }

    private static CityRepository loadCitiesFromZip(InputStream input) throws IOException {
        if (input == null){
            throw new IllegalArgumentException("Strumień nie może być null! Prawdopodobnie podano ścieżkę do nieistniejącego pliku!");
        }
        ZipInputStream zipInputStream = new ZipInputStream(input);
        if (zipInputStream.getNextEntry() != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
            return new CityRepository(reader.lines().map(line -> City.parse(line, "\\t")).collect(Collectors.toList()));
        } else {
            throw new IOException("Nie można odczytać archiwum zip, brak pliku. W archiwum powinien znajdować się jeden plik!");
        }
    }

    @Override
    public void close() throws Exception {

    }
}
