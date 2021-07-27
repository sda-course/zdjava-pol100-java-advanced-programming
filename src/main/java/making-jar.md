# Tworzenie paczki jar

## Plik MANIFEST.MF
W katalogu `META-INF` nale�y umie�ci� plik manifestu, w kt�rym jednym z najwa�niejszych element�w jest okre�lenie
punktu wej�cia. Przyk�adowa tre��:
```
Manifest-Version: 1.0
Created-By: 1.7.0_06 (Oracle Corporation)
Main-Class: nazwaKlasy
```
W miejscu `nazwaKlasy` nale�y wpisa� nazw� klasy z metod� `main`. Ta klasa zostanie za�adowana jako pierwsza i 
program zacznie si� od wykonania jej metody `main`.

## Dodanie pluginu w <code>pom.xml</code>
Dodanie tego pluginu powoduje, �e Maven tworzy plik manifestu ze wskazan� klas� stanowi�ca punkt wej�cia.

```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.2.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>app.CityApp</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
W sekcji <code><mainClass>paczka.Klasa</mainClass></code> nale�y wpisa� klas�, kt�ra zawiera metod� `main`.

## Okre�lenie metody `packaging` w `pom.xml`
```xml
<project>
    <packaging>jar</packaging>
    ...
</project>
```


## Kompilacja i tworzenie paczki
Dla skonfigurowanego projektu Maven nale�y wywo�a� cel (View-->Tool Windows-->Maven, ikona z liter� M - Execute Maven goal):
```text
    mvn package
```
To spowoduje, �e zostanie utworzony plik `artifatId-version.jar` w katalogu `target`.

## Uruchomienie
W konsoli systemu operacyjnego np. `cmd.exe` wpisujemy polecenie uruchamiaj�ce paczk� `jar`.

```text
java -jar paczka.jar
```

Aby uzyska� poprawne kodowanie znak�w w UTF-8 (Java koduje znaki w UTF-16) nale�y doda� prze��cznik:
```text
java -jar -Dfile.encoding=UTF-8 paczka.jar
```

W przypdaku pow�ok, kt�re interpretuj� znak kropki nale�y prze��cznik poda� w cudzys�owiu.
```text
java -jar "-Dfile.encoding=UTF-8" paczka.jar
```



