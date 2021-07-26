package app;

import repository.CityRepository;
import java.io.IOException;
import java.io.InputStream;

public class CityApp {
    public static void main(String[] args) {
        try (InputStream input = CityApp.class.getResourceAsStream("../cities500.zip");
             CityRepository repository = CityRepository.fromZip(input);
        ) {

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
