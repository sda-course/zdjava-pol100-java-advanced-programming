package model;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {

    public static final long serialVersionUID = 22L;
    public static final int CITY_ID = 0;
    public static final int CITY_NAME = 1;
    public static final int CITY_LONGITUDE = 4;
    public static final int CITY_LATITUDE = 5;
    public static final int CITy_COUNTRY_CODE = 8;
    public static final int CITY_POPULATION = 14;
    public static final int CITY_COUNT_TOKENS = 19;

    private final long id;
    private final String name;
    private final double longitude;
    private final double latitude;
    private final String code;
    private final long population;

    public City(long id, String name, double longitude, double latitude, String code, long population) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.code = code;
        this.population = population;
    }


    public String getName() {
        return name;
    }


    public double getLongitude() {
        return longitude;
    }


    public double getLatitude() {
        return latitude;
    }


    public String getCode() {
        return code;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", code='" + code + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static City parse(String input, String regExpDelimiter) {
        String[] tokens = input.split(regExpDelimiter);
        if (tokens.length < CITY_COUNT_TOKENS){
            throw new IllegalArgumentException("Zbyt mała liczba elementów w łańcuchu wejściowym!");
        }
        return new City(
                Long.parseLong(tokens[CITY_ID]),
                tokens[CITY_NAME],
                Double.parseDouble(tokens[CITY_LONGITUDE]),
                Double.parseDouble(tokens[CITY_LATITUDE]),
                tokens[CITy_COUNTRY_CODE],
                Long.parseLong(tokens[CITY_POPULATION])
        );
    }

    public String format(){
        return String.format("%08d %20s %8.2f %8.2f %,12d %4s", id, name, latitude, longitude, population, code);
    }
}
